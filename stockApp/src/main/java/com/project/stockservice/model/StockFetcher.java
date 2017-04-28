package com.project.stockservice.model;

import static com.project.stockservice.util.CommonUtils.handleDouble;
import static com.project.stockservice.util.CommonUtils.handleInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.project.stockservice.util.Constants;

/**
 * This class responsible for fetching Stock details
 * 
 * @author kishor kalapagoor
 *
 */
@Component
public class StockFetcher {

	/**
	 * Returns a List of Stock Objects that contains info about a specified stock. 
	 * @param symbol the company's stock symbol,sperated by delimiter
	 * @return  a stock object containing info about the company's stock
	 */
	public ArrayList<Stock> getStock(String symbol) {
		double price = 0.0;
		int volume = 0;
		double pe = 0.0;
		double eps = 0.0;
		double week52low = 0.0;
		double week52high = 0.0;
		double daylow = 0.0;
		double dayhigh = 0.0;
		double movingav50day = 0.0;
		double marketcap = 0.0;
		double shortRatio = 0.0;
		double open = 0.0;
		double previousClose = 0.0;
		String name = "";
		String currency = "";
		String sym = "";
		ArrayList<Stock> stockList = null;
		String exchange;
		try {
			// Retrieve CSV File
			URL yahoo = new URL("http://download.finance.yahoo.com/d/quotes.csv?s=" + symbol + "&f=l1vr2ejkghm3j3nc4s7pox");
			URLConnection connection = yahoo.openConnection();
			InputStreamReader is = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(is);
			StringTokenizer st = new StringTokenizer(symbol, Constants.DELIMITER_1);
			// Parse CSV Into Array
			String line = null;
			// Only split on commas that aren't in quotes
			stockList = new ArrayList<Stock>();
			while ((line = br.readLine()) != null) {
				String[] stockinfo = line.split(Constants.CSV_REGEX);
				price = handleDouble(stockinfo[0]);
				volume = handleInt(stockinfo[1]);
				pe = handleDouble(stockinfo[2]);
				eps = handleDouble(stockinfo[3]);
				week52low = handleDouble(stockinfo[4]);
				week52high = handleDouble(stockinfo[5]);
				daylow = handleDouble(stockinfo[6]);
				dayhigh = handleDouble(stockinfo[7]);
				movingav50day = handleDouble(stockinfo[8]);
				marketcap = handleDouble(stockinfo[9]);
				name = stockinfo[10].replace(Constants.DELIMITER_4, "");
				currency = stockinfo[11].replace(Constants.DELIMITER_4, "");
				shortRatio = handleDouble(stockinfo[12]);
				previousClose = handleDouble(stockinfo[13]);
				open = handleDouble(stockinfo[14]);
				exchange = stockinfo[15].replace(Constants.DELIMITER_4, "");
				// if more tokens available get the symbols.
				if (st.hasMoreTokens()) {
					sym = st.nextToken();
				}
				stockList.add(new Stock(sym, price, volume, pe, eps, week52low, week52high, daylow, dayhigh,
						movingav50day, marketcap, name, currency, shortRatio, previousClose, open, exchange));
			}
		} catch (IOException e) {
			Logger log = Logger.getLogger(StockFetcher.class.getName());
			log.log(Level.SEVERE, e.toString(), e);
			return null;
		}

		return stockList;

	}
}
