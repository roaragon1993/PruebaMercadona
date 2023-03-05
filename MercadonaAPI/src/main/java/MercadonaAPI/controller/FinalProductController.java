package MercadonaAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import MercadonaAPI.model.FinalProduct;
import MercadonaAPI.service.FinalProductService;

@RestController
@RequestMapping(path = "/finalproduct")
public class FinalProductController {
//
//	@Autowired
//	private FinalProductService finalProductService;
//	
//	@RequestMapping(value = "/getFinalProduct/{id}", method = RequestMethod.GET)
//	public Optional<FinalProduct> getDestination(@PathVariable Integer id) {
//		return finalProductService.getFinalProduct(id);
//	}
//
//	@RequestMapping(value = "/getFinalProducts", method = RequestMethod.GET)
//	public List<FinalProduct> getProviders() {
//		List<FinalProduct> destinations = finalProductService.getFinalProducts();
//		return destinations;
//	}
}