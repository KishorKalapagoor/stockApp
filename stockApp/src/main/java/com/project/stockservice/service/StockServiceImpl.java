package com.project.stockservice.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.stockservice.dao.StockQuoteLogDAO;
import com.project.stockservice.model.Stock;
import com.project.stockservice.model.StockFetcher;
import com.project.stockservice.model.StockQuoteLog;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * This implementation defines required service operation in context of 'Stock Quote Log'
 * @author kishor kalapagoor
 *
 */
@Component
public class StockServiceImpl implements StockService {
	
	private static final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

	@Autowired
	StockQuoteLogDAO  stockQuoteLogDAO;
	@Autowired
	StockFetcher stockFetcher;
	
	
	/**
	 *@see com.project.stockservice.service.StockService#getStockValues(java.lang.String) 
	 */
	@Override
	public List<Double> getStockValues(String symbols)
	{
		logger.debug("the process:get Stock Values  started for requested symbols :"+symbols);
		//requested symbols come with delimiter empty space
		//so we have to replace it by delimiter '+'
		symbols=symbols.replaceAll(" ", "+");
		ArrayList<Stock> stockList=stockFetcher.getStock(symbols);
		logger.debug("Got stocks from service:"+stockList);		
		
		/*ArrayList<Double> valueList = stockList.stream()
                .map(Stock::getPrice)
                .collect(Collectors.toCollection(ArrayList::new));*/		
		
		List<Double> valueList = new ArrayList<Double>();
		for (Stock s : stockList) {
			valueList.add(s.getPrice());
		}        
		logger.debug("Got stock values:"+valueList);
		//make values as on string
		String values=StringUtils.join(valueList.toArray(),",");
		StockQuoteLog stql=new StockQuoteLog(symbols,values);
		stockQuoteLogDAO.addStockQuoteLog(stql);
		logger.info("Stock values persisted for QuoteId:"+stql.getQuoteId());
	    return valueList;
	}
	
	/**
	 * @see com.project.stockservice.service.StockService#listStockQuoteLogByDate(java.lang.String)
	 */
	@Override
	public List<StockQuoteLog> listStockQuoteLogByDate(String startDate) throws ParseException
	{
		logger.info("the process:get list Stock Quote Log By Date is started for start Date :"+startDate);
		return stockQuoteLogDAO.listStockQuoteLogByDate(startDate);
	}

}
