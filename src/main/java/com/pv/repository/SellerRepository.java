package com.pv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pv.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer>
{
 
	public Seller findBySellerEmail(String sellerEmail);
	
	public List<Seller> findBySellerName(String sellerName);
}
