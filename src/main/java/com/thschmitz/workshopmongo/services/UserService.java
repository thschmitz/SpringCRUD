package com.thschmitz.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thschmitz.workshopmongo.domain.User;
import com.thschmitz.workshopmongo.dto.UserDTO;
import com.thschmitz.workshopmongo.repository.UserRepository;
import com.thschmitz.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository; // Todas as funcoes aqui estao sendo obtidas por meio da extensao feita dentro da interface do repository
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
	
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
