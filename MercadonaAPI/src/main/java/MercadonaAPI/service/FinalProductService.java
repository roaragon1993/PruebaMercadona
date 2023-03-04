package MercadonaAPI.service;

import java.util.List;
import java.util.Optional;

import MercadonaAPI.model.FinalProduct;

public interface FinalProductService {
	 public Optional<FinalProduct> getFinalProduct(Integer id);
	 public List<FinalProduct> getFinalProducts();
}