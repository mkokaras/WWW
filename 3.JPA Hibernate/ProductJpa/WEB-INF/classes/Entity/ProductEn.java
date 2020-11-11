package Entity;

import javax.persistence.*;

@Entity
@Table(name="products")

public class ProductEn{
	@Id
	@Column(name="barcode")
	private String barcode;
	
	@Column(name="color")
	private String color;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	public ProductEn() {
		super();
		this.barcode="default";
		this.color="default";
		this.name="default";
		this.description="default";
	}
	public ProductEn(String barcode, String color,String name,String description) {
		super();
		this.barcode=barcode;
		this.color = color;
		this.name = name;
		this.description = description;
	}

	public String getBarcode() {return barcode;}
	public String getColor() {return color;}
	public String getName() {return name;}
	public String getDescription() {return description;}
	@Override
	public String toString() {return "Product [barcode=" + barcode+ ", name=" + name + ", color=" + color + ", description=" + description + "]";}
}
