package SAPRECORDS;

import java.util.List;

import APP.Person;
import APP.PersonRepository;
import APP.PersonRepositoryImpl;

public class QualifiedPerson {

	public static void main(String[] args) {
	PersonRepository personRepo = new PersonRepositoryImpl();
		
		List<Person> personList = personRepo.getQualifiedForSap();
		
		personPrint(personList);
			
		
	}
public static void personPrint (List<Person> p) {
	System.out.println("************************************* ");
	
	for (Person person : p) {
				System.out.println("id : " + person.getId() );
				System.out.println("Name : " + person.getFull_name());
				System.out.println("Address : " + person.getCity());
				System.out.println("Age : " + person.getAge());
				System.out.println("Salary : " + person.getSalary());
				System.out.println("Occupation : " + person.getOccupation());
				System.out.println("Other/Note : " + person.getOtherNote());
				System.out.println("Status: " + person.getStatus());
				System.out.println("************************************* ");
			
		
	}
	}

}
