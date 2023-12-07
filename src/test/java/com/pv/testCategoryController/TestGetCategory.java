package com.pv.testCategoryController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.pv.controller.CategoryController;
import com.pv.entity.Category;
import com.pv.entity.Product;
import com.pv.service.CategoryService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TestGetCategory 
{
	
	@InjectMocks
	private CategoryController categoryController;
 	
	@Mock
	private CategoryService categoryService;
	
	
	@Test
	@DisplayName(value = "Check all the categories")
	public void testGetAllCategory()
	{
		 //Category category = new Category();
		
		 //List<Seller> sellers = new ArrayList<>();
		
		when(categoryService.getAllCategory()).thenReturn(new ArrayList<Category>());
		
		assertThat(categoryController.getAllCategory()).isEqualTo(new ArrayList<Category>());
		
		
	}
	
	@Test
	@DisplayName(value = "Get category for given id")
	public void testGetCategoryById() {
		
		
		when(categoryService.getByCategoryId(1)).thenReturn(new Category());
		
		Category category = categoryController.getByCategoryId(1);
		
		assertThat(category).isNotNull();
	}
	
	@Test
	@DisplayName(value = "Get category for given invalid id")
	public void testGetCategoryByInvalidId() {
		
		
		when(categoryService.getByCategoryId(1)).thenReturn(null);
		
		Category category = categoryController.getByCategoryId(1);
		
		assertThat(category).isNull();
	}
	
	
	@Test
	@DisplayName(value = "Get category for given category name")
	public void testGetCategoryByName() {
		
		
		when(categoryService.findByCategoryName("Grocery")).thenReturn(new Category());
		
		Category category = categoryController.getByCategoryName("Grocery");
		
		assertThat(category).isNotNull();
	}
	
	@Test
	@DisplayName(value = "Get product list for given category name")
	public void testGetProductByCategoryName() {
		
		
		when(categoryService.findProductsByCategoryName("Grocery")).thenReturn(new ArrayList<Product>());
		
		List<Product> product = categoryController.getProductsByCategoryName("Grocery");
		
		assertThat(product).isNotNull();
	}
	
}
