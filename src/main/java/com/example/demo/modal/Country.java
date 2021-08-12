package com.example.demo.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="countries")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="country_name")
	private String name;
	
	
	public Country(String name) {
		super();
		this.name = name;
	}
	
	
	public Country() {
		
	}
	
	
	
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
