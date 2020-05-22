package com.javatechie.spring.mongo.api.resource;

import java.math.BigInteger;
import java.util.*;


import com.javatechie.spring.mongo.api.model.Categories;
import com.javatechie.spring.mongo.api.model.Item;
import com.javatechie.spring.mongo.api.model.MinPrice;
import com.javatechie.spring.mongo.api.model.Sellers;
import com.javatechie.spring.mongo.api.repository.CategoryRepository;
import com.javatechie.spring.mongo.api.repository.PriceRepository;
import com.javatechie.spring.mongo.api.repository.SellerRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.javatechie.spring.mongo.api.model.Book;
//import com.javatechie.spring.mongo.api.repository.BookRepository;

@RestController
public class WebController {

	@Autowired
	private CategoryRepository category_repository;

	@PostMapping("/addConfigCategory")
	public String addCategory(@RequestBody Categories category) {
		category_repository.save(category);
		return "Added category with id : " + category.getId();
	}
	@DeleteMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable BigInteger id) {
		category_repository.deleteById(id);
		return "Category deleted with id : " + id;
	}
	@Autowired
	private SellerRepository seller_repository;
	@PostMapping("/addConfigSeller")
	public String addSeller (@RequestBody Sellers seller) {
		seller_repository.save(seller);
		return "Added seller with id : " + seller.getId();
	}
	@DeleteMapping("/deleteSeller/{id}")
	public String deleteSeller(@PathVariable BigInteger id) {
		seller_repository.deleteById(id);
		return "Seller deleted with id : " + id;
	}
	@Autowired
	private PriceRepository price_repository;

	@PostMapping("/addConfigMinPrice")
	public String addMinPrice(@RequestBody MinPrice minPrice) {
		if(price_repository.findAll()!=null){
			price_repository.deleteAll();
		price_repository.save(minPrice);
		}
		else{
		 	price_repository.save(minPrice);
			 }
		return "Updated min price";
	}

	// @Autowired
	// private PriceRepository price_repository;
	// @PostMapping("/addConfigMinPrice")
	// public String addMinPrice (@RequestBody MinPrice min_price) {
	// 	//if(price_repository.findAll()!=null){
	// 	//price_repository.deleteAll();
	// 	price_repository.save(min_price);
	// 	//}
	// 	// else{
	// 	// 	price_repository.save(min_price);
	// 	// }
	// 	return "Updated Min Price";
	// }

	@PostMapping("/shippingValidity")
    public String Service(@RequestBody Item inputPayload) {
        //PostResponse response = new PostResponse();

        return isValid(inputPayload,price_repository,seller_repository,category_repository);
      

	}
	public static String isValid(Item item,PriceRepository price_repository,SellerRepository seller_repository,CategoryRepository category_repository){

        //List<ConfigureCategory> categories=category_repository.findAll();
	   // List<ConfigureSellers> sellers=seller_repository.findAll();
	   
        List<Integer> categories=new ArrayList();
		List<String> sellers=new ArrayList();
		
       MinPrice min_price=price_repository.findAll().get(0);
       double min=min_price.getMinPrice();
       
        int category=item.getCategory();
        double price=item.getPrice();
        String username=item.getUsername();
        String message="Item is ineligible for shipping";

        for(Categories c:category_repository.findAll()){
			categories.add(c.getCategory());
			 
        }
        for(Sellers s:seller_repository.findAll()){
            sellers.add(s.getSeller());
        }
        if(categories.contains(category) && sellers.contains(username) && price>=min){
            message="Item is eligible for shipping";
            return message;
           
        }
        //System.out.println(categories);
        
        return message;
	}

	// @GetMapping("/findAllBooks")
	// public List<Book> getBooks() {
	// 	return repository.findAll();
	// }

	// @GetMapping("/findAllBooks/{id}")
	// public Optional<Book> getBook(@PathVariable int id) {
	// 	return repository.findById(id);
	// }

	// @DeleteMapping("/delete/{id}")
	// public String deleteBook(@PathVariable int id) {
	// 	repository.deleteById(id);
	// 	return "book deleted with id : " + id;
	}


