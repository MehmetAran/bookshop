package bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.model.Category;
import bookshop.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	
	@Override
	public void insert(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void delete(long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public void update(Category category) {
		if(findById(category.getCategoryID()) == null)
			return;
		categoryRepository.save(category);
	}

	@Override
	public List<Category> allList() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(long id) {
		// TODO Auto-generated method stub
		return categoryRepository.getOne(id);
	}
	
}
