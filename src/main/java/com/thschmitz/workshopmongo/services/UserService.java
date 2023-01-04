package com.thschmitz.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thschmitz.workshopmongo.domain.User;
import com.thschmitz.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository; // Todas as funcoes aqui estao sendo obtidas por meio da extensao feita dentro da interface do repository
	
	public List<User> findAll() {
		return repository.findAll();
	}
}
