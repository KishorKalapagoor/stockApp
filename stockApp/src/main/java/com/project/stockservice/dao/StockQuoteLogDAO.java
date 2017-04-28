package com.project.stockservice.dao;

import java.text.ParseException;
import java.util.List;

import com.project.stockservice.model.StockQuoteLog;
/**
 * This contract declares required database operation in context of 'Stock Quote Log'
 * @author kishor kalapagoor
 *
 */
public interface StockQuoteLogDAO {
	
	/**
	 * This method responsible to add  Stock Quote Logs.
	 * @param StockQuoteLog the record which is going  to be persist.
	 */
	public void addStockQuoteLog(StockQuoteLog stql);
	
	/**
	 * This method responsible to find out Stock Logs based on provided date.
	 * @param startDate  this represent 'start date', from where user requested log records.
	 */
	public List<StockQuoteLog> listStockQuoteLogByDate(String startDate) throws ParseException;
}
