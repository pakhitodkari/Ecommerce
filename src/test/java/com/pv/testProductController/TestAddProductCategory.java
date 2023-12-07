package com.pv.testProductController;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pv.controller.ProductController;
import com.pv.entity.Category;
import com.pv.entity.Product;
import com.pv.service.ProductService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TestAddProductCategory 
{

	@InjectMocks
	private ProductController prodController;
	
	@Mock
	private ProductService prodService;
	
	
	@Test
	@DisplayName(value = "Add Category for valid products")
	public void testAddCategoryValidProduct()
	{
		List<Product> product = new ArrayList<>();
		
		Category category = new Category(1,"jskjn","bebk",product);
		
		when(prodService.addProductCategory(1, category)).thenReturn(new ResponseEntity<Object>("Category for the Product Id is added Successfully", HttpStatus.OK));
		
		ResponseEntity<Object> response = prodController.addProductCategory(1, category);
		
		assertThat(response.getBody()).isEqualTo("Category for the Product Id is added Successfully");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	@DisplayName(value = "Add Category for Invalid products")
	public void testAddCategoryInvalidProduct()
	{
        List<Product> product = new ArrayList<>();
		
		Category category = new Category(1,"jskjn","bebk",product);
		
		when(prodService.addProductCategory(-1,category)).thenReturn(new ResponseEntity<Object>("Invalid Data", HttpStatus.NOT_ACCEPTABLE));
		
		ResponseEntity<Object> response = prodController.addProductCategory(-1, category);
		
		assertThat(response.getBody()).isEqualTo("Invalid Data");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
	}
}
