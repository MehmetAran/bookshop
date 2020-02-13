package bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookshop.model.Publisher;
@Repository

public interface PublisherRepository extends JpaRepository<Publisher, Long>{

}
