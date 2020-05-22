package com.javatechie.spring.mongo.api.model;

import java.math.BigInteger;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "MinPrice")
public class MinPrice {
	@Id
	private BigInteger _id;
	private double minPrice;
	public BigInteger getId(){
		return _id;
	  }
	  
	public double getMinPrice() {
		return minPrice;
    }
    public void setId(BigInteger _id){
		this._id=_id;
	  }
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
    
}