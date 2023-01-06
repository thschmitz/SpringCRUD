package com.thschmitz.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.thschmitz.workshopmongo.domain.Post;
import com.thschmitz.workshopmongo.dto.UserDTO;
import com.thschmitz.workshopmongo.services.PostService;

public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}