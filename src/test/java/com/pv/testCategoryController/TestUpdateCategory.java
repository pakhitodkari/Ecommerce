package com.pv.testCategoryController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pv.controller.CategoryController;
import com.pv.entity.Category;
import com.pv.entity.Product;
import com.pv.service.CategoryService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TestUpdateCategory 
{

	@InjectMocks
	private CategoryController categoryController;
	
	@Mock
	private CategoryService categoryService;
	
	
	@Test
	@DisplayName(value = "Update valid Category")
	 void testUpdateValidCategory()
	{
		Category category = new Category(1,"abc","jkl",new ArrayList<Product>());
		
		when(categoryService.updateCategory(1,category)).thenReturn(new ResponseEntity<Object>("Category Updated Successfully", HttpStatus.OK));
		
		ResponseEntity<Object> response = categoryController.updateCategory(1, category);
		
		assertThat(response.getBody()).isEqualTo("Category Updated Successfully");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	
	@Test
	@DisplayName(value = "Update Invalid products")
	 void testUpdateInvalidProduct()
	{
		
		Category category = new Category(1,"abc","jkl",new ArrayList<Product>());
		
		when(categoryService.updateCategory(-1,category)).thenReturn(new ResponseEntity<Object>("Category Not Exits", HttpStatus.NOT_ACCEPTABLE));
		
		ResponseEntity<Object> response = categoryController.updateCategory(-1, category);
		
		assertThat(response.getBody()).isEqualTo("Category Not Exits");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
	}

}
