package bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bookshop.model.Role;

@Service
public interface RoleService {
	public void insert(Role role);
	public void delete(long id);
	public void update(Role role);
	public Role findById(long id);
	public List<Role> allList();
}
