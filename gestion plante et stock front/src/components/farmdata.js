import React from "react";
import "./Exploitationsagricoles.css";


function Farmdata(props) {
    return (
      <div className={props.className}>
        <div className="des-text">
          <h1>{props.header}</h1>
          <p>{props.text}</p>
        </div>
        <div className="image">
          <img src={props.img1} alt="img1" />
          <img src={props.img2} alt="img2" />
        </div>
      </div>
    );
  }
  

  
export default Farmdata;
