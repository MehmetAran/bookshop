package bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.model.Store;
import bookshop.repository.StoreRepository;

@Service
public class StoreServiceImp implements StoreService {
	@Autowired
	StoreRepository storeRepository;
	
	@Override
	public void insert(Store store) {
		if(findStoreById(store.getStoreID()) == null)
			storeRepository.save(store);
	}

	@Override
	public void delete(long storeID) {
		if(findStoreById(storeID) != null)
			storeRepository.deleteById(storeID);
	}

	@Override
	public void update(Store store) {
		if(findStoreById(store.getStoreID()) != null)
			storeRepository.save(store);
	}

	@Override
	public List<Store> allList() {
		List<Store> stores = storeRepository.findAll();
		return stores != null ? stores : null;
	}

	@Override
	public Store findStoreById(long storeID) {
		Store store = storeRepository.getOne(storeID);
		return store != null ? store : null;
	}
	
}
