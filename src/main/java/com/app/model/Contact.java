package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact implements Serializable{
	
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @Column(name = "firstname")
    private String firstName;
    
    @Column(name = "lastname")
    private String lastName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phoneNumber")
    private long phoneNumber;

    protected Contact() {}

    public Contact(String firstName, String lastName, String email, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    public long getId(){
        return this.id;
    }
    
        public String getFirstName(){
        return this.firstName;
    }
    
        public String getLastName(){
        return this.lastName;
    }
    
        public String getEmail(){
        return this.email;
    }
    
        public long getPhoneNumber(){
        return this.phoneNumber;
    }
    


    @Override
    public String toString() {
        return String.format(
                "Contact[id=%d, firstName='%s', lastName='%s', email='%s', phoneNumber='%d']",
                id, firstName, lastName, email, phoneNumber);
    }
}