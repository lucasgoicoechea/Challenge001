package es.challenge.inditex.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.challenge.inditex.domain.ProductSize;
import es.challenge.inditex.domain.StockEntry;

public class SingletonGlobalsStructure {


	private Map<Integer, ProductSize> sizes = new HashMap<>();
	private List<StockEntry> stock = new ArrayList<>();
 	private static SingletonGlobalsStructure singletonGlobalsStructure = null;
 
	public static SingletonGlobalsStructure getSingletonGlobalsStructure(Map<Integer, ProductSize> sizes, List<StockEntry> stock) {
	 
		 if (singletonGlobalsStructure==null) {
			 singletonGlobalsStructure=new SingletonGlobalsStructure(sizes,stock);
		 }
		 return singletonGlobalsStructure;
	 }
	
	public static SingletonGlobalsStructure getSingletonGlobalsStructure() {
		 if (singletonGlobalsStructure==null) {
			 singletonGlobalsStructure=new SingletonGlobalsStructure(null,null);
		 }
		 return singletonGlobalsStructure;
	}
	
	private SingletonGlobalsStructure(Map<Integer, ProductSize> sizes, List<StockEntry> stock2) {
		 this.sizes=sizes;
		 this.stock=stock2;
	}
	 
 	public void setSizes(Map<Integer, ProductSize> sizes) {
 		this.sizes = sizes;
	}
	 
	public void setStock(List<StockEntry> stock) {
		this.stock = stock;
	}
	
	public Map<Integer, ProductSize> getSizes() {
		return sizes;
	}
	
	public List<StockEntry> getStock() {
		return stock;
	}

	public static SingletonGlobalsStructure instance() {
		return SingletonGlobalsStructure.getSingletonGlobalsStructure();
	}

}
