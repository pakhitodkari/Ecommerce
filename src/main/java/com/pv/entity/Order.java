package com.pv.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Order")
public class Order 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@OneToOne
	//@Column(name = "Product_List")
	private Product products;
	
	@Column(name = "Total_Amount")
	private Double totalAmount;
	
	@Column(name = "Order_Date")
	private LocalDate orderDate;
	
	@Column(name = "Delivery_Date")
	private LocalDate deliveryDate;
	
	public Order()
	{}

	public Order(Integer orderId, Product products, Double totalAmount, LocalDate orderDate,
			LocalDate deliveryDate) {
		super();
		this.orderId = orderId;
		this.products = products;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "Order [orderd=" + orderId + ", products=" + products + ", totalAmount=" + totalAmount + ", orderDate="
				+ orderDate + ", deliveryDate=" + deliveryDate + "]";
	}
	
	
	
}
