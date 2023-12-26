package com.pv.controller;

import pv.com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pv.entity.*;

@RestController
//@RequestMapping("/order")
public class OrderController 
{

//	@Autowired
//	private OrderService orderService;
//	
	@GetMapping("/")
	public String getHome()
	{
		return "Hello, Home";
	}
	
	@GetMapping("/secured")
	public String getSecured()
	{
		return "Hello, Secured";
	}
	
//	@PostMapping("/{id}")
//	public Order getOrder(@PathVariable("id") Integer orderId)
//	{
//		return orderService.getOrder(orderId);
//	}
//	
//	@GetMapping("/addOrder")
//	public String addOrder(@RequestBody Order order)
//	{
//		return orderService.addOrder(order);
//	}
//	
//	@PostMapping("/{orderId}/{prodId}")
//	public String addProductForOrder(@PathVariable("orderId") Integer orderId,@PathVariable("prodId") Integer prodId)
//	{
//		return orderService.addProductForOrder(orderId, prodId);
//	}
}
