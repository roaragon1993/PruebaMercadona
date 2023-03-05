package MercadonaAPI.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import MercadonaAPI.model.Destination;
import MercadonaAPI.repository.DestinationRepository;
import MercadonaAPI.service.DestinationService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DestinationServiceImpl implements DestinationService {
	@Autowired
	private DestinationRepository destinationRepository;

	@Override
	public Integer saveDestination(Destination destination) {
		try {
			Destination newDestination = destinationRepository.save(destination);
			return newDestination.getId();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Optional<Destination> getDestination(Integer id) {
		try {
			Optional<Destination> destination = destinationRepository.findById(id);
			if (destination.isEmpty()) {
				throw new NoSuchElementException();
			}
			return destination;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Destination not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@Override
	public Optional<Destination> getDestinationByCode(String code) {
		try {
			Optional<Destination> destination = destinationRepository.findByDestinationCode(code);
			if (destination.isEmpty()) {
				throw new NoSuchElementException();
			}
			return destination;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Destination not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@Override
	public List<Destination> getDestinations() {
		try {
			List<Destination> destination = destinationRepository.findAll();
			return destination;
		} catch (Exception e) {
			return null;
		}
	}

	// Update a destination from an id given
	@Override
	public Boolean updateDestination(Destination destination, Integer id) {
		try {
			Destination updatedDestination = this.getDestination(id).get();
			updatedDestination.setDestinationCode(destination.getDestinationCode());
			updatedDestination.setDestinationName(destination.getDestinationName());
			destinationRepository.save(updatedDestination);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// Delete a destination with their id
	@Override
	public Boolean deleteDestination(Integer id) {
		try {
			destinationRepository.delete(getDestination(id).get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
