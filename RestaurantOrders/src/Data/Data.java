package Data;
import java.io.Serializable;

public class Data implements Serializable {
	private String name;
	private String price;
	private String sales;
	private String assess;

	public Data(String name, String price, String sales, String assess) {
		this.name = name;
		this.price = price;
		this.sales = sales;
		this.assess = assess;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public String getSales() {
		return sales;
	}

	public String getAssess() {
		return assess;
	}

	
}