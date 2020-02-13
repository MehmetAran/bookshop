package bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.model.Publisher;
import bookshop.repository.PublisherRepository;

@Service
public class PublisherServiceImp implements PublisherService {
	
	@Autowired
	PublisherRepository publisherRepository;
	@Override
	public void insert(Publisher publisher) {
		publisherRepository.save(publisher);
	}

	@Override
	public void delete(long id) {
		publisherRepository.deleteById(id);	
	}

	@Override
	public void update(Publisher publisher) {
		if(publisherRepository.getOne(publisher.getPublisherID()) == null )
			return;
		publisherRepository.save(publisher);		
	}

	@Override
	public List<Publisher> allList() {
		return publisherRepository.findAll();
	}

	@Override
	public Publisher findById(long id) {
		return publisherRepository.getOne(id);
	}
	

}
