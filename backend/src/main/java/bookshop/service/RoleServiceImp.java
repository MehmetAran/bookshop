package bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.model.Role;
import bookshop.repository.RoleRepository;

@Service
public class RoleServiceImp implements RoleService{

	@Autowired
	RoleRepository roleRepository;

	
	@Override
	public void insert(Role role) {
		roleRepository.save(role);
	}

	@Override
	public void delete(long id) {
		roleRepository.deleteById(id);
	}

	@Override
	public void update(Role role) {
		if(findById(role.getId()) == null)
			return;
		roleRepository.save(role);
	}

	@Override
	public Role findById(long id) {
		return roleRepository.getOne(id);
	}

	@Override
	public List<Role> allList() {
		return roleRepository.findAll();
	}
	

}
