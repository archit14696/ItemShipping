package com.javatechie.spring.mongo.api.model;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


public class Item {

	private String title;
    private String seller;
    private int category;
    private double price;
    public String getTitle() {
		return title;
	}
	public String getUsername() {
		return seller;
    }
    public int getCategory() {
		return category;
    }
    public double getPrice(){
        return price;
    }
	public void setTitle(String title) {
		this.title = title;
	}
	public void setUsername(String seller) {
		this.seller = seller;
	}
    public void setCategory(int category) {
		this.category = category;
    }
    public void setPrice(double price) {
		this.price = price;
	}

}