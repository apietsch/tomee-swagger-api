package es.jsmontesinos.tomeeapi.controllers;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import es.jsmontesinos.tomeeapi.dao.ContactDao;
import es.jsmontesinos.tomeeapi.entities.Contact;
import es.jsmontesinos.tomeeapi.exceptions.ContactDupplicatedException;
import es.jsmontesinos.tomeeapi.exceptions.ContactNotFoundException;

@Stateless
public class ContactController {

	@Inject
	private ContactDao cdao;

    public Contact getById(Long id){
    	return cdao.find(id);
    }

    public List<Contact> getAll(int first, int max) {
        return cdao.findAll(first, max);
    }

    public Contact save(Contact contact) {
    	if(cdao.findByEmail(contact.getEmail()) != null) {
	        throw new ContactDupplicatedException();
	    }
		return cdao.save(contact);
	}

	public Long count() {
		return cdao.count();
	}

	public void remove(Long id) {
		if(cdao.find(id) == null) {
	        throw new ContactNotFoundException();
	    }
		cdao.remove(id);
	}

	public Contact upadte(Contact contact) {
		return cdao.upadte(contact);
	}


}
