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

import com.pv.controller.ProductController;
import com.pv.entity.Category;
import com.pv.entity.Product;
import com.pv.entity.Seller;
import com.pv.service.ProductService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TestAddProduct 
{
	
	@InjectMocks
	private ProductController prodController;
	
	@MockBean
	private ProductService prodService;
	
	
		private Category category;;
		
		private List<Seller> sellers;;
		 
		private Product product;
		
	
	
	@Test
	@DisplayName(value = "Check Adding valid products")
	 void testAddingValidProduct()
	{
		
		when(prodService.addProduct(this.product = new Product(1,"abc",123.59,50,"hdkeh",LocalDateTime.now(),category,sellers))).thenReturn("Product Added Successfully");
		
		assertThat(prodController.addProduct(product)).isEqualTo("Product Added Successfully");
	}
	
	@Test
	@DisplayName(value = "Check Adding Invalid products")
	 void testAddingInValidProduct()
	{
		
		when(prodService.addProduct(null)).thenReturn("Product is Invalid");
		
		assertThat(prodController.addProduct(null)).isEqualTo("Product is Invalid");
	}
	
	@Test
	@DisplayName(value = "Check Adding List of products")
	 void testAddingListProduct()
	{
		
		when(prodService.addProducts(new ArrayList<Product>())).thenReturn("All Products Added Successfully");
		
		assertThat(prodController.addProducts(new ArrayList<Product>())).isEqualTo("All Products Added Successfully");
	}
}
