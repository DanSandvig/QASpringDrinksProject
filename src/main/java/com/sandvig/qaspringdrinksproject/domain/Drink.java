package com.sandvig.qaspringdrinksproject.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Drink {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Drink must have a name")
	private String name;
	
	@NotNull(message = "Drink must have a volume")
	private int volumeMl;
	
	@NotNull(message = "Drink must be carbonated or not")
	private boolean carbonated;
	
	@NotNull(message = "Drink must have a stock level, even if zero")
	private int stock;
	
	
	public Drink() {
		
	}

	//Test Constructor
	public Drink(long id, String name, int volumeMl, boolean carbonated, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.volumeMl = volumeMl;
		this.carbonated = carbonated;
		this.stock = stock;
	}

	//Production Constructor
	public Drink(String name, int volumeMl, boolean carbonated, int stock) {
		super();
		this.name = name;
		this.volumeMl = volumeMl;
		this.carbonated = carbonated;
		this.stock = stock;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVolumeMl() {
		return volumeMl;
	}

	public void setVolumeMl(int volumeMl) {
		this.volumeMl = volumeMl;
	}

	public boolean isCarbonated() {
		return carbonated;
	}

	public void setCarbonated(boolean carbonated) {
		this.carbonated = carbonated;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", name=" + name + ", volumeMl=" + volumeMl + ", carbonated=" + carbonated
				+ ", stock=" + stock + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carbonated, name, stock, volumeMl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drink other = (Drink) obj;
		return carbonated == other.carbonated && Objects.equals(name, other.name) && stock == other.stock
				&& volumeMl == other.volumeMl;
	}
	
}
