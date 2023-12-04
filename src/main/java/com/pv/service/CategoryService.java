package com.pv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pv.entity.Category;
import com.pv.entity.Product;
import com.pv.exception.CategoryNotPresentException;
import com.pv.repository.CategoryRepository;

@Service
public class CategoryService 
{

	@Autowired
	private CategoryRepository categoryRepo;
	
	
	//For getting all category
   public List<Category> getAllCategory()
   {
	   return categoryRepo.findAll();
   }
   
 //For getting category by id
   public Category getByCategoryId(Integer categoryId)
   {
	   if(!categoryRepo.existsById(categoryId))
	   {
		   throw new CategoryNotPresentException("Category for Category Id "+categoryId+" is not present in database");
	   }
	   
	   return categoryRepo.findById(categoryId).orElse(null);
   }
   
 //For getting category by name
   public Category findByCategoryName(String categoryName)
   {
	   
	   Category category1 = categoryRepo.findByCategoryName(categoryName);
	   
	   if(category1 == null)
       {
    	   throw new CategoryNotPresentException("Category is not Present in database");
       }
	   
	   return category1;
   }
   
 //For getting products by category name
   public List<Product> findProductsByCategoryName(String categoryName)
   {
	   
	   Category category1 = categoryRepo.findByCategoryName(categoryName);
	   
	   if(category1 == null)
       {
    	   throw new CategoryNotPresentException("Category is not Present in database");
       }
	   
	   List<Product> prods = category1.getProducts();
	   
	   return prods;
   }
 
 //For adding single category
   public String addCategory(Category category)
   {
	   categoryRepo.saveAndFlush(category);
	   return "Category Added Successfully";
   }
    
   //For adding multiple category
   public String addCategories(List<Category> categories)
   {
	   categoryRepo.saveAllAndFlush(categories);
	   return "All Categories Added Successfully";
   }
    
   //For updating category
   public ResponseEntity<Object> updateCategory(Integer categoryId, Category category)
   {
       if(!categoryRepo.existsById(categoryId))
       {
    	   throw new CategoryNotPresentException("Category of Category ID "+categoryId+" is not Present in database");
       }
        
       Category category1 = categoryRepo.findById(categoryId).get();
       
       category1.setCategoryID(category.getCategoryID());
       category1.setCategoryName(category.getCategoryName());
       category1.setCategoryDescription(category.getCategoryDescription());
       category1.setProducts(category.getProducts());
       
       categoryRepo.saveAndFlush(category1);
	   return new ResponseEntity<Object>("Category Updated Successfully", HttpStatus.OK);
   }
   
   //For deleting category
   public ResponseEntity<Object> deleteCategory(Integer categoryId)
   {
	   if(!categoryRepo.existsById(categoryId))
       {
    	   throw new CategoryNotPresentException("Category is not Present in database");
       }
	   
	   categoryRepo.deleteById(categoryId);
	   
	   return new ResponseEntity<Object>("Category Deleted Successfully", HttpStatus.ACCEPTED);
   }
   
 //For deleting category by Name
   public ResponseEntity<Object> deleteByCategoryName(String categoryName)
   {
	   Category category1 = categoryRepo.findByCategoryName(categoryName);
	   
	   if(category1 == null)
       {
    	   throw new CategoryNotPresentException("Category is not Present in database");
       }
	   
	   categoryRepo.delete(category1);
	   
	   return new ResponseEntity<Object>("Category "+categoryName+" is Deleted Successfully", HttpStatus.ACCEPTED);
   }
   
}
