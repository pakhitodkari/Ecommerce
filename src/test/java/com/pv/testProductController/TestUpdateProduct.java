package com.pv.testProductController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import com.pv.entity.Category;
import com.pv.entity.Product;
import com.pv.entity.Seller;
import com.pv.service.ProductService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TestUpdateProduct 
{

	@InjectMocks
	private ProductController prodController;
	
	@MockBean
	private ProductService prodService;
	
	 
	
	@Test
	@DisplayName(value = "Update valid products")
	 void testUpdateValidProduct()
	{
		Category category = new Category();
		
		List<Seller> sellers = new ArrayList<>();
		
		Product product = new Product(1,"abc",123.59,50,"hdkeh",LocalDateTime.now(),category,sellers);
		
		when(prodService.updateProduct(1,product)).thenReturn(new ResponseEntity<Object>("Product Updated Successfully", HttpStatus.OK));
		
		ResponseEntity<Object> response = prodController.updateProduct(1, product);
		
		assertThat(response.getBody()).isEqualTo("Product Updated Successfully");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	
	@Test
	@DisplayName(value = "Update Invalid products")
	 void testUpdateInvalidProduct()
	{
		Category category = new Category();
		
		List<Seller> sellers = new ArrayList<>();
		
		Product product = new Product(1,"abc",123.59,50,"hdkeh",LocalDateTime.now(),category,sellers);
		
		when(prodService.updateProduct(-1,product)).thenReturn(new ResponseEntity<Object>("Product Not Exits", HttpStatus.NOT_ACCEPTABLE));
		
		ResponseEntity<Object> response = prodController.updateProduct(-1, product);
		
		assertThat(response.getBody()).isEqualTo("Product Not Exits");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
	}

}
