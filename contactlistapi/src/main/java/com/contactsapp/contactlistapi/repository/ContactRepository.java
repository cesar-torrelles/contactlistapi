package com.contactsapp.contactlistapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.contactsapp.contactlistapi.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
