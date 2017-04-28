package com.project.stockservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This represents 'StockQuoteLog' entity.
 * @author kishor kalapagoor
 *
 */
@Entity
@Table(name = "StockQuoteLog")
public class StockQuoteLog {
  /**
   * default constructor
   */
	public StockQuoteLog() {

	}

	/**
	 * Additional overloaded constructor
	 * @param symbols requested symbols
	 * @param values symbols symbols
	 */
	public StockQuoteLog(String symbols, String values) {
		this.symbols = symbols;
		this.values_list = values;
		this.requestedDate = new Date();
	}

	@Id
	@Column(name = "QUOTE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quoteId;

	@Column(name = "SYMBOLS")
	private String symbols;
	
	@Column(name = "VALUES_LIST")
	private String values_list;
	
	@Column(name = "REQUESTE_DDATE")
	private Date requestedDate;
	

	public String getSymbols() {
		return symbols;
	}

	public void setSymbols(String symbols) {
		this.symbols = symbols;
	}

	public int getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}

	public String getValues_list() {
		return values_list;
	}

	public void setValues_list(String values_list) {
		this.values_list = values_list;
	}

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	@Override
	public String toString() {
		return "StockQuoteLog [quoteId=" + quoteId + ", symbols=" + symbols + ", values_list=" + values_list
				+ ", requestedDate=" + requestedDate + "]";
	}

}
