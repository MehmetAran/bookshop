package bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.model.CurrentProduct;
import bookshop.repository.CurrentProductRepository;

@Service
public class CurrentProductServiceImp implements CurrentProductService {
	@Autowired
	CurrentProductRepository currentProductRepository;
	
	@Override
	public void insert(CurrentProduct currentProduct) {
		if(findStoreById(currentProduct.getStoreID()) == null)
			currentProductRepository.save(currentProduct);
	}

	@Override
	public void delete(long storeID) {
		if(findStoreById(storeID) != null)
			currentProductRepository.deleteById(storeID);
	}

	@Override
	public void update(CurrentProduct currentProduct) {
		if(findStoreById(currentProduct.getStoreID()) != null)
			currentProductRepository.save(currentProduct);
	}

	@Override
	public List<CurrentProduct> allList() {
		List<CurrentProduct> currentProducts = currentProductRepository.findAll();
		return currentProducts != null ? currentProducts : null;
	}

	@Override
	public CurrentProduct findStoreById(long storeID) {
		CurrentProduct currentProduct = currentProductRepository.getOne(storeID);
		return currentProduct != null ? currentProduct : null;
	}
	
}
