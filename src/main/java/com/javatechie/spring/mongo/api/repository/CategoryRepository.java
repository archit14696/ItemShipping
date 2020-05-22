package com.javatechie.spring.mongo.api.repository;

import java.math.BigInteger;

import com.javatechie.spring.mongo.api.model.Categories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface CategoryRepository extends MongoRepository<Categories, BigInteger>{

}
