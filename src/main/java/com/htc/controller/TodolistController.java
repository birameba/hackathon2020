package com.htc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.exception.ResourceNotFoundException;
import com.htc.model.Todolist;
import com.htc.repository.TodolistRepository;


@RestController
@RequestMapping("/")
public class TodolistController {

	@Autowired
	private TodolistRepository  todolistRepository;
	
	@GetMapping("/todolist")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	public List<Todolist> getAlltodolist(){
		return todolistRepository.findAll();
	}
	
	@GetMapping("/todolist/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	public ResponseEntity<Todolist> getChargesById(@PathVariable(value = "id") Long id)
	throws ResourceNotFoundException
	{
		Todolist todolist = todolistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todolist non trouvé sur ::","",+id));
		return ResponseEntity.ok().body(todolist);
	}

	@PostMapping("/todolist")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	public Todolist createTodolist(@Valid @RequestBody Todolist todolist)
	{
		return todolistRepository.save(todolist);
	}

	@PutMapping("/todolist/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	public ResponseEntity<Todolist> updateTodolist(
	    @PathVariable(value = "id") Long id, @Valid @RequestBody Todolist todolistDetails)
	    throws ResourceNotFoundException {

		Todolist todolist =
				todolistRepository
	          .findById(id)
	          .orElseThrow(() -> new ResourceNotFoundException("Todolist non trouvé sur ::","",+id));

		todolist.setNom(todolistDetails.getNom());
		todolist.setDescription(todolistDetails.getDescription());
	  final Todolist updateTodolist = todolistRepository.save(todolist);
	  return ResponseEntity.ok(updateTodolist);
	}

	@DeleteMapping("/todolist/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	public Map<String, Boolean> deleteTodolist(@PathVariable(value = "id") Long id) throws Exception {
		Todolist todolist =
				todolistRepository
	          .findById(id)
	          .orElseThrow(() -> new ResourceNotFoundException("Todolist  non trouvé sur ::","",+id));

		todolistRepository.delete(todolist);
	  Map<String, Boolean> response = new HashMap<>();
	  response.put("deleted", Boolean.TRUE);
	  return response;
	}
}
