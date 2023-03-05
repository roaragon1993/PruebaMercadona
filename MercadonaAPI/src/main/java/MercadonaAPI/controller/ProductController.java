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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@RequestBody Product p) {
		Integer id = productService.saveProduct(p);
		return "El producto se ha creado correctamente con el ID: " + id;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Product> getProduct(@PathVariable Integer id) {
		return productService.getProduct(id);
	}
	
	@RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
	public Optional<Product> getProduct(@PathVariable String code) {
		return productService.getProductByCode(code);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Product> getProducts() {
		List<Product> products = productService.getProducts();
		return products;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public String updateProduct(@RequestBody Product p, @PathVariable Integer id) {
		if(productService.updateProduct(p, id)) {
			return "El producto con el ID: " + id + " se ha actualizado correctamente";
		} else {
			return "Ha ocurrido un error";
		}
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteProduct(@PathVariable Integer id) {
		if(productService.deleteProduct(id)) {
			return "El producto con el ID: " + id + " se ha borrado correctamente";
		} else {
			return "Ha ocurrido un error";
		}
	}
}
