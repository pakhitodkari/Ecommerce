package pv.com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pv.entity.Order;
import com.pv.entity.Product;
import com.pv.repository.OrderRepository;

@Primary
@Service
public class OrderService 
{

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Cacheable("orders")
	public String addOrder(Order order)
	{
	   orderRepo.saveAndFlush(order);
	   
	   return "Order Added";
	}
	
	@CacheEvict("order")
	public Order getOrder(Integer orderId)
	{
		return orderRepo.findById(orderId).get();
	}
	
	public String addProductForOrder(Integer orderId, Integer prodId)
	{
		Order order = orderRepo.findById(orderId).get();
		
		Product product = restTemplate.getForEntity("http://product/getProduct/" + prodId, Product.class).getBody();
		
		order.setProducts(product);
		
		orderRepo.saveAndFlush(order);
		
		return "Product added.";
	}
}
