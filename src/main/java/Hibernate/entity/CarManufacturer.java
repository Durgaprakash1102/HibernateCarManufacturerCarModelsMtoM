package Hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class CarManufacturer {
	@Id
	private int manufacturingId;
	private String manufacturerName;
	
	@ManyToMany
	@JoinTable(name="Manufacturer_Models",joinColumns=@JoinColumn(name="manufacturingId"),inverseJoinColumns=@JoinColumn(name="modelId"))
	private Set<CarModels> models=new HashSet<CarModels>();

	public CarManufacturer() {
		super();
	}

	public int getManufacturingId() {
		return manufacturingId;
	}

	public void setManufacturingId(int manufacturingId) {
		this.manufacturingId = manufacturingId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public Set<CarModels> getModels() {
		return models;
	}

	public void setModels(Set<CarModels> models) {
		this.models = models;
	}
	

}
