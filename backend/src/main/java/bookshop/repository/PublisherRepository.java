package bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshop.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long>{

}
