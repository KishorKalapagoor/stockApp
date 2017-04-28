package com.project.stockservice.model;

public class Stock {
    /**
     * The company stock symbol
     */
	private String symbol;
	 /**
     * The company stock symbol
     */
	private double price;
	
	 /**
     * The company stock volume
     */
	private int volume;
	
	 /**
     * The stock Earnings per Share
     */
	private double pe;
	
	 /**
     * stock's Estimate Next Quarter
     */
	private double eps;
	 /**
     * 52 week Low
     */
	private double week52low;
	 /**
     *  52 Week High
     */
	private double week52high;
	 /**
     * Day’s Low
     */
	private double daylow;
	 /**
     * Day’s High
     */
	private double dayhigh;
	 /**
     * 50 Day Moving Average
     */
	private double movingav50day;
	 /**
     * The stock symbol
     */
	private double marketcap;
	 /**
     * The stock name
     */
	private String name;
	 /**
     * The stock currency
     */
	private String currency;
	 /**
     * short Ratio
     */
	private double shortRatio;
	 /**
     * The stock symbol
     */
	private double previousClose;
	 /**
     * The stock opened with value
     */
	private double open;
	
	 /**
     * The stock exchange
     */
	private String exchange;

	
	/**
	 * Default constructor
	 */
	public Stock() {

	}

	public Stock(String symbol, double price, int volume, double pe, double eps, double week52low, double week52high,
			double daylow, double dayhigh, double movingav50day, double marketcap, String name, String currency,
			double shortRatio, double previousClose, double open, String exchange) {
		this.symbol = symbol;
		this.price = price;
		this.volume = volume;
		this.pe = pe;
		this.eps = eps;
		this.week52low = week52low;
		this.week52high = week52high;
		this.daylow = daylow;
		this.dayhigh = dayhigh;
		this.movingav50day = movingav50day;
		this.marketcap = marketcap;
		this.name = name;
		this.currency = currency;
		this.shortRatio = shortRatio;
		this.previousClose = previousClose;
		this.open = open;
		this.exchange = exchange;
	}

	public String getExchange() {
		return this.exchange;
	}

	public double getPreviousClose() {
		return this.previousClose;
	}

	public double getOpen() {
		return this.open;
	}

	public double getShortRatio() {
		return this.shortRatio;
	}

	public String getCurrency() {
		return this.currency;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public double getPrice() {
		return this.price;
	}

	public int getVolume() {
		return this.volume;
	}

	public double getPe() {
		return this.pe;
	}

	public double getEps() {
		return this.eps;
	}

	public double getWeek52low() {
		return this.week52low;
	}

	public double getWeek52high() {
		return this.week52high;
	}

	public double getDaylow() {
		return this.daylow;
	}

	public double getDayhigh() {
		return this.dayhigh;
	}

	public double getMovingav50day() {
		return this.movingav50day;
	}

	public double getMarketcap() {
		return this.marketcap;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", price=" + price + ", volume=" + volume + ", pe=" + pe + ", eps=" + eps
				+ ", week52low=" + week52low + ", week52high=" + week52high + ", daylow=" + daylow + ", dayhigh="
				+ dayhigh + ", movingav50day=" + movingav50day + ", marketcap=" + marketcap + ", name=" + name
				+ ", currency=" + currency + ", shortRatio=" + shortRatio + ", previousClose=" + previousClose
				+ ", open=" + open + ", exchange=" + exchange + "]";
	}
}
