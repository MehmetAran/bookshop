package bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bookshop.model.Category;

@Service
public interface CategoryService {
	public void insert(Category category);
	public void delete(long id);
	public void update(Category category);
	public List<Category> allList();
	public Category findById(long id);
}
