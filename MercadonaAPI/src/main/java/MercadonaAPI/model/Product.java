package MercadonaAPI.model;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	//Product model that represents client data base table
	//It has getter, setter and constructors
	@Entity
	@Table(name = "product")
	public class Product {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		private String productCode;
		private String productName;
		private String expirationDate;
		private String description;

		public Product() {
		}

		public Product(Integer id, String productCode, String productName, String expirationDate, String description) {
			super();
			this.id = id;
			this.productCode = productCode;
			this.productName = productName;
			this.expirationDate = expirationDate;
			this.description = description;
		}
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getExpirationDate() {
			return expirationDate;
		}

		public void setExpirationDate(String expirationDate) {
			this.expirationDate = expirationDate;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
		public String getproductCode() {
			return productCode;
		}

		public void setproductCode(String productCode) {
			this.productCode = productCode;
		}

}
