package com.pv.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Category")
public class Category
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer categoryID;
   
   @Column(name = "Category_Name", length = 40)
   @NotNull(message = "Enter the Category Name")
   @Pattern(regexp = "^[a-zA-Z\\s]+$")
   private String categoryName;
   
   @Column(name = "Category_Description", length = 80)
   @NotNull(message = "Enter the Category Description")
   @Pattern(regexp = "^[a-zA-Z\\s]+$")
   private String categoryDescription;
   
   @JsonBackReference
   @JsonIgnore 
   @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
   private List<Product> products;
   
   public Category()
   {}

public Category(Integer categoryID,
		@NotNull(message = "Enter the Category Name") @Pattern(regexp = "[a-zA-Z]") String categoryName,
		@NotNull(message = "Enter the Category Description") @Pattern(regexp = "[a-zA-Z]") String categoryDescription,
		List<Product> products) {
	super();
	this.categoryID = categoryID;
	this.categoryName = categoryName;
	this.categoryDescription = categoryDescription;
	this.products = products;
}

public Category(Integer categoryID,
		@NotNull(message = "Enter the Category Name") @Pattern(regexp = "[a-zA-Z]") String categoryName,
		@NotNull(message = "Enter the Category Description") @Pattern(regexp = "[a-zA-Z]") String categoryDescription) {
	super();
	this.categoryID = categoryID;
	this.categoryName = categoryName;
	this.categoryDescription = categoryDescription;

}

public Integer getCategoryID() {
	return categoryID;
}

public void setCategoryID(Integer categoryID) {
	this.categoryID = categoryID;
}

public String getCategoryName() {
	return categoryName;
}

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

public String getCategoryDescription() {
	return categoryDescription;
}

public void setCategoryDescription(String categoryDescription) {
	this.categoryDescription = categoryDescription;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}

@Override
public String toString() {
	return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName + ", categoryDescription="
			+ categoryDescription + ", products=" + products + "]";
}
   
   
}   