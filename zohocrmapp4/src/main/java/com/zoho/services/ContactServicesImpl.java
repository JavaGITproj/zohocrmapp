package com.zoho.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoho.entities.Contacts;
import com.zoho.entities.Lead;
import com.zoho.repositories.ContactRepository;
import com.zoho.repositories.LeadRepository;

@Service
public class ContactServicesImpl implements ContactService {

	@Autowired
	private ContactRepository contactrepo;
	
	@Override
	public void saveContactInformation(Contacts contact) {
		contactrepo.save(contact);
   
	}

	@Override
	public List<Contacts> getAllContacts() {
		List<Contacts> contacts = contactrepo.findAll();
		return contacts;
	}

	@Override
	   public Contacts findContactById(long id) {
		Optional<Contacts> findById = contactrepo.findById(id);
	    Contacts contact=	findById.get();
		return contact;
	}

}
