package bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookshop.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
