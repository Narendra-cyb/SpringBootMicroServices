package com.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Actor;
import com.spring.entity.User;

@RestController
@RequestMapping("/service")
public class ServiceController {

	// returning String as ResponseEntity
	@GetMapping("/msg/{id}/{msg}")
	public ResponseEntity<String> getMessage(@PathVariable Integer id, @PathVariable String msg) {
		return new ResponseEntity<String>("----Good Afternoon  " + id + " msg " + msg, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<String> postuser(@RequestBody User user) {
		return new ResponseEntity<String>("post user details are: " + user, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		return new ResponseEntity<String>("given user id is deleted: " + id, HttpStatus.OK);
	}

	// returning Actor as ResponseEntity
	@GetMapping("/request1")
	public ResponseEntity<String> getActorasObject() {
		Actor actor = new Actor();
		actor.setName("Raghav Lawrence");
		actor.setMovies("Jigarthanda Double X");
		return new ResponseEntity<String>(actor+"actor ", HttpStatus.OK);
	}

	// Returning List<Actor> as ResponseEntity
	@GetMapping("/request2")
	public ResponseEntity<List<Actor>> getAllActorList() {
		List<Actor> actors = List.of(new Actor("Vijay Setupathi", "Vikram"), new Actor("Ayushman", "Andhadhun"));
		return new ResponseEntity<List<Actor>>(actors, HttpStatus.OK);
	}

	// Returning List<Actor> as ResponseEntity
	@GetMapping("/request3")
	public ResponseEntity<Map<String,Object>> getAllActorAsMap() {
		Map<String,Object> actors = Map.of("Name","Narendra","Work","IT Employee");
		return new ResponseEntity<Map<String,Object>>(actors, HttpStatus.OK);
	}
}
