package MercadonaAPI.service;

import java.util.List;
import java.util.Optional;

import MercadonaAPI.model.Provider;

public interface ProviderService {
	 public Integer saveProvider(Provider provider);
	 public Optional<Provider> getProvider(Integer id);
	 public Optional<Provider> getProviderByCode(String code);
	 public List<Provider> getProviders();
	 public Boolean updateProvider(Provider p, Integer id);
	 public Boolean deleteProvider(Integer id);
}