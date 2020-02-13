package bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookshop.model.Book;
@Repository

public interface BookRepository extends JpaRepository<Book,Long> {
	public Book findByISBN(String ISBN);
}
