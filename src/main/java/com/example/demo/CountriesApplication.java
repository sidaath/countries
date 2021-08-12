package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modal.Country;
import com.example.demo.repository.CountryRepository;

@SpringBootApplication
public class CountriesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CountriesApplication.class, args);
	}
	
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public void run(String... args) throws Exception {
		this.countryRepository.save(new Country("Country 1"));
		this.countryRepository.save(new Country("Country 2"));
		this.countryRepository.save(new Country("Country 3"));
		this.countryRepository.save(new Country("Country 4"));
		this.countryRepository.save(new Country("Country 5"));

		
	}

}
