package model;

public class model {
	
	private String code, nama, harga ,stock;
	
	public model() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public String getNama() {
		return nama;
	}

	
	public String getHarga() {
		return harga;
	}

	
	public String getStock() {
		return stock;
	}

	public model (String code, String nama, String harga , String stock) {
		super();
		this.code = code;
		this.nama = nama;
		this.harga = harga;
		this.stock = stock;
	}


	
}
