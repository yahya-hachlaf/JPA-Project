package model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Person
 *
 */
@Entity

public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;
	private String vorname;
	private String nachname;
	
	@Temporal(TemporalType.DATE)
	private Date geburtsdatum;
	
	@Enumerated(EnumType.STRING)
	private Geschlecht geschlecht;

	@Lob
	private byte[] passbild;
	
	@Column(name="HINWEIS")
	private String kommentar;
	
	private static final long serialVersionUID = 1L;

	public Person() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}   
	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public Date getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	public Geschlecht getGeschlecht() {
		return geschlecht;
	}
	public void setGeschlecht(Geschlecht geschlecht) {
		this.geschlecht = geschlecht;
	}
	public byte[] getPassbild() {
		return passbild;
	}
	public void setPassbild(byte[] passbild) {
		this.passbild = passbild;
	}
	public String getKommentar() {
		return kommentar;
	}
	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}
   
}
