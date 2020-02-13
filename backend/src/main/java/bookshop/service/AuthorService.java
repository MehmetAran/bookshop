package bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bookshop.model.Author;
@Service
public interface AuthorService {
	public void insert(Author author);
	public void delete(long authorID);
	public void update(Author author);
	public Author findByID(long authorID);
	public List<Author> findAll();

}
