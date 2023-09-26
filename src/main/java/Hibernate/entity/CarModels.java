package Hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CarModels {
	@Id
	private int modelId;
	private String modelName;
	
	@ManyToMany(mappedBy="models")
	private Set<CarManufacturer> manufacturer=new HashSet<CarManufacturer>();

	public CarModels() {
		super();
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Set<CarManufacturer> getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Set<CarManufacturer> manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	

}
