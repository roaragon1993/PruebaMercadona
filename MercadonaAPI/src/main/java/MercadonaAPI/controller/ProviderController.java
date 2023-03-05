package MercadonaAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import MercadonaAPI.model.Provider;
import MercadonaAPI.service.ProviderService;

@RestController
@RequestMapping(path = "/provider")
public class ProviderController {
	
//	@Autowired
//	private ProviderService provicerService;
//
//	@RequestMapping(value = "/saveProvider", method = RequestMethod.POST)
//	public Boolean saveProvider(@RequestBody Provider p) {
//		return provicerService.saveProvider(p);
//	}
//
//	@RequestMapping(value = "/getProvider/{id}", method = RequestMethod.GET)
//	public Optional<Provider> getProvider(@PathVariable Integer id) {
//		return provicerService.getProvider(id);
//	}
//
//	@RequestMapping(value = "/getProviders", method = RequestMethod.GET)
//	public List<Provider> getProviders() {
//		List<Provider> providers = provicerService.getProviders();
//		return providers;
//	}
	
	/*@RequestMapping(value = "/updateProvider/{id}", method = RequestMethod.PATCH)
	public Boolean updateProvider(@RequestBody Provider p, @PathVariable Integer id) {
		return productService.updateProvider(p, id);
	}

	@RequestMapping(value = "/deleteProvider/{id}", method = RequestMethod.DELETE)
	public Boolean deleteProvider(@PathVariable Integer id) {
		return productService.updateProduct(id);
	} */
	
}
