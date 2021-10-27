package tn.esprit.spring.services;

import java.util.List;
import org.apache.logging.log4j.*;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	// TODO Logger à ajouter
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			// TODO Log à ajouter en début de la méthode 
			l.info("In method retrieveAllUsers() : ");
			
			users = (List<User>) userRepository.findAll();
			
			l.debug("Connexion à la base ok.");
			for (User user : users) {
				// TODO Log à ajouter pour affiher chaque user dans les logs
				l.info("user : " + user);
			} 
			// TODO Log à ajouter à la fin de la méthode 
			l.info("out of retrieveAllUsers with success ");
		}catch (Exception e) {
			// TODO Log à ajouter pour gérer les erreurs
			
			l.error("out of retrieveAllUsers with failure : " + e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		// TODO Log à ajouter en début de la méthode 
		l.info("In method addUser() : ");
		
		User u_saved = userRepository.save(u); 
		
		// TODO Log à ajouter à la fin de la méthode 
		l.info("Out method addUser() : ");
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		// TODO Log à ajouter en début de la méthode 
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		userRepository.deleteById(Long.parseLong(id)); 
		// TODO Log à ajouter à la fin de la méthode 
	}

	@Override
	public User retrieveUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		// TODO Log à ajouter à la fin de la méthode 
		return u; 
	}

}
