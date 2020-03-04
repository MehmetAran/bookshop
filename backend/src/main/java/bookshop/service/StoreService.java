package bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bookshop.model.Store;

@Service
public interface StoreService {
	public void insert(Store store);
	public void delete(long storeID);
	public void update(Store store);
	public List<Store> allList();
	public Store findStoreById(long storeID);
}
