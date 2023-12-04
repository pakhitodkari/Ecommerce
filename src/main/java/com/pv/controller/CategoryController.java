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
import com.pv.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController 
{
	@Autowired
	private CategoryService categoryService;
	
   @GetMapping("/allcategory")
   public List<Category> getAllCategory()
   {
	   return categoryService.getAllCategory();
   }
   
   @GetMapping("/getCategory/{id}")
   public Category getByCategoryId(@PathVariable("id") Integer categoryId)
   {
	   return categoryService.getByCategoryId(categoryId);
   }
   
   @GetMapping("/getCategory/{categoryName}")
   public Category getByCategoryName(@PathVariable("categoryName") String categoryName)
   {
	   return categoryService.findByCategoryName(categoryName);
   }
   
   @GetMapping("/getProducts/{categoryName}")
   public List<Product> getProductsByCategoryName(@PathVariable("categoryName") String categoryName)
   {
	   return categoryService.findProductsByCategoryName(categoryName);
   }
   
   @PostMapping("/addCategory")
   public String addCategory(@RequestBody Category category)
   {
	   return categoryService.addCategory(category);
   }
   
   @PostMapping("/addCategories")
   public String addCategories(@RequestBody List<Category> category)
   {
	   return categoryService.addCategories(category);
   }
   
   @PutMapping("/updateCategory/{id}")
   public ResponseEntity<Object> updateCategory(@PathVariable("id") Integer categoryId, @RequestBody Category category)
   {
	   return categoryService.updateCategory(categoryId, category);
   }
   
   @DeleteMapping("/deleteCategory/{id}")
   public ResponseEntity<Object> deleteCategory(@PathVariable("id") Integer categoryId)
   {
	   return categoryService.deleteCategory(categoryId);
   }
    
   @DeleteMapping("/deleteCategory/{name}")
   public ResponseEntity<Object> deleteByCategoryName(@PathVariable("name") String categoryName)
   {
	   return categoryService.deleteByCategoryName(categoryName);
   }
    
}
