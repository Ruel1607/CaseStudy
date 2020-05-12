package Crud;

import APP.Person;
import APP.PersonRepository;
import APP.PersonRepositoryImpl;

public class CreatePerson {

	public static void main(String[] args) {
PersonRepository personRepo = new PersonRepositoryImpl();
		
		Person person = new Person();
		person.setId(80);
		person.setFull_name("RUEL Sapul");
		person.setCity("Marikina City");
		person.setAge(28);
		person.setSalary(55000);
		person.setOccupation("Programmer");
		person.setOtherNote("DILAWAN");
		person.setStatus("SINGLE");
		
	 personRepo.addPerson(person);
		
		
		
	}

}
