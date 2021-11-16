package tn.esprit.spring.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Employe;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeServiceImplTest {
	
	@Autowired 
	IEmployeService es;
	
	
	@Test
	@Order(1)
	public void retrieveAllEmployes() {
		List<Employe> listEmps = es.retrieveAllEmployes();
		Assertions.assertTrue(listEmps.size()>=1);
	}
	

	@Test
 	@Order(2)
	public void testAddEmploye() {
		
		Employe emp = new Employe("hich", "dima","hich.dima@gmail.com", "azerty", false, Role.INGENIEUR);
		Employe empAdd = es.addEmploye(emp);
		Assertions.assertEquals(emp.getNom(), empAdd.getNom());
	}

	@Test
 	@Order(3)
	public void testUpdateEmploye() {
		Employe emp = new Employe(3L,"hich22", "dima22","dima22@gmail.com", "azerty22", true, Role.ADMINISTRATEUR);
		Employe empUpdated = es.addEmploye(emp);
		Assertions.assertEquals(emp.getEmail(), empUpdated.getEmail());
	}
	
	@Test
 	@Order(4)
	public void testRetrieveEmploye() {
		Employe empRetrieved = es.retrieveEmploye("3");
		Assertions.assertEquals(3L, empRetrieved.getId());
	}
	/*
	@Test
 	@Order(5)
	public void testDeleteEmploye(){
		es.deleteEmploye("16");
		Assertions.assertNull(es.retrieveEmploye("16"));
	}
	
	*/
	

	

 	
	

}
