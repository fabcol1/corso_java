package scapping.craiglist;

import java.math.BigDecimal;

public class Item {
	private String title;
	private BigDecimal price;
	private String url;
	
	public String getTitle() {
		return title;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public String getUrl() {
		return url;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
