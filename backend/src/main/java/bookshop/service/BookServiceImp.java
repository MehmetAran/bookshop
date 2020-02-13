package bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.model.Book;
import bookshop.repository.BookRepository;
@Service
public class BookServiceImp implements BookService{
	@Autowired
	BookRepository bookRepository;

	@Override
	public void insert(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void delete(long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public void update(Book book) {
		if(findBookWithID(book.getBookID()) == null)
			return;
		bookRepository.save(book);
	}

	@Override
	public List<Book> allList() {
		return bookRepository.findAll();
	}
	@Override
	public Book findBookWithID(long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).get();
	}

	@Override
	public void findBokkWithISBN(String ISBN) {
		bookRepository.findByISBN(ISBN);
	}
	
}
