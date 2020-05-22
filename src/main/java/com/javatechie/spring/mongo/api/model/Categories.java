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

@Document(collection = "categories")
public class Categories {
	@Id
	private BigInteger _id;
	private int category;
	public BigInteger getId(){
		return _id;
	  }
	  public int getCategory() {
		  return category;
	  }
	  public void setId(BigInteger _id){
		this._id=_id;
	  }
	  
	  
	  public void setCategory(int category) {
		  this.category = category;
	  }
}
