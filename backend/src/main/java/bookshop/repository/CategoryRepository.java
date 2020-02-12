package bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
