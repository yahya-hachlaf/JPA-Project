package dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Person;

public class PersonDAO {
	private EntityManagerFactory factory;
	private EntityManager em;

	public PersonDAO() {
		factory = Persistence.createEntityManagerFactory("JPAKursprojekt");
		em = factory.createEntityManager();
	}

	public void shutdown() {
		em.close();
		factory.close();
		em = null;
		factory = null;
	}

	public Person find(long id) {
		return em.find(Person.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Person> findAll() {
		Query query = em.createQuery("SELECT p FROM Person p");
		Collection<Person> collection;
		collection = (Collection<Person>) query.getResultList();
		return collection;
	}
	
	public Person findByVorname(String vorname) {
		Person p = (Person) em.createQuery("select p from Person p where p.vorname = :vn")
				.setParameter("vn", vorname)
				.getSingleResult();
		return p;
	}
	
	
	public void persist(Person p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	

	public void delete(long id) {
		em.getTransaction().begin();
		Person p = em.getReference(Person.class, id);
		em.remove(p);
		em.getTransaction().commit();
	}
}
