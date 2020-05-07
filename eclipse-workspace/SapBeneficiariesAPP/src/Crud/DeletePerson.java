package Crud;

import java.util.List;

import APP.Person;
import APP.PersonRepository;
import APP.PersonRepositoryImpl;

public class DeletePerson {

	public static void main(String[] args) {
	PersonRepository personRepo = new PersonRepositoryImpl();
		
		String status = "";
		status = personRepo.deletePerson(200);
		System.out.println(status );
		List<Person> personList = personRepo.getPerson();
		
		RetrievePerson.personPrint(personList);
			
	}

	

	
	

		
	}


