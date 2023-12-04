package com.pv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pv.entity.Seller;
import com.pv.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController 
{
	@Autowired
	private SellerService sellerService;
	
	
	@GetMapping("/allSeller")
	public List<Seller> getAllSeller()
	{
		return sellerService.getAllSellers();
	}
	
	@GetMapping("/getSeller/{id}")
	public Seller getSeller(@PathVariable("id") Integer sellerId)
	{
		return sellerService.getSeller(sellerId);
	}
	
	@GetMapping("/getSeller/{email}")
	public Seller getBySellerEmail(@PathVariable("email") String sellerEmail)
	{
		return sellerService.getBySellerEmail(sellerEmail);
	}
	
	@GetMapping("/getSeller/{name}")
	public List<Seller> getSellerName(@PathVariable("name") String sellerName)
	{
		return sellerService.getBySellerName(sellerName);
	}
	
	@PostMapping("/addSeller")
	public ResponseEntity<Object> addSeller(@RequestBody Seller seller)
	{
		return sellerService.addSeller(seller);
	}
	
	@PostMapping("/addSellers")
	public ResponseEntity<Object> addSellers(@RequestBody List<Seller> sellers)
	{
		return sellerService.addSellers(sellers);
	}
	
	@PutMapping("/updateSeller/{id}")
	public ResponseEntity<Object> updateSeller(@PathVariable("id") Integer sellerId, @RequestBody Seller seller)
	{
		return sellerService.updateSeller(sellerId, seller);
	}
	
	@PutMapping("/updateSeller/{email}")
	public ResponseEntity<Object> updateSellerByEmail(@PathVariable("email") String sellerEmail, @RequestBody Seller seller)
	{
		return sellerService.updateBySellerEmail(sellerEmail, seller);
	}
	
	@DeleteMapping("/deleteSeller/{id}")
	public ResponseEntity<Object> deleteSellerById(@PathVariable("id") Integer sellerId)
	{
		return sellerService.deleteSeller(sellerId);
	}
}
