package com.pv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pv.entity.Seller;
import com.pv.exception.SellerNotPresentException;
import com.pv.repository.SellerRepository;

@Service
public class SellerService 
{
	@Autowired
	private SellerRepository sellerRepo;
	
	
	//For all Seller List
	public List<Seller> getAllSellers()
	{
		return sellerRepo.findAll();
	}
	
	//For getting particular Seller by Seller ID
    public Seller getSeller(Integer sellerId)
	{
    	if(!sellerRepo.existsById(sellerId))
    	{
    		throw new SellerNotPresentException("Seller of seller id "+sellerId+" not present in database");
    	}
    	
	  return sellerRepo.findById(sellerId).orElseThrow(() -> new SellerNotPresentException("Seller of seller id "+sellerId+" not present in database"));
	}
    
    //For getting Seller by Email
    public Seller getBySellerEmail(String sellerEmail)
    {
    	Seller seller = sellerRepo.findBySellerEmail(sellerEmail);
    	
    	if(seller == null)
    	{
    		throw new SellerNotPresentException("Seller of Email "+sellerEmail+" not present in database");
    	}
    	
    	return seller;
    }
    
    //For getting Seller by Name
    public List<Seller> getBySellerName(String sellerName)
    {
    	List<Seller> sellers = sellerRepo.findBySellerName(sellerName);
    	
    	if(sellers.isEmpty())
    	{
    		throw new SellerNotPresentException("Seller of Name "+sellerName+" not present in database");
    	}
    	
    	return sellers;
    }
    
    //For Adding Seller by checking Email if it is present or not
    public ResponseEntity<Object> addSeller(Seller seller)
    {
    	Seller seller1 = sellerRepo.findBySellerEmail(seller.getSellerEmail());
    	
    	if(seller1 == null)
    	{
    		sellerRepo.saveAndFlush(seller);
    		return new ResponseEntity<>("Seller is Added Successfully", HttpStatus.ACCEPTED);
    	}
    	
    	return new ResponseEntity<>("Seller is Already Present in Database", HttpStatus.CONFLICT);
    }
    
  //For Adding Seller List
    public ResponseEntity<Object> addSellers(List<Seller> sellers)
    {
    	
    	sellerRepo.saveAllAndFlush(sellers);
    		
    	return new ResponseEntity<>("Sellers List is Added Successfully", HttpStatus.ACCEPTED);
    	
    }
    
    //For Updating Seller by Id
    public ResponseEntity<Object> updateSeller(Integer sellerId, Seller seller)
    {
    	if(!sellerRepo.existsById(sellerId))
    	{
    		throw new SellerNotPresentException("Seller of id "+sellerId+" not present in database");
    	}
    	
    	Seller seller1 = sellerRepo.findById(sellerId).orElseThrow(() -> new SellerNotPresentException("Seller of seller id "+sellerId+" not present in database"));
    	
    	seller1.setSellerID(seller.getSellerID());
    	seller1.setSellerName(seller.getSellerName());
    	seller1.setSellerEmail(seller.getSellerEmail());
    	seller1.setSellerPhone(seller.getSellerPhone());
    	seller1.setSellerAddress(seller.getSellerAddress());
    	seller1.setProducts(seller.getProducts());
    	
    	sellerRepo.saveAndFlush(seller1);
    	
    	return new ResponseEntity<>("Seller is Updated Successfully", HttpStatus.ACCEPTED);
    }
    
  //For Updating Seller by Email
    public ResponseEntity<Object> updateBySellerEmail(String sellerEmail, Seller seller)
    {
    	
        Seller seller1 = sellerRepo.findBySellerEmail(sellerEmail);
    	
    	if(seller1 == null)
    	{
    		throw new SellerNotPresentException("Seller of Email "+sellerEmail+" not present in database");
    	}
    	
    	seller1.setSellerID(seller.getSellerID());
    	seller1.setSellerName(seller.getSellerName());
    	seller1.setSellerEmail(seller.getSellerEmail());
    	seller1.setSellerPhone(seller.getSellerPhone());
    	seller1.setSellerAddress(seller.getSellerAddress());
    	seller1.setProducts(seller.getProducts());
    	
    	sellerRepo.saveAndFlush(seller1);
    	
    	return new ResponseEntity<>("Seller is Updated Successfully", HttpStatus.ACCEPTED);
    }
    
  //For Deleting Seller 
    public ResponseEntity<Object> deleteSeller(Integer sellerId)
    {
    	
    	if(!sellerRepo.existsById(sellerId))
    	{
    		throw new SellerNotPresentException("Seller of seller id "+sellerId+" not present in database");
    	}
    	
    	sellerRepo.deleteById(sellerId);
    		
    	return new ResponseEntity<>("Seller is Deleted Successfully", HttpStatus.OK);
    	
    }
    
}
