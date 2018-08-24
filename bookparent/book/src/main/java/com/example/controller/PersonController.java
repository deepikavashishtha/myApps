package com.example.controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	PersonService personService ;
	
	@RequestMapping("/all")
	public Hashtable<String, Person> getAll()
	{
		return personService.getAll();
	}
	
	@RequestMapping("{id}")
	public Person getPerson(@PathVariable("id") String id )
	{
		return personService.getPerson(id);
	}
}
