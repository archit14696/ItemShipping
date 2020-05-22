package com.javatechie.spring.mongo.api.repository;


import java.math.BigInteger;

import com.javatechie.spring.mongo.api.model.MinPrice;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface PriceRepository extends MongoRepository<MinPrice, BigInteger>{

}