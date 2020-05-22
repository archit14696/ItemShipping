package com.javatechie.spring.mongo.api.model;

import java.math.BigInteger;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// import lombok.Getter;
// import lombok.Setter;
// import lombok.ToString;

// @Getter
// @Setter
// @ToString

@Document(collection = "sellers")
public class Sellers {
	@Id
	private BigInteger _id;
	private String seller;
	public BigInteger getId(){
		return _id;
	  }
	  public String getSeller() {
		return seller;
		}
	  
	  
	  public void setId(BigInteger _id){
		this._id=_id;
	  }
	  public void setSeller(String seller) {
		this.seller = seller;
	  }
}