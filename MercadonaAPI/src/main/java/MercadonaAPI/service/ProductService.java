package MercadonaAPI.service;

import java.util.List;
import java.util.Optional;

import MercadonaAPI.model.Product;

public interface ProductService {
	 public Integer saveProduct(Product product);
	 public Optional<Product> getProduct(Integer id);
	 public Optional<Product> getProductByCode(String productCode);
	 public List<Product> getProducts();
	 public Boolean updateProduct(Product p, Integer id);
	 public Boolean deleteProduct(Integer id);
}