import React from "react";
import "./Footer.css";

function Footer(){

 return(
   <div className="Foot">
      <div className="tp">
        <div>
            <h1>Farmer</h1>
            <p>"Farmers are the backbone of our society"</p>
        </div>
        <div>
            <a href="https://www.facebook.com/yessin.kouki">
                <i className="fa-brands fa-facebook-square"></i>
            </a>
            <a href="https://www.instagram.com/yessinkouki">
                <i className="fa-brands fa-instagram-square"></i>
            </a>
            <a href="https://github.com/koukiyessine">
                <i className="fa-brands fa-github-square"></i>
            </a>
            <a href="https://twitter.com/">
                <i className="fa-brands fa-twitter-square"></i>
            </a>
        </div>
      </div>
      <div className="bottm">
         <div>
            <h4>Project</h4>
            <a href="/">changelog</a>
            <a href="/">Status</a>
            <a href="/">License</a>
            <a href="/About">solution proposes</a>
         </div>

         <div>
            <h4>service</h4>
            <a href="/Authentificationplante">gestion de plante</a>
            <a href="/Authentificationstock">gestion de stock</a>
         </div>

        <div>
         <h4>Help</h4>
            <a href="https://support.bushelfarm.com/hc/en-us">Support</a>
            <a href="https://blog.bushelfarm.com/">blog</a>
            <a href="/Contact">Contact us</a>
         </div>

          <div>
            <h4>Others</h4>
            <a href="/">terms of service</a>
            <a href="/">Privacy policy</a>
            <a href="/">License</a>
          </div>
      </div>

    
   </div>
  );
}
export default Footer;