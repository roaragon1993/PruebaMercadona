package MercadonaAPI.model;


public class FinalProduct {

	private Integer id;
	private Product product;
	private Provider provider;
	private Destination destination;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	@Override
	public String toString() {
		return "FinalProduct [id=" + id + ", product=" + product + ", provider=" + provider + ", destination="
				+ destination + "]";
	}

}
