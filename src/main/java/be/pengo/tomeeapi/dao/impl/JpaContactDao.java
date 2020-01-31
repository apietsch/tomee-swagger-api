package be.pengo.tomeeapi.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.pengo.tomeeapi.dao.ContactDao;
import be.pengo.tomeeapi.entities.Contact;

@Stateless
@Default
public class JpaContactDao implements ContactDao{

	@PersistenceContext(unitName = "myPU")
	private EntityManager em;

	@Override
	public Contact find(Long id){
    	return em.find(Contact.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
	public List<Contact> findAll(Integer first, Integer max) {
        final Query query = em.createQuery("SELECT c FROM Contact c ORDER BY c.id");
        if (first !=null  && max != null ) {
			query.setFirstResult(first);
			query.setMaxResults(max);
		}
        return (List<Contact>) query.getResultList();
    }

    @Override
    public Contact findByEmail(String email){
    	Contact contact = null;
    	final Query query = em.createQuery("SELECT c FROM Contact c WHERE c.email = :email");
        query.setParameter("email", email);
        try{
        	contact = (Contact) query.getSingleResult();
        } catch (NoResultException nre){
        	// sillently return null
        }
        return contact;
    }

    @Override
    public Contact save(Contact contact) {
		em.persist(contact);
		return contact;
	}

    @Override
	public Long count() {
		String sql = "SELECT COUNT(c) FROM Contact c";
		Query q = em.createQuery(sql);
		return (Long)q.getSingleResult();
	}

    @Override
	public void remove(Long id) {
		em.remove(find(id));
	}

    @Override
	public Contact upadte(Contact contact) {
		em.merge(contact);
		return contact;
	}

}
