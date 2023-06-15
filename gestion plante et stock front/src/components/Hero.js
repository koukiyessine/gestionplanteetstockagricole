import React from "react";
import "./Hero.css";
function Hero(props) {
  return (
    <div className={props.cName}>
       <img src={props.Img} alt="farm intelligent" />
    
    <div className="hero-text">
        <h1>{props.title}</h1>
        <p>{props.text}</p>
        <a href={props.url} className={props.btnClass}>
             {props.buttonText}
        </a>
    </div>
    
    
    
    </div>


);
}

export default Hero;
