package com.crs.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crs.bean.Complaint;
import com.crs.service.ComplaintService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class ComplaintController {

	@Autowired
	ComplaintService crservice;
	
	@PostMapping("/complaintinsert")
	public void performInsert(@RequestBody Complaint complaint) {
	    crservice.insert(complaint);
	}
	
	@PutMapping("/complaintupdate")
	public void performUpdate(@RequestBody Complaint complaint) {
	    crservice.update(complaint);	
	}
	
	@DeleteMapping("/complaintdelete/{complaintId}")
	public void performDelete(@PathVariable("complaintId") long complaintId) {
		crservice.delete(complaintId);
	}
	
	@GetMapping("/complaintview/{userName}")
	public List<Complaint> viewComplaintDetails(@PathVariable("userName") String userName){
	    return crservice.getComplaintDetails(userName);
		
	}
	
	@GetMapping("/complaintviewAll")
	public List<Complaint> viewAllComplaintDetails(){
		return crservice.getAllComplaintDetails();
	}
	
}
