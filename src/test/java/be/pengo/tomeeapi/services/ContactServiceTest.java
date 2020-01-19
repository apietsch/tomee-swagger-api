package be.pengo.tomeeapi.services;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import be.pengo.tomeeapi.controllers.ContactController;
import be.pengo.tomeeapi.dao.ContactDao;
import be.pengo.tomeeapi.entities.Contact;
import be.pengo.tomeeapi.exceptions.ContactDupplicatedException;
import be.pengo.tomeeapi.exceptions.ContactNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {

	@Mock
	private ContactDao cdao;

	@InjectMocks
    private ContactController service;

	@Test(expected = ContactNotFoundException.class)
	public void should_throw_exception_if_remove_not_existing_contact() {
		when(cdao.find(anyLong())).thenReturn(null);

		service.remove(Long.valueOf(1));
	}

	@Test(expected = ContactDupplicatedException.class)
	public void should_throw_exception_if_dupplicated_email_contact() {
		Contact contact = new Contact();
		when(cdao.findByEmail(anyString())).thenReturn(contact);

		service.save(contact);
	}

	@Test
	public void should_call_remove_if_id_exists() {
		Contact contact = new Contact();
		contact.setId(Long.valueOf(1));
		when(cdao.find(anyLong())).thenReturn(contact);

		service.remove(Long.valueOf(1));

		verify(cdao).remove(contact.getId());
	}


}
