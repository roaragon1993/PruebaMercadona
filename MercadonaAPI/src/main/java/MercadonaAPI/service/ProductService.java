package MercadonaAPI.service;

import java.util.List;
import java.util.Optional;

import MercadonaAPI.model.Product;

public interface ProductService {
	 public Boolean saveProduct(Product product);
	 public Optional<Product> getProduct(Integer id);
	 public List<Product> getProducts();
}