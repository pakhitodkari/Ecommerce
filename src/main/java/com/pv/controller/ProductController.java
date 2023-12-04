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

import com.pv.entity.Category;
import com.pv.entity.Product;
import com.pv.entity.Seller;
import com.pv.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
   @GetMapping("/allproducts")
   public List<Product> getAllProducts()
   {
	   return productService.getAllProducts();
   }
   
   @GetMapping("/getProduct/{id}")
   public Product getByProductId(@PathVariable("id") Integer productId)
   {
	   return productService.getByProductId(productId);
   }

   @GetMapping("/getProducts/{categoryName}")
   public List<Product> getByProductCategory(@PathVariable("categoryName") String categoryName)
   {
	   return productService.findByProductCategoryName(categoryName);
   }
   
   @GetMapping("/{name}")
   public Product getByProductName(@PathVariable("name") String productName)
   {
	  return productService.findByProductName(productName);
   }
   
   @PostMapping("/addProduct")
   public String addProduct(@RequestBody Product product)
   {
	   return productService.addProduct(product);
   }
   
   @PostMapping("/addProducts")
   public String addProducts(@RequestBody List<Product> products)
   {
	   return productService.addProducts(products);
   }
   
   @PutMapping("/updateProduct/{id}")
   public ResponseEntity<Object> updateProduct(@PathVariable("id") Integer productId, @RequestBody Product product)
   {
	   return productService.updateProduct(productId, product);
   }
   
   @DeleteMapping("/deleteProduct/{id}")
   public ResponseEntity<Object> deleteProduct(@PathVariable("id") Integer productId)
   {
	   return productService.deleteProduct(productId);
   }
    
   //For adding seller details for particular product
   @PutMapping("/addProductSeller/{ProductId}")
   public ResponseEntity<Object> addProductSeller(@PathVariable("ProductId") Integer productId, @RequestBody List<Seller> sellers)
   {
	   return productService.addProductSeller(productId, sellers);
   }
   
 //For adding category details for particular product, if category is null
   @PutMapping("/addProductCategory/{productId}")
   public ResponseEntity<Object> addProductCategory(@PathVariable("productId") Integer productId, @RequestBody Category category)
   {
	   return productService.addProductCategory(productId, category);
   }
   
   //For adding category for product from category table, as duplicate name category is not allowed
   @PostMapping("/addProductCategory/{categoryName}")
   public ResponseEntity<Object> addProductCategoryName(@PathVariable("categoryName") String categoryName, @RequestBody Product product)
   {
	   return productService.addProductCategoryName(categoryName, product);
   }
}
