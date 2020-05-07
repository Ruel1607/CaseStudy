package APP;

import java.util.List;

public interface PersonRepository {

	public List<Person> getPerson();
	public String addPerson(Person person);
	public String updatePerson(int id, Person person);
	public String deletePerson(int id);
	public List<Person> getQualifiedForSap();
	public List<Person> getDenied();
	public List<Person> getPending();
	
	
}
