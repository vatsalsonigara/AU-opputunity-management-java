package com.accolite.au.dao;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.accolite.au.dao.OpportunityDaoImpl;
import com.accolite.au.exception.ResourceNotFoundException;
import com.accolite.au.model.Opportunity;
import com.accolite.au.service.OpportunityRowMapper;
import com.accolite.au.dao.*;
import com.accolite.au.service.*;

//import com.accolite.Model.Opportunity;
//import com.accolite.Service.OpportunityRowMapper;
//import com.accolite.au.RestController;
//import com.sun.org.apache.bcel.internal.generic.NEW;
@RunWith(SpringRunner.class)
@SpringBootTest
class OpportunityDaoImplTest {

	@Autowired
	private OpportunityDaoImpl oppDao;
	
	@MockBean
	private JdbcTemplate template;
	
	@Test
	public void getAllTest() {
		when(template.query(Mockito.anyString(),Mockito.any(Object[].class),Mockito.any(OpportunityRowMapper.class))).thenReturn(Stream
				.of(new Opportunity("Software Eng","Suresh","Vatsal","vat@gg.com","Java","banglore",1,2,"31/05/20"),
						new Opportunity("Software Eng","Vatsal","Vatsal","vat@gg.com","Java","banglore",1,2,"31/05/20"))
				.collect(Collectors.toList()));
	
		assertEquals(2,oppDao.getAllOpportunity().size());
	}
	@Test
	public void deleteOpptest() {
		int id=5;
		when(template.update(Mockito.anyString(),Mockito.any(Integer.class))).thenReturn(1);
		assertEquals(true, oppDao.deleteOpportunity(id));
	}
	@Test
	public void insertRecordTest() {
		Opportunity op = new Opportunity("Software Eng","Suresh","Vatsal","vat@gg.com","Java","banglore",1,2,"31/05/20");
		when(template.update(Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString())).thenReturn(1);
		assertEquals(true, oppDao.insertOpportunity(op));
	}
	@Test
	public void updateRecordTest() {
		Opportunity op = new Opportunity("Software Eng","Suresh","Vatsal","vat@gg.com","Java","banglore",1,2,"31/05/20");
		when(template.update(Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString(),
				Mockito.anyString())).thenReturn(1);
		assertEquals(true, oppDao.updateOpportunity(op));
	}
	@Test
	public void getRecordTest() throws ResourceNotFoundException {
		int id =5;
		Opportunity op = new Opportunity("Software Eng","Suresh","Vatsal","vat@gg.com","Java","banglore",1,2,"31/05/20");
		when(template.query(Mockito.anyString(),Mockito.any(Object[].class),Mockito.any(OpportunityRowMapper.class))
				).thenReturn(List.of(op));
		assertEquals(op, oppDao.getOpportunity(id));
	}
	

}
