package MercadonaAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import MercadonaAPI.model.Product;
import MercadonaAPI.service.ProductService;

//Product controller, it redirects queries to the correct endpoints.

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public Boolean saveProduct(@RequestBody Product p) {
		return productService.saveProduct(p);
	}

	@RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET)
	public Optional<Product> getProduct(@PathVariable Integer id) {
		return productService.getProduct(id);
	}

	@RequestMapping(value = "/getProducts", method = RequestMethod.GET)
	public List<Product> getProducts() {
		List<Product> products = productService.getProducts();
		return products;
	}
}
