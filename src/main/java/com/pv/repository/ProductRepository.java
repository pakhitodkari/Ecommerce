package com.pv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pv.entity.Category;
import com.pv.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>
{
   public Product findByProductName(String productName);
   
   public List<Product> findByCategory(Category category);
   
   
   @Query(value = "SELECT p FROM Product p WHERE p.productCost BETWEEN ?1 AND ?2")
   public List<Product> findProductByPriceRange(Double price1, Double price2);
}
