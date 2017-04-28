/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.project.stockservice.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Size;

import org.jboss.logging.annotations.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.mq.sample.Producer;
import com.project.stockservice.model.StockQuoteLog;
import com.project.stockservice.service.StockService;

/**
 * This class is responsible for processing requested stock details. * 
 * @author kishor kalapagoor
 *
 */
@Controller
@RequestMapping("/stock")
public class StockController {

	private static final Logger logger = LoggerFactory.getLogger(StockController.class);
	
	@Autowired
	private StockService stockService;
	
	  private static final String DEFAULT_HOST = "localhost";
	  private final static String QUEUE_NAME = "test-queue";
	  
   
	/**
	 * This method responsible for return Use any public stock quote service(e.g. yahoo, google finance etc..) 
	 * to get the value.  In addition to returning the value as a string persist the stock symbol, 
	 * value.  
	 * Persist any other attributes in the table you see fit.
	 * @param symbols requested stock symbols.
	 * @return value list for requested stocks.
	 */
	@RequestMapping(value="/getQuote", method = RequestMethod.GET,produces="application/json")	
	public @ResponseBody List<Double> getStockQuote(@RequestParam(required = true, value = "symbols") String symbols) {
		logger.info("Start Get Stock Quote Details for symbols"+symbols+"for /getQuote");
		List<Double> stockList=stockService.getStockValues(symbols);
		Producer  producer = new Producer(QUEUE_NAME, DEFAULT_HOST);
		 for(Double message : stockList)
	      producer.send(String.valueOf(message));
		
		return stockService.getStockValues(symbols);		
	}

	/**
	 * This method responsible to find out Stock Logs based on provided date.
	 * @param startDate this represent 'start date', from where user requested log records.
	 * @return list of stock quote logs
	 */
	@RequestMapping(value="/geQuoteLog",method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<StockQuoteLog> geQuoteLog(@RequestParam(required = true, value = "startDate") String startDate) {
		try {
			logger.info("Start Get Stock Quote Details for startDate"+startDate+"for /geQuoteLog");
			return stockService.listStockQuoteLogByDate(startDate);
		} catch (ParseException e) {			
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This method responsible to find out Stock Logs based on provided date.
	 * @param startDate this represent 'start date', from where user requested log records.
	 * @return CSV file based on stock
	 */
	@RequestMapping(value = "/geQuoteLog.csv")
	public void geQuoteLogCSV(HttpServletResponse response,@RequestParam(required = true, value = "startDate") String startDate) 
	{     
		logger.info("Start Get Stock Quote Details for startDate"+startDate+"for /geQuoteLog.csv");
	    response.setContentType("text/plain; charset=utf-8");
	    try {			
		response.getWriter().print(stockService.listStockQuoteLogByDate(startDate));
			
		} catch (IOException|ParseException e) {			
			e.printStackTrace();
		}
	}
}
