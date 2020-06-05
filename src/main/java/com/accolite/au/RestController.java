package com.accolite.au;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import DAO.OpportunityDao;
import DAO.OpportunityDaoImpl;
import DAO.UserDao;
import DAO.UserDaoImpl;
import Model.Opportunity;
import Model.User;
import Service.OpportunityRowMapper;

@org.springframework.web.bind.annotation.RestController 
public class RestController {
	static OpportunityDao opd=new OpportunityDaoImpl();
	static UserDao usd = new UserDaoImpl();
	@GetMapping("/get-all-opp")
	@CrossOrigin
	public List<Opportunity> getAllRecords(){
		//if(checkAuthorization(email, token)) return
		return opd.getAllOpportunity();
	}
	@PostMapping("/insert")
	@CrossOrigin
	public boolean insert(@RequestBody Opportunity op) {
		//System.out.println(op);
		//if(checkAuthorization(email, token)) return null;
		return opd.insertOpportunity(op);
	}
	@PostMapping("/update")
	@CrossOrigin
	public boolean update(@RequestBody Opportunity op) {
		//if(checkAuthorization(email, token)) return null;
		return opd.updateOpportunity(op);
	}
	
	@GetMapping("/delete-opp/{id}")
	@CrossOrigin
	public boolean deleteRecord(@PathVariable int id) {
		//if(checkAuthorization(email, token)) return null;
		return opd.deleteOpportunity(id);
	}
	@GetMapping("/get-opp/{id}")
	@CrossOrigin
	public Opportunity getRecord(@PathVariable int id) {
		//if(checkAuthorization(email, token)) return null;
		return opd.getOpportunity(id);
	}
	
	@PostMapping("/login")
	@CrossOrigin
	public int signIn(@RequestBody User user) {
		return usd.signIn(user);
	}
	@PostMapping("/logout")
	@CrossOrigin
	public void signOut(@RequestBody User user) {
		//tokenMapper.remove(user.getEmail());
		usd.signOut(user);
	}
	@PostMapping("/delete-user")
	@CrossOrigin
	public boolean deleteUser(@RequestBody User user) {
		return usd.deleteUser(user);
	}
//   
//	private static boolean checkAuthorization(String email,String token) {
//		return tokenMapper.get(email).equals(token); 
//	}
}
