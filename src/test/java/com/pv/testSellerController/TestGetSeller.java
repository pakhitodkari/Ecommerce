package com.pv.testSellerController;

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

import com.pv.controller.SellerController;
import com.pv.entity.Seller;
import com.pv.service.SellerService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TestGetSeller 
{

	
	@InjectMocks
	private SellerController sellerController;
 	
	@Mock
	private SellerService sellerService;
	
	
	@Test
	@DisplayName(value = "Check all the sellers")
	 void testGetAllSeller()
	{
		 //Category category = new Category();
		
		 //List<Seller> sellers = new ArrayList<>();
		
		when(sellerService.getAllSellers()).thenReturn(new ArrayList<Seller>());
		
		assertThat(sellerController.getAllSeller()).isEqualTo(new ArrayList<Seller>());
		
		
	}
	
	@Test
	@DisplayName(value = "Get seller for given id")
	 void testGetSellerById() {
		
		
		when(sellerService.getSeller(1)).thenReturn(new Seller());
		
		Seller seller = sellerController.getSeller(1);
		
		assertThat(seller).isNotNull();
	}
	
	
	
	@Test
	@DisplayName(value = "Get seller by email")
	 void testGetSellerByEmail() {
		
		
		when(sellerService.getBySellerEmail("abc@gmail.com")).thenReturn(new Seller());
		
		Seller seller = sellerController.getBySellerEmail("abc@gmail.com");
		
		assertThat(seller).isNotNull();
	}
	
	@Test
	@DisplayName(value = "Get Seller by name")
	 void testGetSellerByName() {
		
		
		when(sellerService.getBySellerName("Sahil")).thenReturn(new ArrayList<Seller>());
		
		List<Seller> seller = sellerController.getSellerName("Sahil");
		
		assertThat(seller).isNotNull();
	}
	
}
