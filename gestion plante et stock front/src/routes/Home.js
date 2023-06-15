import React from "react";
import Hero from "../components/Hero.js";
import Navbar from "../components/Navbar";
import Exploitationsagricoles from "../components/Exploitationsagricoles.js";
import Visites from "../components/visites.js";
import Footer from "../components/Footer.js";

function Home() {
  return (
    <>
       <Navbar />
       <Hero
        cName = "hero"
        Img =  "./image/pexels-pixabay-235925.jpg"
        title =  "farm intelligent "
        text = "'' With us, we improve production and reduce costs by using smart technologies. ''"
        buttonText = "farm plan"
        url="/"
        btnClass="show"
       />
     <Exploitationsagricoles/>
     <Visites/>
     <Footer/>

       </>


);
}

export default Home;
