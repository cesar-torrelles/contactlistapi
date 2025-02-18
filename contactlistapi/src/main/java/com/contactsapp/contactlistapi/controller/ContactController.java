package com.contactsapp.contactlistapi.controller;




import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.contactapp.contactlistapi.service.ContactService;
import com.contactsapp.contactlistapi.entity.Contact;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/api/contacts")


public class ContactController {
	
	
	private final ContactService contactService;{
		
	}
	
	
	
	
	@GetMapping
	public Iterable<Contact> list(){
		return contactService.findAll();
	}
	
	@GetMapping("{id}")
	public Contact get(@PathVariable Integer id) {
		return contactService.findById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Contact create(@RequestBody Contact contact) {
		return contactService.create(contact);			
	}
	
	@PutMapping("{id}")
	public Contact update(@PathVariable Integer id, @RequestBody Contact form) {
		return contactService.update(id,form);			
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		contactService.delete(id);
		
		
					
	}

}
