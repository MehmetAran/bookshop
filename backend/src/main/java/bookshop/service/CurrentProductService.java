package bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bookshop.model.CurrentProduct;

@Service
public interface CurrentProductService {
	public void insert(CurrentProduct currentProduct);
	public void delete(long storeID);
	public void update(CurrentProduct currentProduct);
	public List<CurrentProduct> allList();
	public CurrentProduct findStoreById(long storeID);
}
