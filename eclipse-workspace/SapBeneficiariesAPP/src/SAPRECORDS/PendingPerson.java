package SAPRECORDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import APP.Person;
import APP.PersonRepository;
import APP.PersonRepositoryImpl;

public class PendingPerson {

	public static void main(String[] args) throws IOException {
		PersonRepository personRepo = new PersonRepositoryImpl();
		
		List<Person> personList = personRepo.getPending();
		
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
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("type the id  you want to decide to give SAP: ");
			String ans = br.readLine();
			int personId = Integer.parseInt(ans);
			System.out.print("Do you want to Qualified the person? : Y/N ");
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
}

}
