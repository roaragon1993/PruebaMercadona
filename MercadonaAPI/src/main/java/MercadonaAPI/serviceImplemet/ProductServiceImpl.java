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
	 	
	 	 /*
		//Update a client from an id given
		@Override
		public Boolean updateProduct(Product product, Integer id) {
			try {
				Optional<Product> finalProduct = this.getProduct(id);
				finalProduct.setproductCode(product.getproductCode());
				finalProduct.setExpirationDate(product.getExpirationDate());
				finalProduct.setProductName(product.getProductName());
				finalProduct.setDescription(product.getDescription());
				ProductRepository.saveProduct(finalProduct);
				return true;
			} catch (Exception e) {
				return false;
			}

		}

		//Delete a client with their id
		@Override
		public Boolean deleteProduct(Integer id) {
			try {
				ProductRepository.delete(getProduct(id));
				return true;
			} catch (Exception e) {
				return false;
			}
		} */

}
