package MercadonaAPI.service;

import java.util.List;
import java.util.Optional;

import MercadonaAPI.model.EANProduct;

public interface EANProductService {
	 public EANProduct getEANProduct(String id);
	 public List<EANProduct> getEANProducts();
}