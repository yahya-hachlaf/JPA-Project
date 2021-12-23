import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.PersonDAO;
import model.Geschlecht;
import model.Person;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAKursprojekt");
		EntityManager em = factory.createEntityManager();
		
		/****** ein neues Person anlegen ******/
		
//		Person  person = new Person();
//		
//		person.setVorname("Max");
//		person.setNachname("Mustermann");
//		
//		
//		em.getTransaction().begin();
//		
//		em.persist(person);
//		
//		em.getTransaction().commit();
//		
//		em.close();
//		factory.close();
		
		
		/****** infos eines Persons updaten ******/
		
//		em.getTransaction().begin();
//		
//		Person person = em.find(Person.class, 1L);
//		
//		System.out.print(person.getVorname()+" ");
//		System.out.println(person.getNachname());
//		
//		em.getTransaction().commit();
//		
//		em.close();
//		
//		factory.close();
		
		
		/****** Geburtsdatum hinzufügen ******/
		
		PersonDAO personDAO = new PersonDAO();
		
		Person  p = new Person();
		
		p.setVorname("Max");
		p.setNachname("Mustermann");

		Calendar cal = Calendar.getInstance();
		cal.set(1975, Calendar.MARCH, 22);
		
		Date geburtsdatum = cal.getTime();
		
		p.setGeburtsdatum(geburtsdatum);
		
		p.setGeschlecht(Geschlecht.MEANNLICH);
		
		try {
			p.setPassbild(Files.readAllBytes(Paths.get("user.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		p.setKommentar("Mein lieber Max Mustermann");
		
		personDAO.persist(p);
		
		personDAO.shutdown();
		
	}

}
