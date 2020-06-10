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
		//if(checkAuthorization(email, token)) return
		
		return opd.getAllOpportunity();
	}
	@PostMapping("/insert")
	
	public Opportunity insert(@RequestBody Opportunity op) {
		//System.out.println(op);
		//if(checkAuthorization(email, token)) return null;
		opd.insertOpportunity(op);
		return op;
	}
	@PostMapping("/update")
	 
	public Opportunity update(@RequestBody Opportunity op) {
		//if(checkAuthorization(email, token)) return null;
		opd.updateOpportunity(op);
		return op;
	}
	
	@GetMapping("/delete-opp/{id}")
	 
	public String deleteRecord(@PathVariable int id) {
		//if(checkAuthorization(email, token)) return null;
		opd.deleteOpportunity(id);
		return "Deleted Successfully!";
	}
	@GetMapping("/get-opp/{id}")
	 
	public Opportunity getRecord(@PathVariable int id) throws ResourceNotFoundException{
		//if(checkAuthorization(email, token)) return null;
		return opd.getOpportunity(id);
	}
	
	@GetMapping("/login")
	 
	public int signIn() {
		return 1;//usd.signIn(user);
	}
	@PostMapping("/logout")
	 
	public void signOut(@RequestBody User user) {
		//tokenMapper.remove(user.getEmail());
		usd.signOut(user);
	}
	@PostMapping("/delete-user")
	 
	public boolean deleteUser(@RequestBody User user) {
		return usd.deleteUser(user);
	}
//   
//	private static boolean checkAuthorization(String email,String token) {
//		return tokenMapper.get(email).equals(token); 
//	}
}
