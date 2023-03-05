package MercadonaAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MercadonaAPI.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public Optional<Product> findByProductCode(String productCode);
}