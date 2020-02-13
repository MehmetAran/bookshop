package bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bookshop.model.User;

@Service
public interface UserService {
	public void insert(User user);
	public void delete(long id);
	public void update(User user);
	public User findById(long id);
	public List<User> allList();
	public User findByUsername(String username);
	public User findByEmail(String email);

}
