package bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookshop.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{
	
}
