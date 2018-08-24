package com.example.service;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.example.model.Person;

@Service
public class PersonService {
	Hashtable<String, Person> persons = new Hashtable<>();
	public PersonService()
	{
		Person p1 = new Person();
		p1.setId("1");
		p1.setFirstName("frist");
		p1.setLastName("last");
		
		Person p2 = new Person();
		p2.setId("1");
		p2.setFirstName("second");
		p2.setLastName("last");
		
		persons.put("1", p1);
		persons.put("2", p2);
	}
	
	public Person getPerson(String id)
	{
		return persons.get(id);
	}
	
	public Hashtable<String, Person> getAll()
	{
		return persons;
	}
}
