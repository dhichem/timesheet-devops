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
	
	//testing to commit in another branch

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
		l.info("In Method addUser :"); 
		User uSaved = userRepository.save(u); 
		l.info("Out Of Method addUser With Succes");
		return uSaved; 
	}

	@Override 
	public User updateUser(User u) { 
		l.info("In Method updateUser :"); 
		User uSaved = userRepository.save(u); 
		l.info("Out Of Method updateUser With Succes");
		return uSaved; 
	}

	@Override
	public void deleteUser(String id) {
		l.info("In Method deleteUser :");
		userRepository.deleteById(Long.parseLong(id)); 
		l.info("Out Of Method deleteUser With Succes");
	}

	@Override
	public User retrieveUser(String id) {
		User u=null;
		try {
			l.info("In Method retrieveUser :");
			u =  userRepository.findById(Long.parseLong(id)).orElse(null); 
			l.info("Out Of Method retrieveUser With Succes");
		}catch(Exception e) {
			l.info("Out Of Method retrieveUser With Error :"+e);
		}
		return u; 
	}

}
