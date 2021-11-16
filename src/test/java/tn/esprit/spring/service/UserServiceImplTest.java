package tn.esprit.spring.service;

 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class UserServiceImplTest {
	
	@Autowired
	IUserService us;

	@Test
	@Order(1)
	public void testGetAllUsers() {
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertTrue(listUsers.size()>=2);
	}
	
	
	@Test
	@Order(2)
	public void testAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("2000-01-09");
		User user = new User("foulen", "benfoulen", date, Role.INGENIEUR); 
		User userAdded = us.addUser(user); 
		Assertions.assertEquals(user.getLastName(), userAdded.getLastName());
	}
 
	@Test
	@Order(3)
	public void testUpdateUser() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("2005-01-09");
		User user = new User(10L, "mohamed", "benahmed", date, Role.INGENIEUR); 
		User userUpdated  = us.updateUser(user); 
		Assertions.assertEquals(user.getLastName(), userUpdated.getLastName());
	}

	@Test
	@Order(4)
	public void testGetUser() {
		User userRetrieved = us.retrieveUser("10"); 
		Assertions.assertEquals(10L, userRetrieved.getId());
	}
	
//	
//	@Test
//	@Order(5)
//	public void testDeleteUser() {
//	
//		us.deleteUser("9");
//		Assertions.assertNull(us.retrieveUser("9"));
//
//	}

}
