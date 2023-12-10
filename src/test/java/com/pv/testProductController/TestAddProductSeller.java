package com.pv.testProductController;

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

import com.pv.controller.ProductController;
import com.pv.entity.Seller;
import com.pv.service.ProductService;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TestAddProductSeller 
{

	@InjectMocks
	private ProductController prodController;
	
	@Mock
	private ProductService prodService;
	
	
	@Test
	@DisplayName(value = "Add valid seller for products")
	 void testAddProductValidSeller()
	{
		when(prodService.addProductSeller(1, new ArrayList<Seller>())).thenReturn(new ResponseEntity<Object>("Seller for the Product Id is added Successfully", HttpStatus.OK));
		
		ResponseEntity<Object> response = prodController.addProductSeller(1, new ArrayList<Seller>());
		
		assertThat(response.getBody()).isEqualTo("Seller for the Product Id is added Successfully");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	@DisplayName(value = "Add Invalid Seller for products")
	 void testAddProductInvalidSeller()
	{
		when(prodService.addProductSeller(-1,null)).thenReturn(new ResponseEntity<Object>("Invalid Data", HttpStatus.NOT_ACCEPTABLE));
		
		ResponseEntity<Object> response = prodController.addProductSeller(-1, null);
		
		assertThat(response.getBody()).isEqualTo("Invalid Data");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
	}
}
