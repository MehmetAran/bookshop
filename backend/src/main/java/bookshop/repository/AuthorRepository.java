package bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshop.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
