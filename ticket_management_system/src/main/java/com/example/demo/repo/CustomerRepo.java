package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerVO;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerVO, Long> {
	
	//native query for select2
	@Query(value= "select * from customer_table where (lower(customer_name) like lower(concat('%',?1,'%')))",nativeQuery = true)
	public List<CustomerVO> findByname(String customerName);

}
