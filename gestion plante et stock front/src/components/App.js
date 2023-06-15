import React from "react";
import "./Style.css"


import {Route, Routes} from "react-router-dom";
import Home from "../routes/Home";
import About from "../routes/About";
import Service from "../routes/Service";
import Contact from "../routes/Contact";
//import Signup from "../routes/Signup";
import Authentificationstock from "../gestionstock/Authentificationstock";
import Authentificationplante from "../gestionplante/Authentificationplante";
import Rapportplante from "../gestionplante/Rapportplante";
import Rapportstock from "../gestionstock/Rapportstock";
import DashboardStockapp from "./Dashboardstock/DashboardStockapp";
import Dashboardapp from "./dashboardplante/Dashboardapp";
/*
import Rapport from "./dashboardplante/Pages/Rapport";
import Orders from "./dashboardplante/Pages/Orders";
import Customers from "./dashboardplante/Pages/Customers";
import Ajouterplante from "./dashboardplante/Pages/Ajouterplante";
import Supprimerplante from "./dashboardplante/Pages/Supprimerplante";
import Miseajourplante from "./dashboardplante/Pages/Miseajourplante";

         <Route path="/Rapport"           element={<Rapport />} />
         <Route path="/Orders"            element={<Orders />} />
         <Route path="/Customers"         element={<Customers />} />
         <Route path="/Ajouterplante"     element={<Ajouterplante />} />
         <Route path="/Supprimerplante"   element={<Supprimerplante />} />
         <Route path="/Miseajourplante"   element={<Miseajourplante />} />
*/


function Test() {

  return (
   
    <div className="App">
       <Routes>
         <Route path="/"                          element={<Home/>}/>
         <Route path="/About"                     element={<About/>}/>
         <Route path="/Service"                   element={<Service/>}/>
         <Route path="/Contact"                   element={<Contact/>}/> 
         <Route path="/Authentificationstock"     element={<Authentificationstock/>}/> 
         <Route path="/Authentificationplante"    element={<Authentificationplante/>}/> 
         <Route path="/Rapportplante"             element={<Rapportplante/>}/> 
         <Route path="/Rapportstock"              element={<Rapportstock/>}/> 
         <Route path="/sign-up"                   element={<Contact/>}/> 
         <Route path="/DashboardStockapp/*"         element={<DashboardStockapp/>}/>
         <Route path="/Dashboardapp/*"              element={<Dashboardapp/>}/>


         
         </Routes>
  </div>
  );
}

export default Test;
