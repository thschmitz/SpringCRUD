package com.thschmitz.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thschmitz.workshopmongo.domain.Post;
import com.thschmitz.workshopmongo.repository.PostRepository;
import com.thschmitz.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> user = repository.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException(id));
		
	}
	
	public List<Post> findByTitle(String text) {
		return repository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // To fazendo isso daqui para ele pegar meia noite do proximo dia e nao meia noite do dia que queremos pq dai se eu enviar um dado do dia ele nao vai passar na condicao <= maxDate
		return repository.fullSearch(text, minDate, maxDate);
	}
}
