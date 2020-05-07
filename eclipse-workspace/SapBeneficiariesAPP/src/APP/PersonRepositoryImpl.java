package APP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PersonRepositoryImpl implements PersonRepository{
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public List<Person> getPerson() {
		Connection con = connectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Person> personList = new ArrayList<>();
		try {
			con.setAutoCommit(false);
			String query = "SELECT * FROM person";
			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getInt("id"));
				person.setFull_name(resultSet.getString("full_name"));
				person.setCity(resultSet.getString("address"));
				person.setAge(resultSet.getInt("age"));
				person.setSalary(resultSet.getDouble("income"));
				person.setOccupation(resultSet.getString("work"));
				person.setOtherNote(resultSet.getString("other_note"));
				person.setStatus(resultSet.getString("status"));
				personList.add(person);			
			}
			
		} catch (Exception e) {
	
		}	finally {
			connectionPool.closeConnection(con, preparedStatement);
		}
		
		return personList;
	}

	@Override
	public String addPerson(Person person) {
		Connection con = connectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			con.setAutoCommit(false );
			String query = "INSERT INTO PERSON(id,full_name,address,age,income,work,other_note,status)" + "VALUES(?,?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1,  person.getId());
			preparedStatement.setString(2,  person.getFull_name());
			preparedStatement.setString(3,  person.getCity());
			preparedStatement.setInt(4,  person.getAge());
			preparedStatement.setDouble(5,  person.getSalary());
			preparedStatement.setString(6,  person.getOccupation());
			preparedStatement.setString(7,  person.getOtherNote());
			preparedStatement.setString(8,  person.getStatus());
			
			
			preparedStatement.executeUpdate(); 
			con.commit();
			preparedStatement.close();		
			System.out.println("SUCCESS ADDED");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			connectionPool.closeConnection(con, preparedStatement);
		}
		
		return "PERSON ADDED SUCCESFULLY";
	}

	@Override
	public String updatePerson(int id, Person person) {
		Connection con = connectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			con.setAutoCommit(false );
			String query = "Update person set full_name = ?,address = ?,age = ?,income = ?,work = ?,other_note =?,status = ? WHERE id = ?;";
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1,  person.getFull_name());
			preparedStatement.setString(2,  person.getCity());
			preparedStatement.setInt(3,  person.getAge());
			preparedStatement.setDouble(4,  person.getSalary());
			preparedStatement.setString(5,  person.getOccupation());
			preparedStatement.setString(6,  person.getOtherNote());
			preparedStatement.setString(7,  person.getStatus());
			preparedStatement.setInt(8, id);
			preparedStatement.executeUpdate(); 
			con.commit(); 
			preparedStatement.close();		
			System.out.println("SUCCESS UPDATED ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			connectionPool.closeConnection(con, preparedStatement);
		}
		
		return "PERSON UPDATED SUCCESFULLY";
	}
	

	@Override
	public String deletePerson(int id) {
		Connection con = connectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			con.setAutoCommit(false );
			String query = "Delete From person where id = ?";
			preparedStatement = con.prepareStatement(query);
			
		
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate(); 
			con.commit(); 
			preparedStatement.close();		
			System.out.println("SUCCESS DELETED ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			connectionPool.closeConnection(con, preparedStatement);
		}
		
		return "PERSON DELETED SUCCESFULLY";
	}
	
	public List<Person> getQualifiedForSap() {
		Connection con = connectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Person> personList = new ArrayList<>();
		try {
			con.setAutoCommit(false);
			String query = "select * from person where income <= 1000 and other_note != \"ECQ VIOLATOR\";";
			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getInt("id"));
				person.setFull_name(resultSet.getString("full_name"));
				person.setCity(resultSet.getString("address"));
				person.setAge(resultSet.getInt("age"));
				person.setSalary(resultSet.getDouble("income"));
				person.setOccupation(resultSet.getString("work"));
				person.setOtherNote(resultSet.getString("other_note"));
				person.setStatus(resultSet.getString("status"));
				personList.add(person);			
			}
			
		} catch (Exception e) {
	
		}	finally {
			connectionPool.closeConnection(con, preparedStatement);
		}
		
		return personList;
	}
	
	public List<Person> getDenied() {
		Connection con = connectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Person> personList = new ArrayList<>();
		try {
			con.setAutoCommit(false);
			String query = "select * from person where income >= 3500 OR other_note = \"ECQ VIOLATOR\";";
			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getInt("id"));
				person.setFull_name(resultSet.getString("full_name"));
				person.setCity(resultSet.getString("address"));
				person.setAge(resultSet.getInt("age"));
				person.setSalary(resultSet.getDouble("income"));
				person.setOccupation(resultSet.getString("work"));
				person.setOtherNote(resultSet.getString("other_note"));
				person.setStatus(resultSet.getString("status"));
				personList.add(person);			
			}
			
		} catch (Exception e) {
	
		}	finally {
			connectionPool.closeConnection(con, preparedStatement);
		}
		
		return personList;
	}
	@Override
	public List<Person> getPending() {
		Connection con = connectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Person> personList = new ArrayList<>();
		try {
			con.setAutoCommit(false);
			String query = "select * from person where income >= 1000 AND income <3000 And other_note != \"ECQ VIOLATOR\";";
			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getInt("id"));
				person.setFull_name(resultSet.getString("full_name"));
				person.setCity(resultSet.getString("address"));
				person.setAge(resultSet.getInt("age"));
				person.setSalary(resultSet.getDouble("income"));
				person.setOccupation(resultSet.getString("work"));
				person.setOtherNote(resultSet.getString("other_note"));
				person.setStatus(resultSet.getString("status"));
				personList.add(person);			
			}
			
		} catch (Exception e) {
	
		}	finally {
			connectionPool.closeConnection(con, preparedStatement);
		}
		
		return personList;
	}

	@Override
	public String getStatusUpdate(int id, Person person) {
		Connection con = connectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			con.setAutoCommit(false );
			String query = "Update person set status = ? WHERE id = ?;";
			preparedStatement = con.prepareStatement(query);
			
			
			preparedStatement.setString(1,  person.getStatus());
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate(); 
			con.commit(); 
			preparedStatement.close();		
			System.out.println("SUCCESS UPDATED ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			connectionPool.closeConnection(con, preparedStatement);
		}
		
		return "PERSON UPDATED SUCCESFULLY";
	}
	

}

