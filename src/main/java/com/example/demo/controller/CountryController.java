package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Country;
import com.example.demo.repository.CountryRepository;


@RestController
@RequestMapping("rest/v2/")
public class CountryController {

	@Autowired
	private CountryRepository countryRepository;
	
	
	@GetMapping("countries")
	public List<Country> getCountries(){
		return this.countryRepository.findAll();
	}
	
	//create country
	@PostMapping("/countries")
	public Country createCountry(@RequestBody Country country) {
		return countryRepository.save(country);
	}
	
	
	//update country
	@PutMapping("countries/{id}")
	public ResponseEntity<Country> updateCountry( @PathVariable Long id, @RequestBody Country countryInfo){
		Country country = countryRepository.findById(id)
				.orElseThrow();
		
		country.setName(countryInfo.getName());
		
		Country updatedCountry = countryRepository.save(country);
		
		return ResponseEntity.ok(updatedCountry);
		
	}
	
	
	//delete country
	@DeleteMapping("/countries/{id}")
	public ResponseEntity <Map<String, Boolean>> deleteCountry(@PathVariable Long id){
		Country country = countryRepository.findById(id)
				.orElseThrow();
		
		countryRepository.delete(country);
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
