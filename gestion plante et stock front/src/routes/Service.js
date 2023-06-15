import React from "react";
import Hero from "../components/Hero";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer.js";


function Service() {
return (
  < div>
        <Navbar />
    <Hero
     cName = "hero-mid"
     Img =  "./image/Trimble_Precision_Agriculture-1024x444.jpg"
     text = "Service"
     url="/"
     btnClass="hide"

    />
    <Footer/>
    
  </div>


);
}

export default Service;