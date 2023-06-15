package tn.gestionplanteetstock.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.gestionplanteetstock.spring.Entities.Session;
import tn.gestionplanteetstock.spring.Service.SessionService;

@RestController
@RequestMapping("/api")
public class SessionController {

    @Autowired
    SessionService sessionService;
/*
    @PostMapping("/addSessionAndPlante")
    public void addSessionAndPlante(@RequestBody String email , String password,  String  selectedOption) {
     
         sessionService.addSessionAndPlante(email, password, selectedOption);
        
        
    }*/
/*
@PostMapping("/processSelectedOption")
public void processSelectedOption(@RequestBody Session session) {
      sessionService.processSelectedOption(session);
}*/

    
    @PostMapping("/addSession")
    public Session addSession(Session s) {
       return sessionService.addSession(s);
    }
    
    
    @GetMapping("/getTotalRows")
    public long getTotalRows() {
        return sessionService.getTotalRows();
 
    }


    @PostMapping("/addsessionbyexistance")
    public String addsessionbyexistance(@RequestBody Session s){
        return sessionService.addsessionbyexistance(s);
    }
}
