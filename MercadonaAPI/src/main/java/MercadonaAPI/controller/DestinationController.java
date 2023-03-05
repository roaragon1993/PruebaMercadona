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
import MercadonaAPI.model.Product;
import MercadonaAPI.service.DestinationService;

@RestController
@RequestMapping(path = "/destination")
public class DestinationController {

	@Autowired
	private DestinationService destinationService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveDestination(@RequestBody Destination d) {
		Integer id =  destinationService.saveDestination(d);
		return "El destino se ha creado correctamente con el ID: " + id;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Destination> getDestination(@PathVariable Integer id) {
		return destinationService.getDestination(id);
	}
	
	@RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
	public Optional<Destination> getDestinationByCode(@PathVariable String code) {
		return destinationService.getDestinationByCode(code);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Destination> getDestinations() {
		List<Destination> destinations = destinationService.getDestinations();
		return destinations;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public String updateDestination(@RequestBody Destination d, @PathVariable Integer id) {
		if(destinationService.updateDestination(d, id)) {
			return "El destino con el ID: " + id + " se ha actualizado correctamente";
		} else {
			return "Ha ocurrido un error";
		}
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteDestination(@PathVariable Integer id) {
		if(destinationService.deleteDestination(id)) {
			return "El destino con el ID: " + id + " se ha borrado correctamente";
		} else {
			return "Ha ocurrido un error";
		}
	}
}
