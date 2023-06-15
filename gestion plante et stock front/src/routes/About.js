import React from "react";
import Hero from "../components/Hero.js";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer.js";
import AboutUs from "../components/AboutUs.js";

function About() {
  return ( 
    <>
       <Navbar />
       <Hero
        cName = "hero-mid"
        Img =  "./image/pexels-pixabay-415693.jpg"

        text = "About"
        buttonText = "farm plan"
        url="/"
        btnClass="hide"

       />
       <AboutUs/>
     <Footer/>
    </>


);
}

export default About;
