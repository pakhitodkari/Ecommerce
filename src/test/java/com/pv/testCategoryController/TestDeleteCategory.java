package com.pv.testCategoryController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

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
import com.pv.service.CategoryService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestDeleteCategory 
{
	
	@InjectMocks
	private CategoryController categoryController;
	
	@Mock
	private CategoryService categoryService;
	
	
	@Test
	@DisplayName(value = "Delete valid category")
	public void testDeleteValidCategory()
	{
		
		when(categoryService.deleteCategory(1)).thenReturn(new ResponseEntity<Object>("Category Deleted Successfully", HttpStatus.ACCEPTED));
		
		ResponseEntity<Object> response = categoryController.deleteCategory(1);
		
		assertThat(response.getBody()).isEqualTo("Category Deleted Successfully");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
	}
	
	
	@Test
	@DisplayName(value = "Delete Invalid category")
	public void testDeleteInvalidCategory()
	{
		
		when(categoryService.deleteCategory(-1)).thenReturn(new ResponseEntity<Object>("Invalid Category Not Exits", HttpStatus.NOT_ACCEPTABLE));
		
		ResponseEntity<Object> response = categoryController.deleteCategory(-1);
		
		assertThat(response.getBody()).isEqualTo("Invalid Category Not Exits");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
	}
}
