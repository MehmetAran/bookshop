package bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.model.Order;
import bookshop.repository.OrderRepository;

@Service
public interface OrderService {
	public void insert(Order order);
	public void delete(long orderId);
	public void update(Order order);
	public List<Order> allList();
	public Order findOrderByID(long orderID);
	
}
