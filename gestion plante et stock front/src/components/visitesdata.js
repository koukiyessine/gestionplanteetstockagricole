import React from "react";
import "./visites.css";

function visitesdata(props){
return(
 <div className="t-card">
    <div className="t-image">
        <img src={props.image} alt="img" /> 
    </div>
    <h4>{props.heading}</h4>
    <p>{props.text}</p>
 </div>
);
}

export default visitesdata;