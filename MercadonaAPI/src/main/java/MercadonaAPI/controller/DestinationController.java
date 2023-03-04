package MercadonaAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import MercadonaAPI.model.Destination;
import MercadonaAPI.service.DestinationService;

@RestController
@RequestMapping(path = "/destination")
public class DestinationController {

	@Autowired
	private DestinationService destinationService;
	
	@RequestMapping(value = "/saveDestination", method = RequestMethod.POST)
	public Boolean saveDestination(@RequestBody Destination d) {
		return destinationService.saveDestination(d);
	}

	@RequestMapping(value = "/getDestination/{id}", method = RequestMethod.GET)
	public Optional<Destination> getDestination(@PathVariable Integer id) {
		return destinationService.getDestination(id);
	}

	@RequestMapping(value = "/getProviders", method = RequestMethod.GET)
	public List<Destination> getProviders() {
		List<Destination> destinations = destinationService.getDestinations();
		return destinations;
	}
	
	/*@RequestMapping(value = "/updateDestination/{id}", method = RequestMethod.PATCH)
	public Boolean updateProvider(@RequestBody Destination d, @PathVariable Integer id) {
		return productService.updateProvider(d, id);
	}

	@RequestMapping(value = "/deleteProvider/{id}", method = RequestMethod.DELETE)
	public Boolean deleteProvider(@PathVariable Integer id) {
		return productService.updateProduct(id);
	} */
}
