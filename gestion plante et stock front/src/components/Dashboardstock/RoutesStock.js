import React from "react";
import DashboardStock from "./Pages/DashboardStock";
import RapportStock from "./Pages/RapportStock";
import CustomersStock from "./Pages/CustomersStock";
import AjouterStock from "./Pages/AjouterStock";
import SupprimerStock from "./Pages/SupprimerStock";
import MiseajourStock from "./Pages/MiseajourStock";
import { Routes, Route  } from 'react-router-dom';

function RoutesStock(){
  return(
    <Routes>
      <Route path="/" element={<DashboardStock/>} />
      <Route path="/RapportStock" element={<RapportStock />} />
      <Route path="/CustomersStock" element={<CustomersStock />} />
      <Route path="/AjouterStock" element={<AjouterStock />} />
      <Route path="/SupprimerStock" element={<SupprimerStock />} />
      <Route path="/MiseajourStock" element={<MiseajourStock />} />
    
    </Routes>  
  );
}

export default RoutesStock;
