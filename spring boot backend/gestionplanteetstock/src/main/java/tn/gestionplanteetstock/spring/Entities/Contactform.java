package tn.gestionplanteetstock.spring.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contactform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idcontact;
    private String Name;
    private String Email;
    private String Subject;
    private String Message;
    
    
	public Long getIdcontact() {
		return idcontact;
	}
	public void setIdcontact(Long idcontact) {
		this.idcontact = idcontact;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
	
	@Override
	public String toString() {
		return "Contactform [idcontact=" + idcontact + ", Name=" + Name + ", Email=" + Email + ", Subject=" + Subject
				+ ", Message=" + Message + "]";
	}
	
	
	public Contactform(Long idcontact, String name, String email, String subject, String message) {
		super();
		this.idcontact = idcontact;
		Name = name;
		Email = email;
		Subject = subject;
		Message = message;
	}
	
	
	public Contactform() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    

}
