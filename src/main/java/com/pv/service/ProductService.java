package com.pv.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pv.entity.Category;
import com.pv.entity.Product;
import com.pv.entity.Seller;
import com.pv.exception.CategoryNotPresentException;
import com.pv.exception.ProductNotPresentException;
import com.pv.repository.CategoryRepository;
import com.pv.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	
	
	//For getting all products
   public List<Product> getAllProducts()
   {
	   System.out.println(productRepo.findAll());
	   return productRepo.findAll();
   }
   
 //For getting product by id
   public Product getByProductId(Integer productId)
   {
	   return productRepo.findById(productId).get();
   }
   
 //For getting product by name
   public Product findByProductName(String productName)
   {
	   return productRepo.findByProductName(productName);
   }
   
 //For getting product by category name
   public List<Product> findByProductCategoryName(String categoryName)
   {
	   Category category = categoryRepo.findByCategoryName(categoryName);
	   
	   if(category == null)
	   {
		   throw new CategoryNotPresentException("Category "+categoryName+" is not present in the database");
	   }
	   
	   return productRepo.findByCategory(category);
   } 
   
 //For adding single products
   public String addProduct(Product product)
   {
	   product.setPostedDateTime(LocalDateTime.now());
	   productRepo.saveAndFlush(product);
	   return "Product Added Successfully";
   }
    
   //For adding multiple products
   public String addProducts(List<Product> products)
   {
	   
	   for(Product prod : products)
	   {
		   prod.setPostedDateTime(LocalDateTime.now());
		   
	   }
	   
	   productRepo.saveAllAndFlush(products);
	   return "All Products Added Successfully";
   }
    
   //For updating product
   public ResponseEntity<Object> updateProduct(Integer productId, Product product)
   {
       if(!productRepo.existsById(productId))
       {
    	   throw new ProductNotPresentException("Product is not Present in database");
       }
        
       Product prod = productRepo.findById(productId).get();
       
       prod.setProductID(product.getProductID());
       prod.setProductName(product.getProductName());
       prod.setProductCost(product.getProductCost());
       //prod.setProductWeight(product.getProductWeight());
       prod.setProductQuantity(product.getProductQuantity());
       prod.setProductDescription(product.getProductDescription());
       prod.setPostedDateTime(product.getPostedDateTime());
       prod.setCategory(product.getCategory());
       prod.setSellers(product.getSellers());
       
       productRepo.saveAndFlush(prod);
	   return new ResponseEntity<Object>("Product Updated Successfully", HttpStatus.OK);
   }
   
   //For deleting product
   public ResponseEntity<Object> deleteProduct(Integer productId)
   {
	   if(!productRepo.existsById(productId))
       {
    	   throw new ProductNotPresentException("Product is not Present in database");
       }
	   
	   productRepo.deleteById(productId);
	   
	   return new ResponseEntity<Object>("Product Deleted Successfully", HttpStatus.ACCEPTED);
   }
   
   //For Adding Seller for particular Product
   public ResponseEntity<Object> addProductSeller(Integer productId, List<Seller> sellers)
   {
	   if(!productRepo.existsById(productId))
       {
    	   throw new ProductNotPresentException("Product is not Present in database");
       }
	   
	   
	   Product prod = productRepo.findById(productId).get();
	   
	   prod.setSellers(sellers);
	   
	   productRepo.saveAndFlush(prod);
	   
	   return new ResponseEntity<Object>("Seller for the Product Id "+productId+" is added Successfully", HttpStatus.OK);
   }
   
 //For Adding Category for particular Product(Already saved product) if category is null
   public ResponseEntity<Object> addProductCategory(Integer productId, Category category)
   {
	   if(!productRepo.existsById(productId))
       {
    	   throw new ProductNotPresentException("Product is not Present in database");
       }
	   
	   
	   Product prod = productRepo.findById(productId).get();
	   
	   prod.setCategory(category);
	   
	   productRepo.saveAndFlush(prod);
	   
	   return new ResponseEntity<Object>("Category "+category.getCategoryName()+" for the Product Id "+productId+" is added Successfully", HttpStatus.OK);
   }
   
 //For Adding Product(Not saved product) by searching category by name, as duplicate name category is not allowed
   public ResponseEntity<Object> addProductCategoryName(String categoryName, Product product)
   {
	   
	   Category category = categoryRepo.findByCategoryName(categoryName);
	   
	   if(category == null)
       {
    	   throw new CategoryNotPresentException("Category "+categoryName+" is not Present in database");
       }
	   
	   
	   product.setCategory(category);
	   
	   productRepo.saveAndFlush(product);
	   
	   return new ResponseEntity<Object>("Product is added Successfully", HttpStatus.OK);
   }
}
