package com.neebalgurukul.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neebalgurukul.exceptions.UserAlreadyExistsException;
import com.neebalgurukul.exceptions.UserNotFoundException;
import com.neebalgurukul.model.Login;
import com.neebalgurukul.model.Student;

public class StudentDao {
	
	Connection conn =null;
	Statement stmt = null;
	ResultSet rs = null;
	DataSource ds = new DataSource();
	
	
	public List<Student> getStudentDetails() throws SQLException {
		List<Student> studentsList = new ArrayList<Student>();
		String query = "select id,name,username,password,email,course,age from students";
		
		Connection conn=ds.getConnection();
		
		try {	
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs!=null) {
				while(rs.next()) { //goes i=0 to n for ur query
					Student studObj = new Student();
					studObj.setId(Integer.parseInt(rs.getString("id")));
					studObj.setName(rs.getString("name")); //gets ith record at column username in sql query output
					studObj.setEmail(rs.getString("email"));
					studObj.setCourse(rs.getString("course"));
					studObj.setUsername(rs.getString("username"));
					studObj.setPassword(rs.getString("password"));
					studObj.setAge(Integer.parseInt(rs.getString("age")));
					
					
					studentsList.add(studObj);
				}
			}
			
		} catch (SQLException e) {
			throw new SQLException();
		}
		
		finally {
			conn.close();
		}
		
		return studentsList;
	}
	
	
//	
//	public Student getStudent(int id) throws Exception {
//		String query = "select id,name,email,course,age from students where id = ?";
//		Student studObj = new Student();
//		
//		conn = ds.getConnection();
//		
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1,id);
//			ResultSet rs = pstmt.executeQuery();
//			
//			if(rs!=null) {
//				while(rs.next()) { //goes i=0 to n for ur query
//					studObj.setId(Integer.parseInt(rs.getString("id")));
//					studObj.setName(rs.getString("name")); //gets ith record at column username in sql query output
//					studObj.setEmail(rs.getString("email"));
//					studObj.setCourse(rs.getString("course"));
//					studObj.setAge(Integer.parseInt(rs.getString("age")));
//					
//					
//				}
//			}
//			
//			if(studObj.getEmail()==null) {
//				System.out.println("hello");
//				throw new UserNotFoundException();
//			}
//			
//		} 
//		
//		
//	
//		
//		
//		catch (SQLException e) {
//			throw new UserNotFoundException();
//		}
//		finally {
//			conn.close();
//		}
//		
//		return studObj;
//		
//	}
	
	
	public Student getStudent(String username) throws Exception {
		String query = "select id,name,username,password,email,course,age from students where username = ?";
		Student studObj = new Student();
		
		conn = ds.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,username);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) { //goes i=0 to n for ur query
					studObj.setId(Integer.parseInt(rs.getString("id")));
					studObj.setName(rs.getString("name")); //gets ith record at column username in sql query output
					studObj.setEmail(rs.getString("email"));
					studObj.setCourse(rs.getString("course"));
					studObj.setAge(Integer.parseInt(rs.getString("age")));
					studObj.setUsername(rs.getString("username"));
					studObj.setPassword(rs.getString("password"));
					
					
				}
			}
			
			
			
		} catch (SQLException e) {
			throw new UserNotFoundException();
		}
		finally {
			conn.close();
		}
		
		return studObj;
		
	}
	
	
//	public Student getStudentByUsername(String username) throws Exception {
//		String query = "select id,name,email,course,age from students where username = ?";
//		Student studObj = new Student();
//		
//		conn = ds.getConnection();
//		
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(query);
//			pstmt.setString(1,username);
//			ResultSet rs = pstmt.executeQuery();
//			
//			if(rs!=null) {
//				while(rs.next()) { //goes i=0 to n for ur query
//					studObj.setId(Integer.parseInt(rs.getString("id")));
//					studObj.setName(rs.getString("name")); //gets ith record at column username in sql query output
//					studObj.setEmail(rs.getString("email"));
//					studObj.setCourse(rs.getString("course"));
//					studObj.setAge(Integer.parseInt(rs.getString("age")));
//					
//					
//				}
//			}
//			
//			
//			
//		} catch (SQLException e) {
//			throw new UserNotFoundException();
//		}
//		finally {
//			conn.close();
//		}
//		
//		return studObj;
//		
//	}
	
	public  boolean insertRecord(String name,String username, String password, String email, String course,int age) throws Exception {
		
		String query = "insert into students (name,username,password,email,course,age) values (?,?,?,?,?,?)";
		conn=ds.getConnection();
		
		try {
			
			StudentDao dao = new StudentDao();
			Student check = dao.getStudent(username); 
			if(check.getEmail()!=null)	// will check if student already exists
				throw new UserAlreadyExistsException();
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.setString(4, email);
			pstmt.setString(5, course);
			pstmt.setInt(6, age);
			pstmt.executeUpdate();
			
			
		} catch (UserAlreadyExistsException e) {
			throw new UserAlreadyExistsException();
		}
		catch (SQLException e) {
			System.out.println("SQLException: "+e.getMessage());
			throw new SQLException(e);
		}
		finally {
			conn.close();
		}
		
		
		
		return true;
	}
	
	public  boolean deleteRecordHard(String username) throws Exception{
		String query = "delete from students where username = ?";
		conn=ds.getConnection();
		
		try {
			//check if username exists
			StudentDao dao = new StudentDao();
			Student check = dao.getStudent(username); 
			
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, username);
			pstmt.executeUpdate();
		} 	
		
		catch(Exception e) { //will catch and throw the general exception. the specific exception will be handled in studentTest. 
			throw e;
		}
		finally {
			conn.close();
		}
		return true;
	}
	
	public boolean updateCourse(String username, String newCourse) throws Exception {
		conn = ds.getConnection();
		
		try {
			//check if username exists
			StudentDao dao = new StudentDao();
			Student check = dao.getStudent(username); 
			
			
			String query = "update students set course = ? where username = ?";
			conn=ds.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, newCourse);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
			
		} 
		catch (UserNotFoundException e) {
			throw new UserNotFoundException();
		}

		catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		}
		finally {
			conn.close();
		}
		return true;
	}
	
	
	


}