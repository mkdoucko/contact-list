package com.app.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.model.Contact;

public interface ContactRepo extends CrudRepository<Contact, Long> {
    List<Contact> findByLastName(/* String firstName, */ String lastName); // ?
}