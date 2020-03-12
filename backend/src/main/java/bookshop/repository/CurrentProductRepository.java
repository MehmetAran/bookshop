package bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookshop.model.CurrentProduct;

@Repository
public interface CurrentProductRepository extends JpaRepository<CurrentProduct, Long>{
	
}
