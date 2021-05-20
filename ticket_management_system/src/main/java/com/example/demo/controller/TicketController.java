package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.helper.fileupload;
import com.example.demo.model.CustomerVO;
import com.example.demo.model.TicketVO;
import com.example.demo.repo.TicketRepo;
import com.example.demo.service.CustomerService;
import com.example.demo.service.TicketService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private fileupload fileupload;

	@Autowired
	private TicketRepo ticketRepo;
	
	@PostMapping("/saveticket")
	public ModelAndView saveTicket(@RequestParam(value ="file", required=false) MultipartFile file,@ModelAttribute TicketVO ticketVO) throws Exception{
		
		//file upload here

		boolean f = fileupload.uploadfile(file);
		if(f) {
			System.out.println("file successfully uploaded");
		}
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
	    String strDate= formatter.format(date); 
	    ticketVO.setTicketDate(strDate);
	    CustomerVO customerVO = ticketVO.getCustomerVO();
	    System.out.println(customerVO);
	    ticketVO.setCustomerVO(customerVO);
	    ticketService.insert(ticketVO);
	    System.out.println("ticket inserted in database");
		return new ModelAndView("redirect:/viewsupport");
				
	}
	
	@ResponseBody
	@RequestMapping(value = "/data/users", method = RequestMethod.POST)
	public DataTablesOutput<TicketVO> getUsers(@Valid @RequestBody DataTablesInput input) {
	    return ticketRepo.findAll(input);
	}
	
	@GetMapping("/ticket/{ticketId}/delete")
	public String delete(@PathVariable long ticketId) {
		ticketService.deleteTicket(ticketId);
		System.out.println("data deleted successfully!!");
		return "redirect:/viewsupport";
	}
	
	@GetMapping("/customer/select/json")
    @ResponseBody
    public String productVariantMultiSelectJSON(@RequestParam Map<String, String> allRequestParams,  HttpSession session) {
        JSONArray array = new JSONArray();

		JSONArray jsonArray;
        JSONObject jsonObject;

        System.out.println("------" + allRequestParams.get("customerName").toString());
        jsonArray = new JSONArray();
        jsonObject = new JSONObject();

        List<CustomerVO> customerVO = customerService.findByCutomerName(allRequestParams.get("customerName").toString());
        
        for (int i = 0; i < customerVO.size(); i++) {
        	
        	JSONObject json1 = new JSONObject();
        	try {
              json1.put("id",customerVO.get(i).getCustomerId());
              json1.put("text", customerVO.get(i).getCustromerName());

          } catch (Exception e) {
          }
        	jsonArray.add(json1);
        	
		}

//        customerVO.forEach(p -> {
////            p.setContactAddressVos(null);
//            JSONObject json1 = new JSONObject();
//            try {
//                json1.put("id", p.getCustomer_id());
//                json1.put("text", p.getCustromerName());
//
//            } catch (Exception e) {
//            }
//
//            array.(json1);
//        });
//        <c:forEach items="${productType}" var="productType">
////	        <option value="${productType.supplierTypeId}"> ${productType.supplierTypeName} </option>
////	 </c:forEach> 
        try {
            jsonObject.put("total_count", customerVO.size());
            jsonObject.put("incomplete_results", true);
            jsonObject.put("items", jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
	//fb.com/janamsoni/posts/1/commetns
//	@GetMapping("editCustomer/{username}/posts/{postId}/comments/{commentId}")

	//edit ticketSupport
	
	@GetMapping("editCustomer/{ticketId}")
	public ModelAndView editCustomer(@PathVariable long ticketId) {
		ModelAndView view = new ModelAndView();
		view.setViewName("editSupport");
		TicketVO listSuppoprt = ticketService.findById(ticketId);
		view.addObject("editSupport", listSuppoprt);
		return view;
	}
	
}
