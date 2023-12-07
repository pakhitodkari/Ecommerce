package com.pv.testProductController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pv.controller.ProductController;
import com.pv.service.ProductService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TestDeleteProduct
{
 
	@MockBean
	private ProductService prodService;
	
	@InjectMocks
	private ProductController prodController;
	
	
	@Test
	@DisplayName(value = "Delete valid products")
	public void testDeleteValidProduct()
	{
		
		when(prodService.deleteProduct(1)).thenReturn(new ResponseEntity<Object>("Product Deleted Successfully", HttpStatus.ACCEPTED));
		
		ResponseEntity<Object> response = prodController.deleteProduct(1);
		
		assertThat(response.getBody()).isEqualTo("Product Deleted Successfully");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
	}
	
	
	@Test
	@DisplayName(value = "Delete Invalid products")
	public void testUpdateInvalidProduct()
	{
		
		when(prodService.deleteProduct(-1)).thenReturn(new ResponseEntity<Object>("Invalid Product Not Exits", HttpStatus.NOT_ACCEPTABLE));
		
		ResponseEntity<Object> response = prodController.deleteProduct(-1);
		
		assertThat(response.getBody()).isEqualTo("Invalid Product Not Exits");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
	}
}
