package com.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.Contact;
import com.app.repo.ContactRepo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.ArrayList;
// import java.lang.Long;

@Controller  
public class MainController {

    public static String htmlText = "";
    private static ArrayList<Contact> selected  = new ArrayList<Contact>();


    @Value("${application.message:Hello World}") // ?
    private String message = "Hello World"; 

    @GetMapping("/")
    public String welcome(Map<String, Object> model) { 
        return "form";

    }

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request){
        return "hello";
    }

    @RequestMapping("/form")
    public String form(HttpServletRequest request){
        return "form";
    }

    @Autowired
    ContactRepo repo;

    @RequestMapping("/saveExample")
    public String process(){
        repo.save(new Contact("Adam", "Johnson", "adamj@gmail.com", 66634433));
        repo.save(new Contact("Adam", "Smith", "a12ms@gmail.com", 23355466));
        repo.save(new Contact("Michael", "Johnson", "xxx@xyz.cz", 54665345));
        this.htmlText = "Done.";
        return "print";
    }

    @RequestMapping("/saveContact")
    public String saveContact(HttpServletRequest request){
        
      selected = new ArrayList<Contact>(); 

        if (request.getParameter("opt").equals("Insert contact")){
            
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String phoneNumberString = request.getParameter("phoneNumber");
            long phoneNumber;
            
            if (phoneNumberString.length() < 1){ phoneNumber = -1;
            }
            else { phoneNumber = Long.parseLong(phoneNumberString);}
            
            repo.save(new Contact(firstName, lastName, email, phoneNumber));
            return "form";
        }


        if (request.getParameter("opt").equals("Select contact")){

            String result = "<html>";

            for(Contact c : repo.findAll()){
                if(
                           ( 
                                c.getFirstName().equals(request.getParameter("firstName")) ||
                                request.getParameter("firstName").equals("")    
                           ) 
                        && (
                                c.getLastName().equals(request.getParameter("lastName")) ||
                                request.getParameter("lastName").equals("")  
                           ) 
                        && (
                                c.getEmail().equals(request.getParameter("email")) ||
                                request.getParameter("email").equals("")  
                           ) 
                        && (
                                Long.toString(c.getPhoneNumber()).equals(request.getParameter("phoneNumber")) ||
                                request.getParameter("phoneNumber").equals("") 
                           )
                        )
                {
                    result += "<div>" + c.toString() + "</div>";
                    selected.add(c);
                }  
            }
            this.htmlText = result + "" //"<p><a href=\"localhost:8080/del\">xxxxx</a></p>"
                    + "<br/><form method=\"get\" action=\"/del\">"
                    + "<button type=\"submit\" style=\"background-color:red\"> Delete selected contacts </button></form><br/>"
                    + "<br/><form method=\"get\" action=\"/form\">"
                    + "<button type=\"submit\" style=\"background-color:yellow\"> Back </button></form></html>";
            return "print";
        }
        return "form";
    }
    
    @RequestMapping("/del")
    public String del(){

        for(Contact c : selected){
            repo.delete(c.getId());
        }
        
        selected = null; 
        selected = new ArrayList<Contact>(); 

        return "form";
    }


    @RequestMapping("/all")
    public String findAll(){
        String result = "<html>";

        for(Contact c : repo.findAll()){
            result += "<div>" + c.toString() + "</div>";
        }

        this.htmlText = result + "<br/><form method=\"get\" action=\"/form\">"
                + "<button type=\"submit\" style=\"background-color:yellow\">"
                + "Back </button></form></html>";
        return "print";
    }

    @RequestMapping("/deleteAll")
    public String deleteAll(){
              
        for(Contact c : repo.findAll()){
            repo.delete(c.getId());
        }
        return "form";
    }
    
    @RequestMapping("/warn")
    public String warn(HttpServletRequest request){
        return "warn";
    }
}
