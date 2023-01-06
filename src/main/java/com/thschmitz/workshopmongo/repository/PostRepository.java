package com.thschmitz.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.thschmitz.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	// Sintaxe do Query aqui: https://www.mongodb.com/docs/manual/reference/operator/query/
	
	@Query("{ 'title': { $regex: ?0, $options: 'i'} }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	// O Date tem que ser maior que a data minima e menor que a data maxima, isso que as suas primeira funcoes da query faz.
	@Query("{ $and: [ { date: {$gte: ?1 } }, { date: { $lte: ?2 } } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i'}  } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
