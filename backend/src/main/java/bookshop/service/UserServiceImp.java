package bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.model.User;
import bookshop.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void insert(User user) {
		userRepository.save(user);		
	}

	@Override
	public void delete(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void update(User user) {
		if(findById(user.getId()) == null )
			return;
		userRepository.save(user);
	}

	@Override
	public User findById(long id) {
		return userRepository.getOne(id);
	}

	@Override
	public List<User> allList() {
		return userRepository.findAll();
	}
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).get();
	}
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).get();
	}
	
	
}
