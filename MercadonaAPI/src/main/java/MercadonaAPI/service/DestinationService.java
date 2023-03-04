package MercadonaAPI.service;

import java.util.List;
import java.util.Optional;

import MercadonaAPI.model.Destination;

public interface DestinationService {
	 public Boolean saveDestination(Destination destination);
	 public Optional<Destination> getDestination(Integer id);
	 public List<Destination> getDestinations();
}
