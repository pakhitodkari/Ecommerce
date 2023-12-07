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
public class TestAddSeller 
{

	@InjectMocks
	private SellerController sellerController;
	
	@Mock
	private SellerService sellerService;
	
	
	@Test
	@DisplayName(value = "Check Adding valid seller")
	public void testAddingValidSeller()
	{
		List<Product> product = new ArrayList<Product>();
		
		Seller seller = new Seller(1,"abc","hdkeh","1234567890","abc@gmail.com",product);
		
		when(sellerService.addSeller(seller)).thenReturn(new ResponseEntity<Object>("Seller is Added Successfully", HttpStatus.ACCEPTED));
		
        ResponseEntity<Object> response = sellerController.addSeller(seller);
		
		assertThat(response.getBody()).isEqualTo("Seller is Added Successfully");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
		
	}
	
	
	@Test
	@DisplayName(value = "Check Adding List of sellers")
	public void testAddingListSeller()
	{
		
		when(sellerService.addSellers(new ArrayList<Seller>())).thenReturn(new ResponseEntity<Object>("Sellers List is Added Successfully", HttpStatus.ACCEPTED));
		
        ResponseEntity<Object> response = sellerController.addSellers(new ArrayList<Seller>());
		
		assertThat(response.getBody()).isEqualTo("Sellers List is Added Successfully");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
		
	}
}
