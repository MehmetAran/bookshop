package bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bookshop.model.Publisher;

@Service
public interface PublisherService {
	public void insert(Publisher publisher);
	public void delete(long id);
	public void update(Publisher publisher);
	public List<Publisher> allList();
	public Publisher findById(long id);
}
