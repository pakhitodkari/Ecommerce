package com.pv.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Reference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Product")
public class Product 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer productID;
   
   @Column(name = "Product_Name", length = 50)
   @NotNull(message = "Enter the Product Name")
   //@Pattern(regexp = "^[a-zA-Z\s]+$")
   private String productName;
   
   @Column(name = "Product_Cost")
   @NotNull(message = "Enter the Product Cost")
   private Double productCost;
   
//   @Column(name = "Product_Weight")
//   @NotNull(message = "Enter the Product Weight")
//   @Pattern(regexp = "([\\d.]+)\\s+(lbs?|gm|kg)")
//   private String productWeight;
   
   @Column(name = "Product_Quantity")
   @NotNull(message = "Enter the Product Quantity")
   private Integer productQuantity;
   
   @Column(name = "Product_Description")
   @NotNull(message = "Enter the Product Description")
   private String productDescription;
  
   @Column(name = "Posted_Date_Time")
   //@NotNull(message = "Enter the Date and Time")
   private LocalDateTime postedDateTime;
   
   @Reference
   @ManyToOne(cascade = CascadeType.ALL)
   //@NotNull(message = "Enter the Product Category")
   @JoinColumn(name = "category_id")
   private Category category;
   
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(
		   name = "Product_Seller", 
		   joinColumns = @JoinColumn(name = "product_id"), 
		   inverseJoinColumns = @JoinColumn(name = "seller_id"))
   private List<Seller> sellers;
   
   public Product()
   {}

public Product(Integer productID,
		@NotNull(message = "Enter the Product Name") @Pattern(regexp = "[a-zA-Z]") String productName,
		@NotNull(message = "Enter the Product Cost") Double productCost,
		//@NotNull(message = "Enter the Product Weight") String productWeight,
		@NotNull(message = "Enter the Product Quantity") Integer productQuantity,
		@NotNull(message = "Enter the Product Description") String productDescription,
		@NotNull(message = "Enter the Date and Time") LocalDateTime postedDateTime, Category category, List<Seller> sellers) {
	super();
	this.productID = productID;
	this.productName = productName;
	this.productCost = productCost;
	//this.productWeight = productWeight;
	this.productQuantity = productQuantity;
	this.productDescription = productDescription;
	this.postedDateTime = postedDateTime;
	this.category = category;
	this.sellers = sellers;
}

public Integer getProductID() {
	return productID;
}

public void setProductID(Integer productID) {
	this.productID = productID;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public Double getProductCost() {
	return productCost;
}

public void setProductCost(Double productCost) {
	this.productCost = productCost;
}


//public String getProductWeight() {
//	return productWeight;
//}
//
//public void setProductWeight(String productWeight) {
//	this.productWeight = productWeight;
//}

public Integer getProductQuantity() {
	return productQuantity;
}

public void setProductQuantity(Integer productQuantity) {
	this.productQuantity = productQuantity;
}


public String getProductDescription() {
	return productDescription;
}

public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}

public LocalDateTime getPostedDateTime() {
	return postedDateTime;
}

public void setPostedDateTime(LocalDateTime postedDateTime) {
	this.postedDateTime = postedDateTime;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

public List<Seller> getSellers() {
	return sellers;
}

public void setSellers(List<Seller> sellers) {
	this.sellers = sellers;
}

@Override
public String toString() {
	return "Product [productID=" + productID + ", productName=" + productName + ", productCost=" + productCost
			+ ", productQuantity=" + productQuantity + ", postedDateTime=" + postedDateTime + ", sellers=" + sellers
			+ "]";
}
   
   
}
