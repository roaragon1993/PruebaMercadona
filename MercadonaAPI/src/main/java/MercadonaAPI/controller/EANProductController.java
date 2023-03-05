package MercadonaAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import MercadonaAPI.model.EANProduct;
import MercadonaAPI.service.EANProductService;

@RestController
@RequestMapping(path = "/EAN")
public class EANProductController {

	@Autowired
	private EANProductService eanProductService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public EANProduct getEANProduct(@PathVariable String id) {
		return eanProductService.getEANProduct(id);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<EANProduct> getEANProducts() {
		List<EANProduct> eanProducts = eanProductService.getEANProducts();
		return eanProducts;
	}
}