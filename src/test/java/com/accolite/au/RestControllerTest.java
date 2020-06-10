package com.accolite.au;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.accolite.au.dao.OpportunityDao;
import com.accolite.au.dao.OpportunityDaoImpl;
import com.accolite.au.exception.ResourceNotFoundException;
import com.accolite.au.model.Opportunity;

@RunWith(SpringRunner.class)
@SpringBootTest
class RestControllerTest {

	@MockBean
	private OpportunityDaoImpl oppDao;
	
	@Autowired
	private RestController rs;
	
	@Test
	public void getAllTest() throws ResourceNotFoundException {
		when(oppDao.getAllOpportunity()).thenReturn(Stream
				.of(new Opportunity("Software Eng","Suresh","Vatsal","vat@gg.com","Java","banglore",1,2,"31/05/20"),
						new Opportunity("Software Eng","Vatsal","Vatsal","vat@gg.com","Java","banglore",1,2,"31/05/20"))
				.collect(Collectors.toList()));
	
		assertEquals(2,rs.getAllRecords().size());
	}
	@Test
	public void deleteOpptest() {
		int id=5;
		when(oppDao.deleteOpportunity(id)).thenReturn(true);
		assertEquals("Deleted Successfully!", rs.deleteRecord(id));
	}
	@Test
	public void insertRecordTest() {
		Opportunity op = new Opportunity("Software Eng","Suresh","Vatsal","vat@gg.com","Java","banglore",1,2,"31/05/20");
		when(oppDao.insertOpportunity(op)).thenReturn(true);
		assertEquals(op, rs.insert(op));
	}
	@Test
	public void updateRecordTest() {
		Opportunity op = new Opportunity("Software Eng","Suresh","Vatsal","vat@gg.com","Java","banglore",1,2,"31/05/20");
		when(oppDao.updateOpportunity(op)).thenReturn(true);
		assertEquals(op, rs.update(op));
	}
	
}
