package MercadonaAPI.service;

import java.util.List;
import java.util.Optional;

import MercadonaAPI.model.Destination;

public interface DestinationService {
	 public Integer saveDestination(Destination destination);
	 public Optional<Destination> getDestination(Integer id);
	 public Optional<Destination> getDestinationByCode(String code);
	 public List<Destination> getDestinations();
	 public Boolean updateDestination(Destination destination, Integer id);
	 public Boolean deleteDestination(Integer id);
}
