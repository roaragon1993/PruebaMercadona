package MercadonaAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MercadonaAPI.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}