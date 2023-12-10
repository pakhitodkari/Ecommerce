
package com.pv.testProductController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pv.entity.Category;
import com.pv.entity.Product;
import com.pv.entity.Seller;
import com.pv.repository.ProductRepository;
import com.pv.service.ProductService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TestGetProduct 
{
	
	@MockBean
	private ProductRepository prodRepo;
	
	@InjectMocks
	private ProductService prodService;
	
	
	
	
	@Test
	@DisplayName(value = "Check all the products")
	 void testFindAll()
	{
		 Category category = new Category();
		
		 List<Seller> sellers = new ArrayList<>();
		
		when(prodRepo.findAll()).thenReturn(Stream.of(new Product(1,"abc",123.59,50,"hdkeh",LocalDateTime.now(),category,sellers),new Product(2,"pqr",534.60,20,"ssddd",LocalDateTime.now(),category,sellers)).collect(Collectors.toList()));
		
		assertThat(prodService.getAllProducts()).hasSameSizeAs(prodRepo.findAll());
		
		//assertEquals(prodService.getAllProducts(),Stream.of(new Product(1,"abc",123.59,50,"hdkeh",LocalDateTime.now(),category,sellers),new Product(2,"pqr",534.60,20,"ssddd",LocalDateTime.now(),category,sellers)).collect(Collectors.toList()));
		
	}
	
	@Test
	@DisplayName(value = "Check product for given id")
	 void testFindById() {
		 Category category = new Category();
		
		 List<Seller> sellers = new ArrayList<>();
		
		when(prodRepo.findById(1)).thenReturn(Optional.of(new Product(1,"abc",123.59,50,"hdkeh",LocalDateTime.now(),category,sellers)));
		
		Product prod = prodService.getByProductId(1);
		
		assertThat(prod).isNotNull();
	}
	
	@Disabled(value = "Not Required")
	@Test
	@DisplayName(value = "Check product for given id which is not present")
	 void testFindByIdInvalid() {
		
		when(prodRepo.findById(-1).get()).thenReturn(null);
		
		Product prod = prodService.getByProductId(-1);
		
		assertThat(prod).isNull();
	}
	
	@Test
	@DisplayName(value = "Check product for given invalid product name")
	 void testProductByNameInvalid()
	{
		when(prodRepo.findByProductName(null)).thenReturn(null);
		
		Product prod = prodService.findByProductName(null);
		
		assertThat(prod).isNull();
	}
	
	@Test
	@DisplayName(value = "Check product for given valid product name")
	 void testProductByName()
	{
		Category category = new Category();
		
		 List<Seller> sellers = new ArrayList<>();
		 
		when(prodRepo.findByProductName("abc")).thenReturn(new Product(1,"abc",123.59,50,"hdkeh",LocalDateTime.now(),category,sellers));
		
		Product prod = prodService.findByProductName("abc");
		
		assertThat(prod).isNotNull();
	}


}

