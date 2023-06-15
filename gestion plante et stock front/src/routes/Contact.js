import React from "react";
import Hero from "../components/Hero";
import Navbar from "../components/Navbar";
import Contactform from "../components/Contactform.js";
import Footer from "../components/Footer.js";


function Contact() {
return (
  <div>
        <Navbar/>
    <Hero
      cName = "hero-mid"
      Img =  "./image/pexels-andrea-piacquadio-789822.jpg"
      text = "Contact"
      url="/"
      btnClass="hide"
    />
    <Contactform/>
  <Footer/>
  </div>
  );
}
export default Contact;
