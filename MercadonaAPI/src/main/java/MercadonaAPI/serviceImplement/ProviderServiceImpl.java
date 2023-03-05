package MercadonaAPI.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import MercadonaAPI.model.Provider;
import MercadonaAPI.repository.ProviderRepository;
import MercadonaAPI.service.ProviderService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {
	@Autowired
	private ProviderRepository providerRepository;

	@Override
	public Integer saveProvider(Provider provider) {
		try {
			Provider newProvider = providerRepository.save(provider);
			return newProvider.getId();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Optional<Provider> getProvider(Integer id) {
		try {
			Optional<Provider> provider = providerRepository.findById(id);
			if (provider.isEmpty()) {
				throw new NoSuchElementException();
			}
			return provider;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provider not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@Override
	public Optional<Provider> getProviderByCode(String code) {
		try {
			Optional<Provider> provider = providerRepository.findByProviderCode(code);
			if (provider.isEmpty()) {
				throw new NoSuchElementException();
			}
			return provider;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provider not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@Override
	public List<Provider> getProviders() {
		try {
			List<Provider> provider = providerRepository.findAll();
			return provider;
		} catch (Exception e) {
			return null;
		}
	}

	// Update a provider from an id given
	@Override
	public Boolean updateProvider(Provider provider, Integer id) {
		try {
			Provider updatedProvider = this.getProvider(id).get();
			updatedProvider.setProviderCode(provider.getProviderCode());
			updatedProvider.setProviderName(provider.getProviderName());
			providerRepository.save(updatedProvider);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// Delete a provider with their id
	@Override
	public Boolean deleteProvider(Integer id) {
		try {
			providerRepository.delete(getProvider(id).get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
