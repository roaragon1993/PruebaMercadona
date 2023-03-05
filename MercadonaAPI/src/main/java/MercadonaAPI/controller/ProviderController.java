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
	
	@Autowired
	private ProviderService provicerService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProvider(@RequestBody Provider p) {
		Integer id = provicerService.saveProvider(p);
		return "El proveedor se ha creado correctamente con el ID: " + id;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Provider> getProvider(@PathVariable Integer id) {
		return provicerService.getProvider(id);
	}
	
	@RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
	public Optional<Provider> getProviderByCode(@PathVariable String code) {
		return provicerService.getProviderByCode(code);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Provider> getProviders() {
		List<Provider> providers = provicerService.getProviders();
		return providers;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public String updateProvider(@RequestBody Provider p, @PathVariable Integer id) {
		if(provicerService.updateProvider(p, id)) {
			return "El proveedor con el ID: " + id + " se ha actualizado correctamente";
		} else {
			return "Ha ocurrido un error";
		}
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteProvider(@PathVariable Integer id) {
		if(provicerService.deleteProvider(id)) {
			return "El proveedor con el ID: " + id + " se ha borrado correctamente";
		} else {
			return "Ha ocurrido un error";
		}
	}
	
}
