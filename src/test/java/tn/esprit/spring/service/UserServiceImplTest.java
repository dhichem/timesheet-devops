package tn.esprit.spring.service;

 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;


@SpringBootTest
class UserServiceImplTest {
	
	@Autowired
	IUserService us;

	@Test
	public void testRetrieveAllUsers() {
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(1, listUsers.size());
	}
	
	
	/*@Test
	public void testAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("2015-03-23");
		User user = new User("jim", "bob", date, Role.TECHNICIEN); 
		User userAdded = us.addUser(user); 
		
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(2, listUsers.size());
	}*/

}
