import React from "react";
import "./visites.css";
import Visitesdata from "./visitesdata";

function visites(){
  return(
  <div className="visites">
   <h1>recent visits</h1>
     <p>" From today you can collect valuable crop 
        or animal health data and detect diseases
         with less effort and more accuracy "
 </p>
 <div className="visitescard">
     
<Visitesdata

image ="./image/pexels-quang-nguyen-vinh-2157925.jpg"
heading ="  les drones "
text ="Les drones peuvent être utilisés pour survoler
 les champs et capturer des images haute résolution 
 des cultures, ce qui permet aux agriculteurs de 
 surveiller leur croissance, leur développement et 
 leur état de santé"
/>

<Visitesdata

image ="./image/images.jfif"
heading =" les capteurs  "
text ="Les capteurs peuvent être utilisés
 pour surveiller les niveaux d'humidité, 
 de température et de nutriments dans le sol 
 ou dans les cultures, 
 et les caméras peuvent être utilisées pour 
 surveiller l'état des animaux."
/>

<Visitesdata

image ="./image/downloa.jfif"
heading ="  Les caméras "
text ="les caméras dans l'agriculture peut 
aider les agriculteurs à surveiller 
les cultures et les animaux, détecter 
les problèmes de santé et de bien-être, 
évaluer la qualité des cultures et améliorer 
la productivité globale de la ferme."
/>

 </div>
  </div>
);
}

export default visites;