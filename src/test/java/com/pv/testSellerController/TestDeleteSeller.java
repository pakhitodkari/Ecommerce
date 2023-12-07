package com.pv.testSellerController;

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


import com.pv.controller.SellerController;
import com.pv.service.SellerService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestDeleteSeller 
{
 
	@InjectMocks
	private SellerController sellerController;
	
	@Mock
	private SellerService sellerService;
	
	
	@Test
	@DisplayName(value = "Delete valid seller")
	public void testDeleteValidSeller()
	{
		
		when(sellerService.deleteSeller(1)).thenReturn(new ResponseEntity<Object>("Seller is Deleted Successfully", HttpStatus.OK));
		
		ResponseEntity<Object> response = sellerController.deleteSellerById(1);
		
		assertThat(response.getBody()).isEqualTo("Seller is Deleted Successfully");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	
	@Test
	@DisplayName(value = "Delete Invalid seller")
	public void testDeleteInvalidSeller()
	{
		
		when(sellerService.deleteSeller(-1)).thenReturn(new ResponseEntity<Object>("Invalid Seller Not Exits", HttpStatus.NOT_ACCEPTABLE));
		
		ResponseEntity<Object> response = sellerController.deleteSellerById(-1);
		
		assertThat(response.getBody()).isEqualTo("Invalid Seller Not Exits");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
	}
}
