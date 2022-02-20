package es.challenge.inditex.domain;


public class ProductSize {
    
	private int id;
	private int sizeSystem;
	private StockEntry stockEntry;
 
	public ProductSize(int id, int sizeSystem) {
		this.id = id;
		this.sizeSystem = sizeSystem;
	}
	
	public void setStockEntry(StockEntry stockEntry) {
		this.stockEntry = stockEntry;
	}
	
	public StockEntry getStockEntry() {
		return stockEntry;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setSizeSystem(int sizeSystem) {
		this.sizeSystem = sizeSystem;
	}
	
	public int getSizeSystem() {
		return sizeSystem;
	}
	
}
