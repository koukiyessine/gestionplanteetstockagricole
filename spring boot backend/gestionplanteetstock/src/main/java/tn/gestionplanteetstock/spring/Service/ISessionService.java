package tn.gestionplanteetstock.spring.Service;

import tn.gestionplanteetstock.spring.Entities.Session;

public interface ISessionService {

//public Session addSession (Session s);
public String addsessionbyexistance(Session s);
//public Session addSessionrole(Long Idsession , Long IdRole);
//public void addSessionAndPlante(String email, String password, String selectedOption);
public Session addSession(Session s);

public long getTotalRows();


//public void processSelectedOption(Session session);

}
