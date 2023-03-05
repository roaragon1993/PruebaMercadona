package MercadonaAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MercadonaAPI.model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer>{
	
	public Optional<Provider> findByProviderCode(String providerCode);
}
