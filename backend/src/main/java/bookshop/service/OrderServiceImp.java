package bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.model.Order;
import bookshop.repository.OrderRepository;

@Service
public class OrderServiceImp implements OrderService{
	@Autowired
	OrderRepository orderRepository;

	@Override
	public void insert(Order order) {
		if(findOrderByID(order.getOrderID()) == null)
			orderRepository.save(order);
	}

	@Override
	public void delete(long orderId) {
		if(findOrderByID(orderId) != null)
			orderRepository.deleteById(orderId);
	}

	@Override
	public void update(Order order) {
		if(findOrderByID(order.getOrderID()) != null)
			orderRepository.save(order);
	}

	@Override
	public List<Order> allList() {
		List<Order> orders = orderRepository.findAll();
		return orders != null ? orderRepository.findAll() : null;
	}

	@Override
	public Order findOrderByID(long orderID) {
		Order order = orderRepository.getOne(orderID);
		return order != null ? order : null;
	}

	
}
