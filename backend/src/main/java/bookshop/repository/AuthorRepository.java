package bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookshop.model.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
