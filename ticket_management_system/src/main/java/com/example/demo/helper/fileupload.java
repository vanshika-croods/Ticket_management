package com.example.demo.helper;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component

public class fileupload {
public  final String upload_dir = "C:\\Users\\ishan\\Documents\\workspace-spring-tool-suite-4-4.10.0.RELEASE\\example_multiple_file_upload\\src\\main\\resources\\static\\image";
	
	public boolean uploadfile(MultipartFile f){
		
		boolean f1 = false;
		try {
			
			InputStream is = f.getInputStream();
			byte data[] = new byte[is.available()];
			is.read(data);
			
			//write to the folder here
			FileOutputStream fo = new FileOutputStream(upload_dir+"\\"+f.getOriginalFilename());
			fo.write(data);
			fo.close();
			fo.flush();
			
			is.close();
			f1=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f1;
		
	}

}
