package bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.model.Author;
import bookshop.repository.AuthorRepository;
@Service
public class AuthorServiceImp implements AuthorService{

	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public void insert(Author author) {
		authorRepository.save(author);
	}

	@Override
	public void delete(long authorID) {
		authorRepository.deleteById(authorID);		
	}

	@Override
	public void update(Author author) {
		if(findByID(author.getAuthorID()) == null)
			return;
		authorRepository.save(author);	
	}

	@Override
	public Author findByID(long authorID) {
		return authorRepository.findById(authorID).get();
	}

	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}
	
}
