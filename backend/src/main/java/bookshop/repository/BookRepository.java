package bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshop.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
	public Book findByISBN(String ISBN);
}
