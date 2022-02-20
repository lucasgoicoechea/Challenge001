package es.challenge.hiberus.inditex.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.challenge.inditex.domain.ProductSize;
import es.challenge.inditex.domain.StockEntry;
import es.challenge.inditex.structure.SingletonGlobalsStructure;

/**
 * @author lgoicoechea
 * 
 */
public class CheckSKUStock {

	public void loadData(Map<Integer, ProductSize> sizes, List<StockEntry> stocks) {
		SingletonGlobalsStructure.getSingletonGlobalsStructure(sizes, stocks);
	}

	public SingletonGlobalsStructure getSingletonGlobalsStructure() {
		return SingletonGlobalsStructure.getSingletonGlobalsStructure();
	}

	public int[] checkSKUStockProduct(Map<Integer, ProductSize> sizes, List<StockEntry> stocks) {
		ProductSize tmpProductoSize;
		// update stock product
		for (StockEntry stockEntry : stocks) {
			// Case without Stock, remove size
			if (stockEntry.getQuantity() == 0) {
				sizes.remove(stockEntry.getSizeId());
			} else {
				// case with stock, update stock asssociative
				tmpProductoSize = sizes.get(stockEntry.getSizeId());
				tmpProductoSize.setStockEntry(stockEntry);
				sizes.put(stockEntry.getSizeId(), tmpProductoSize);
			}
		}

		Map<String, ProductSize> systemSizesStrings = new HashMap<>();
		sizes.values().removeIf(value -> value.getStockEntry() == null);
		sizes.values().forEach(value -> {
			if (this.checkAndUpdateEquivalentsSystemSize(value, systemSizesStrings))
				systemSizesStrings.put(String.valueOf(value.getSizeSystem()), value);
			else
				sizes.remove(value.getId());
		});

		int[] result = {};
		sizes.keySet().forEach(value -> result[result.length] = value);
		return result;
	}

	private boolean checkAndUpdateEquivalentsSystemSize(ProductSize productSize,
			Map<String, ProductSize> systemSizesStrings) {
		Set<String> list = systemSizesStrings.keySet();
		for (String strSystemSize : list) {
			if (strSystemSize.contains(String.valueOf(productSize.getSizeSystem()))) {
				if (systemSizesStrings.get(strSystemSize).getStockEntry().getQuantity() < productSize.getStockEntry()
						.getQuantity()) {
					systemSizesStrings.remove(strSystemSize);
					return true;
				}
				return false;
			}
		}
		return true;
	}

	public String checkSKUStockProduct() {
		int[] intArray = checkSKUStockProduct(SingletonGlobalsStructure.instance().getSizes(),
				SingletonGlobalsStructure.instance().getStock());
		return Arrays.toString(intArray).replace("\\[-\\]", "");
	}

}
