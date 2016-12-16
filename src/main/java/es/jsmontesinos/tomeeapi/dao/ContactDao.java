package es.jsmontesinos.tomeeapi.dao;

import java.util.List;

import es.jsmontesinos.tomeeapi.entities.Contact;

public interface ContactDao {

	Contact find(Long id);

	List<Contact> findAll(int first, int max);

	Contact save(Contact contact);

	Long count();

	void remove(Long id);

	Contact upadte(Contact contact);

	Contact findByEmail(String email);

}
