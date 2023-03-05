package MercadonaAPI.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import MercadonaAPI.model.Destination;
import MercadonaAPI.model.EANProduct;
import MercadonaAPI.model.Product;
import MercadonaAPI.model.Provider;
import MercadonaAPI.service.EANProductService;

@Service
public class EANProductServiceImpl implements EANProductService {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private ProviderServiceImpl providerServiceImpl;
	
	@Autowired
	private DestinationServiceImpl destinationServiceImpl;


	@Override
	public EANProduct getEANProduct(String ean) {
		try {
			if(ean != null && !ean.matches("[0-9]+")) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EAN not valid");
			}
			
			if(ean != null && ean.length()!=13) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EAN not valid");
			}
			
			EANProduct eanProduct = new EANProduct();
			
			Optional<Product> product = productServiceImpl.getProductByCode(ean.substring(0,7));
			Optional<Provider> provider = providerServiceImpl.getProviderByCode(ean.substring(7,12));
			Optional<Destination> destination = destinationServiceImpl.getDestinationByCode(ean.substring(12));
			
			if(product.isEmpty() || provider.isEmpty() || destination.isEmpty()) {
				throw new NoSuchElementException();
			} else {
				eanProduct.setProduct(product.get());
				eanProduct.setProvider(provider.get());
				eanProduct.setDestination(destination.get());
			}
			
			return eanProduct;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EANProduct not found");
		}
	}

	@Override
	public List<EANProduct> getEANProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
