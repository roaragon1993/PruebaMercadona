package MercadonaAPI.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import MercadonaAPI.model.Product;
import MercadonaAPI.repository.ProductRepository;
import MercadonaAPI.service.ProductService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Integer saveProduct(Product product) {
		try {
			Product newProduct = productRepository.save(product);
			return newProduct.getId();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Optional<Product> getProduct(Integer id) {
		try {
			Optional<Product> product = productRepository.findById(id);
			if (product.isEmpty()) {
				throw new NoSuchElementException();
			}
			return product;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@Override
	public Optional<Product> getProductByCode(String productCode) {
		try {
			Optional<Product> product = productRepository.findByProductCode(productCode);
			if (product.isEmpty()) {
				throw new NoSuchElementException();
			}
			return product;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@Override
	public List<Product> getProducts() {
		try {
			List<Product> product = productRepository.findAll();
			return product;
		} catch (Exception e) {
			return null;
		}
	}

	// Update a product from an id given
	@Override
	public Boolean updateProduct(Product product, Integer id) {
		try {
			Product updatedProduct = this.getProduct(id).get();
			updatedProduct.setproductCode(product.getproductCode());
			updatedProduct.setExpirationDate(product.getExpirationDate());
			updatedProduct.setProductName(product.getProductName());
			updatedProduct.setDescription(product.getDescription());
			productRepository.save(updatedProduct);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// Delete a product with their id
	@Override
	public Boolean deleteProduct(Integer id) {
		try {
			productRepository.delete(getProduct(id).get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
