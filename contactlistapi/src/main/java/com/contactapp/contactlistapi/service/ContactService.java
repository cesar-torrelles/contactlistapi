package com.contactapp.contactlistapi.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.contactsapp.contactlistapi.entity.Contact;
import com.contactsapp.contactlistapi.repository.ContactRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ContactService {
	
	
	private final ContactRepository contactRepository;
	
	
	public Iterable<Contact> findAll(){
		return contactRepository.findAll();
	}
	
	public Contact findById(Integer id) {
		return contactRepository
			.findById(id)
			.orElse(null);
	}
	
	public Contact get(@PathVariable Integer id) {
		return contactRepository 
				.findById(id)
				.orElse(null);
	}
	
	
	public Contact create(Contact contact) {
		contact.setCreatedAt(LocalDateTime.now());
		return contactRepository.save(contact);			
	}
	
	
	public Contact update(Integer id, Contact form) {
		Contact contactFromDb = findById(id);
		contactFromDb.setName(form.getName());
		contactFromDb.setEmail(form.getEmail());
		
		return contactRepository.save(contactFromDb);			
	}

	
	public void delete(Integer id) {
		Contact contactFromDb = findById(id);
				
		contactRepository.delete(contactFromDb);
	}
}
