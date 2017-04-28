package com.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.project.Application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class StockControllerTest {

	@Value("${local.server.port}")
	private int port;

	/**
	 * 
	 * Case 1: base service response data validation
	 */
	/*@Test
	public void testBaseURL() throws Exception {
		ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + this.port, String.class);
	    System.out.println("http://localhost:" + this.port);
		assertEquals(HttpStatus.OK, entity.getStatusCode());		
	}*/
	
	/**
	 * 
	 * Case 2: GetStockQuote response data validation
	 */
	@Test
	public void testGetStockQuote() throws Exception {
		ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + this.port+"/stock/getQuote?symbols=FB+BAC+F+BMY", String.class);
	    System.out.println("http://localhost:" + this.port);
		assertEquals(HttpStatus.OK, entity.getStatusCode());	
		assertTrue(entity.getBody().length()>1);
		//Need to test json data format 
		//number of elements out put.
	}
	
	/**
	 * 
	 * Case 3: GetQuoteLog response data validation
	 */
	
	@Test
	public void tesGetQuoteLog() throws Exception {
		ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + this.port+"/stock/geQuoteLog?startDate=26-01-2017", String.class);
	    System.out.println("http://localhost:" + this.port);
		assertEquals(HttpStatus.OK, entity.getStatusCode());	
		assertTrue(entity.getBody().indexOf("quoteId")>1);
		//Need to test json data format
	}
	
	/**
	 * 
	 * Case 4:  Get QuoteLog CSV response data validation
	 */
	@Test
	public void testGetQuoteLogCSV() throws Exception {
		ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + this.port+"/stock/geQuoteLog.csv?startDate=26-01-2017", String.class);
	    System.out.println("http://localhost:" + this.port);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertTrue(entity.getBody().indexOf("quoteId")>1);
		//Need to test json data format
	}

}
