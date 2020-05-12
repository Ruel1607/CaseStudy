package SAPRECORDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import APP.Person;
import APP.PersonRepository;
import APP.PersonRepositoryImpl;

public class QualifiedPerson {

	public static void main(String[] args) throws IOException {
	PersonRepository personRepo = new PersonRepositoryImpl();
		
		List<Person> personList = personRepo.getQualifiedForSap();
		
		personPrint(personList);
			
		
	}
public static void personPrint (List<Person> p) throws IOException {
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
	String ans2 = null;
	do {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("type the id to update the status of the person: ");
		String ans = br.readLine();
		int personId = Integer.parseInt(ans);
			System.out.print(" the person is qualified ? Y/N ");
			String ans1 = br.readLine();
			if (ans1.equalsIgnoreCase("Y")) {
				PersonRepository personRepo = new PersonRepositoryImpl();
			
		 List<Person> personList = personRepo.getPerson();
		 
		 Person p1 = personList.get(0);
		 p1.setStatus("QUALIFIED");
		 personRepo.getStatusUpdate(personId, p1);
		 System.out.println("UPDATED STATUS AND WILL RECIEVED SAP");
	 }
	 else {
		 System.out.println("********END********");
	 }
			System.out.println("Do you want to continue? Y/N" );
			 ans2 = br.readLine();
	} while (ans2.equalsIgnoreCase("Y"));
	System.out.println("THANKS");
	
	
}	
	

}
