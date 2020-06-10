package com.accolite.au;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.accolite.au.dao.OpportunityDao;
import com.accolite.au.dao.OpportunityDaoImpl;
import com.accolite.au.dao.UserDao;
import com.accolite.au.dao.UserDaoImpl;
import com.accolite.au.exception.ResourceNotFoundException;
import com.accolite.au.model.Opportunity;
import com.accolite.au.model.User;
import com.accolite.au.service.OpportunityRowMapper;
@CrossOrigin(origins = "*")
@org.springframework.web.bind.annotation.RestController 
public class RestController {
	
	@Autowired
	private OpportunityDaoImpl opd;
	
	@Autowired
	private UserDao usd;
	@GetMapping("/get-all-opp")
	
	public List<Opportunity> getAllRecords() throws ResourceNotFoundException{		
		return opd.getAllOpportunity();
	}
	@PostMapping("/insert")
	
	public Opportunity insert(@RequestBody Opportunity op) {

		opd.insertOpportunity(op);
		return op;
	}
	@PostMapping("/update")
	 
	public Opportunity update(@RequestBody Opportunity op) {
		opd.updateOpportunity(op);
		return op;
	}
	
	@GetMapping("/delete-opp/{id}")
	 
	public String deleteRecord(@PathVariable int id) {
	
		opd.deleteOpportunity(id);
		return "Deleted Successfully!";
	}
	@GetMapping("/get-opp/{id}")
	 
	public Opportunity getRecord(@PathVariable int id) throws ResourceNotFoundException{
		return opd.getOpportunity(id);
	}
	
	@GetMapping("/login")
	 
	public int signIn() {
		return 1;//usd.signIn(user);
	}
	@PostMapping("/logout")
	 
	public void signOut(@RequestBody User user) {
		usd.signOut(user);
	}
	@PostMapping("/delete-user")
	 
	public boolean deleteUser(@RequestBody User user) {
		return usd.deleteUser(user);
	}

}
