package com.pv.entity;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Seller")
public class Seller
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer sellerID;
   
   @Column(name = "Seller_Name", length = 50)
   @NotNull(message = "Enter the Seller Name")
   @Pattern(regexp = "[a-zA-Z]")
   private String sellerName;
   
   @Column(name = "Seller_Address", length = 60)
   @NotNull(message = "Enter the Seller Address")
   @Pattern(regexp = "[a-zA-Z]")
   private String sellerAddress;
   
   @Column(name = "Seller_PhoneNo")
   @NotNull(message = "Enter the Phone Number")
   @Length(min = 10,max = 10)
   private String sellerPhone;
   
   @Column(name = "Seller_Email", unique = true)
   @NotNull(message = "Enter the Email")
   @Email
   private String sellerEmail;
   
   @JsonIgnore
   @ManyToMany(mappedBy = "sellers")
   private List<Product> products;
   
   public Seller()
   {}

public Seller(Integer sellerID,
		@NotNull(message = "Enter the Seller Name") @Pattern(regexp = "[a-zA-Z]") String sellerName,
		@NotNull(message = "Enter the Seller Address") @Pattern(regexp = "[a-zA-Z]") String sellerAddress,
		@NotNull(message = "Enter the Phone Number") @Length(min = 10, max = 10) String sellerPhone,
		@NotNull(message = "Enter the Email") @Email String sellerEmail, List<Product> products) {
	super();
	this.sellerID = sellerID;
	this.sellerName = sellerName;
	this.sellerAddress = sellerAddress;
	this.sellerPhone = sellerPhone;
	this.sellerEmail = sellerEmail;
	this.products = products;
}

public Integer getSellerID() {
	return sellerID;
}

public void setSellerID(Integer sellerID) {
	this.sellerID = sellerID;
}

public String getSellerName() {
	return sellerName;
}

public void setSellerName(String sellerName) {
	this.sellerName = sellerName;
}

public String getSellerAddress() {
	return sellerAddress;
}

public void setSellerAddress(String sellerAddress) {
	this.sellerAddress = sellerAddress;
}

public String getSellerPhone() {
	return sellerPhone;
}

public void setSellerPhone(String sellerPhone) {
	this.sellerPhone = sellerPhone;
}

public String getSellerEmail() {
	return sellerEmail;
}

public void setSellerEmail(String sellerEmail) {
	this.sellerEmail = sellerEmail;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}

@Override
public String toString() {
	return "Seller [sellerID=" + sellerID + ", sellerName=" + sellerName + ", sellerAddress=" + sellerAddress
			+ ", sellerPhone=" + sellerPhone + ", sellerEmail=" + sellerEmail + ", products=" + products + "]";
}
   
   
}
