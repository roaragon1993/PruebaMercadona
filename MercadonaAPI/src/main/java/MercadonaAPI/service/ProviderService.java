package MercadonaAPI.service;

import java.util.List;
import java.util.Optional;

import MercadonaAPI.model.Provider;

public interface ProviderService {
	 public Boolean saveProvider(Provider provider);
	 public Optional<Provider> getProvider(Integer id);
	 public List<Provider> getProviders();
}