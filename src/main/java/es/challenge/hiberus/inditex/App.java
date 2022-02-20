package es.challenge.hiberus.inditex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.challenge.hiberus.inditex.service.CheckSKUStock;
import es.challenge.inditex.domain.ProductSize;
import es.challenge.inditex.domain.StockEntry;

/**
 * @author lgoicoechea
 *
 */
public class App {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(App.class.getName());
		logger.info("Starting run SKu-stock");
		CheckSKUStock serviceCheckSKUStock = new CheckSKUStock();
		HashMap<Integer, ProductSize> sizes = new HashMap<>();
		ArrayList<StockEntry> stocks = null;
		serviceCheckSKUStock.loadData(sizes, stocks);
		logger.log(Level.INFO,"Results to process: {0}",serviceCheckSKUStock.checkSKUStockProduct());
	}
}
