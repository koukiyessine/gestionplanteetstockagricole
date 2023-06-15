import React from "react";
import Dashboard from "./Pages/Dashboard";
import Rapport from "./Pages/Rapport";
import Orders from "./Pages/Orders";
import Customers from "./Pages/Customers";
import Ajouterplante from "./Pages/Ajouterplante";
import Supprimerplante from "./Pages/Supprimerplante";
import Miseajourplante from "./Pages/Miseajourplante";
import { Routes, Route } from 'react-router-dom';


function routes(){
  return(
    <Routes>
      <Route path="/"  exact element={<Dashboard />} />
      <Route path="/Rapport" element={<Rapport />} />
      <Route path="/Orders" element={<Orders />} />
      <Route path="/Customers" element={<Customers />} />
      <Route path="/Ajouterplante" element={<Ajouterplante />} />
      <Route path="/Supprimerplante" element={<Supprimerplante />} />
      <Route path="/Miseajourplante" element={<Miseajourplante />} />
      

    </Routes>  
  );
}

export default routes;
