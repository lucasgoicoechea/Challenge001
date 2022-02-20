package es.challenge.inditex.domain;

public class StockEntry {
	
	private int sizeId;
	private int quantity;
	
	public StockEntry(int id, int quantity) {
		this.sizeId = id;
		this.quantity = quantity;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	
	public int getSizeId() {
		return sizeId;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}

}
