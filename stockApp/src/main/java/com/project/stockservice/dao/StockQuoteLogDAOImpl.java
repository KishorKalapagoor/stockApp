package com.project.stockservice.dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.project.stockservice.model.StockQuoteLog;
import com.project.stockservice.util.Constants;

/**
 * This implementation defines required database operation in context of 'Stock Quote Log'
 * @author kishor kalapagoor
 *
 */
@Repository
@Transactional
public class StockQuoteLogDAOImpl implements StockQuoteLogDAO {

	private static final Logger logger = LoggerFactory.getLogger(StockQuoteLogDAOImpl.class);

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	/**
	 * This method responsible to add  Stock Quote Logs.
	 * @param StockQuoteLog the record which is going  to be persist.
	 */
	public void addStockQuoteLog(StockQuoteLog stql) {		
		Session session = this.sessionFactory.getCurrentSession();
		logger.debug("Before StockQuoteLog saved successfully, StockQuoteLog Details=>" + stql);
		session.persist(stql);
		logger.info("StockQuoteLog saved successfully, StockQuoteLog Details=" + stql);
	}
	
	/**
	 * This method responsible to find out Stock Logs based on provided date.
	 * @param startDate  this represent 'start date', from where user requested log records.
	 * @return list of stock quote logs
	 */
	@SuppressWarnings("unchecked")
	public List<StockQuoteLog> listStockQuoteLogByDate(String startDate) throws ParseException {
		logger.debug("The processes:List of StockQuoteLogs based on date started for startDate:"+startDate);
		Session session = this.sessionFactory.getCurrentSession();
		List<StockQuoteLog> stockQuoteLogList = null;
		SimpleDateFormat sf=new SimpleDateFormat(Constants.REQUEST_DATE_FORMAT);
		Date fromDate=null;
		fromDate = sf.parse(startDate);
		Query query=session.createQuery("from StockQuoteLog where requestedDate BETWEEN :startDate AND :toDate");
		query.setParameter("startDate", fromDate);
		//	to_char(eventDate, 'yyyy-mm-dd')
		query.setParameter("toDate", new Date());
		stockQuoteLogList=query.list();
		logger.info("StockQuoteLog List between "+fromDate+" AND "+new Date()+" => "+stockQuoteLogList);
		logger.debug("The processes:List of StockQuoteLogs based on date Ended");
		return stockQuoteLogList;
	}

}
