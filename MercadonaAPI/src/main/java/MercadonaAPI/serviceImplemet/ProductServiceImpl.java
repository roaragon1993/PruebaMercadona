package MercadonaAPI.serviceImplemet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import MercadonaAPI.model.Product;
import MercadonaAPI.repository.ProductRepository;
import MercadonaAPI.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
	   @Autowired
	     private ProductRepository productRepository;
	   
	     @Override
	     public Boolean saveProduct(Product product) {
	          try {
	        	  productRepository.save(product);
	               return true;
	          } catch (Exception e) {
	               return false;
	          }
	     }
	    
	 	@Override
	 	public Optional<Product> getProduct(Integer id) {
	 		 try {
	              Optional<Product> product = productRepository.findById(id);
	              return product;
	         } catch (Exception e) {
	              return null;
	         }
	 	}
	 	
	    
	 	@Override
	 	public List<Product> getProducts() {
	 		 try {
	              List<Product> product = productRepository.findAll();
	              return  product;
	         } catch (Exception e) {
	              return null;
	         }
	 	}
}
