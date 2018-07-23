/**
 * <p>Project: org.radnahs.tryOut.wissen </p>
 * <p>Package Name: org.radnahs.tryOut.wissen </p>
 * <p>File Name: Problem1.java </p>
 * <p>Create Date: Jun 23, 2017 </p>
 * <p>Create Time: 5:46:03 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.wissen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: Shantanu Sikdar
 */
public class Problem1 {

	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		
		class Stock{
			private String symbol;
			private double price;
			public String getSymbol() {
				return symbol;
			}
			public void setSymbol(String symbol) {
				this.symbol = symbol;
			}
			public double getPrice() {
				return price;
			}
			public void setPrice(double price) {
				this.price = price;
			}
		}

		
        Map<String, List<Stock>> stockMap= new HashMap<>();
		@Override
		public void putNewPrice(String symbol, double price) {
		// YOUR CODE HERE
		    if(stockMap.containsKey(symbol)){
		    	List<Stock> lst = stockMap.get(symbol);
		    	Stock stck = new Stock();
		    	stck.setSymbol(symbol);
		    	stck.setPrice(price);
		    	lst.add(stck);
		    	stockMap.put(symbol, lst);
		    }else{
		    	List<Stock> lst = new ArrayList<>();
		    	Stock stck = new Stock();
		    	lst.add(stck);
		    	stockMap.put(symbol, lst);
		    }	    
		}

		@Override
		public double getAveragePrice(String symbol) {
		// YOUR CODE HERE
			System.out.println(stockMap);
			List<Stock> lst = stockMap.get(symbol);
			double total=0;
			for (Stock stock : lst) {
				total+=stock.getPrice();
			}
			return total/lst.size();
		}

		@Override
		public int getTickCount(String symbol) {
		// YOUR CODE HERE
			List<Stock> lst = stockMap.get(symbol);
			return lst.size();
		}
	}
	
	
	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
	
	

}
