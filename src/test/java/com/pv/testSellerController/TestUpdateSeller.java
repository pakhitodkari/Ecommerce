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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pv.controller.SellerController;
import com.pv.entity.Product;
import com.pv.entity.Seller;
import com.pv.service.SellerService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestUpdateSeller
{
    
	@InjectMocks
	private SellerController sellerController;
	
	@Mock
	private SellerService sellerService;
	
	
	@Test
	@DisplayName(value = "Update valid Seller")
	public void testUpdateValidSeller()
	{
		List<Product> product = new ArrayList<Product>();
		
		Seller seller = new Seller(1,"abc","hdkeh","1234567890","abc@gmail.com",product);

		
		when(sellerService.updateSeller(1, seller)).thenReturn(new ResponseEntity<Object>("Seller is Updated Successfully", HttpStatus.ACCEPTED));
		
		ResponseEntity<Object> response = sellerController.updateSeller(1, seller);
		
		assertThat(response.getBody()).isEqualTo("Seller is Updated Successfully");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
	}
	
	
	@Test
	@DisplayName(value = "Update Invalid seller")
	public void testUpdateInvalidSeller()
	{
		List<Product> product = new ArrayList<Product>();
		
		Seller seller = new Seller(1,"abc","hdkeh","1234567890","abc@gmail.com",product);
		
		
		when(sellerService.updateSeller(-1, seller)).thenReturn(new ResponseEntity<Object>("Seller Not Exits", HttpStatus.NOT_ACCEPTABLE));
		
		ResponseEntity<Object> response = sellerController.updateSeller(-1, seller);
		
		assertThat(response.getBody()).isEqualTo("Seller Not Exits");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
	}

	
}
