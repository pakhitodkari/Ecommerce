package com.pv.testCategoryController;

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

import com.pv.controller.CategoryController;
import com.pv.entity.Category;
import com.pv.entity.Product;

import com.pv.service.CategoryService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestAddCategory 
{
	
	@InjectMocks
	private CategoryController categoryController;
	
	@Mock
	private CategoryService categoryService;
	
	
	@Test
	@DisplayName(value = "Check Adding valid category")
	public void testAddingValidCategory()
	{
		List<Product> product = new ArrayList<Product>();
		
		Category category = new Category(1,"abc","hdkeh",product);
		
		when(categoryService.addCategory(category)).thenReturn("Category Added Successfully");
		
		assertThat(categoryController.addCategory(category)).isEqualTo("Category Added Successfully");
	}
	
	@Test
	@DisplayName(value = "Check Adding Invalid category")
	public void testAddingInvalidCategory()
	{
		
		when(categoryService.addCategory(null)).thenReturn("Category is Invalid");
		
		assertThat(categoryController.addCategory(null)).isEqualTo("Category is Invalid");
	}
	
	@Test
	@DisplayName(value = "Check Adding List of categories")
	public void testAddingListCategory()
	{
		
		when(categoryService.addCategories(new ArrayList<Category>())).thenReturn("All Categories Added Successfully");
		
		assertThat(categoryController.addCategories(new ArrayList<Category>())).isEqualTo("All Categories Added Successfully");
	}

}
