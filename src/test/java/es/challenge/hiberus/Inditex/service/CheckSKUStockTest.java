/**
 * 
 */
package es.challenge.hiberus.Inditex.service;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import es.challenge.hiberus.inditex.service.CheckSKUStock;
import es.challenge.inditex.domain.ProductSize;
import es.challenge.inditex.domain.StockEntry;

/**
 * @author lgoicoechea
 *
 */
public class CheckSKUStockTest {

	CheckSKUStock mockTest = new CheckSKUStock();

	/**
	 * Test method for {@link es.challenge.hiberus.Inditex.service.CheckSKUStock#checkSKUStockProduct(java.util.ArrayList, java.util.ArrayList)}.
	 */
	@Test
	public final void testCheckSKUStockProduct() {
		int salida[] = { 1, 2, 3, 4, 5 };
		assertArrayEquals( mockTest.checkSKUStockProduct(
								mockTest.getSingletonGlobalsStructure().getSizes(),
								mockTest.getSingletonGlobalsStructure().getStock()),
				salida );
	}
	
	/**
	 * Setup envoiroment for happycase test
	 */
	@Before
	public final void setup() {
		HashMap<Integer, ProductSize> sizes = new HashMap<Integer,ProductSize>();
		for (int i = 1; i < 6; i++) {			
			sizes.put(i,new ProductSize(i,i));
		}
	    ArrayList<StockEntry> stocks = new ArrayList<StockEntry>();
	    for (int i = 1; i < 6; i++) {			
			stocks.add(new StockEntry(i,i));
		}
	    mockTest.loadData(sizes, stocks);
	}

}
