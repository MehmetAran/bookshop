package bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bookshop.model.Book;
@Service
public interface BookService {
	public void insert(Book book);
	public void delete(long id);
	public void update(Book book);
	public List<Book> allList();
	public Book findBookWithID(long id);
	public void  findBokkWithISBN(String ISBN);
}
