package com.distilled.sch.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity Class for Beer.
 * @author Deepika Vashishtha
 *
 */
@Entity 
@Table(name="beer")
@NamedNativeQuery(name="Beer.findRandomRecord", query="select * from beer ORDER BY RAND() LIMIT 1", resultClass = Beer.class)
public class Beer implements Serializable{
	private static final long serialVersionUID = 1L;
	public Beer() {}
    public Beer(Integer id, String name, String description, float alcoholPercentage, String breweryLocation) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.alcoholPercentage = alcoholPercentage;
		this.breweryLocation = breweryLocation;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    private String name;

    private String description;
    private float alcoholPercentage;
    private String breweryLocation;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAlcoholPercentage() {
		return alcoholPercentage;
	}

	public void setAlcoholPercentage(float alcoholPercentage) {
		this.alcoholPercentage = alcoholPercentage;
	}

	public String getBreweryLocation() {
		return breweryLocation;
	}

	public void setBreweryLocation(String breweryLocation) { 
		this.breweryLocation = breweryLocation;
	}
}
