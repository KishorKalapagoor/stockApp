package com.project.stockservice.service;

import java.text.ParseException;
import java.util.List;

import com.project.stockservice.model.StockQuoteLog;

/**
 * This contract defines required service operations in context of 'Stock Quote Log'
 * @author kishor kalapagoor
 *
 */
public interface StockService {

	/**
	 * This method responsible to add  Stock Quote Logs.
	 * @param StockQuoteLog the record which is going  to be persist.
	 * @return list of stock values
	 */
	List<Double> getStockValues(String symbols);

	/**
	 * This method responsible to find out Stock Logs based on provided date.
	 * @param startDate  this represent 'start date', from where user requested log records.
	 * @return list of stock quote logs
	 */
	List<StockQuoteLog> listStockQuoteLogByDate(String startDate) throws ParseException;

}