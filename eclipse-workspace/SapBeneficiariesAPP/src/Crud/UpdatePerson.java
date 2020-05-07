package Crud;

import java.util.List;

import APP.Person;
import APP.PersonRepository;
import APP.PersonRepositoryImpl;

public class UpdatePerson {

	public static void main(String[] args) {
		PersonRepository personRepo = new PersonRepositoryImpl();
		
		List<Person> personList = personRepo.getPerson();
		
		
		Person person = personList.get(0);
		person.setFull_name("UPDATED NAME");
		person.setCity("MAKATI");
		person.setAge(200);
		person.setSalary(500);
		person.setOccupation("MANICURIST");
		person.setOtherNote("PEDICURE");
		person.setStatus("MARRIED");
		personRepo.updatePerson(200, person); 
	}

}
