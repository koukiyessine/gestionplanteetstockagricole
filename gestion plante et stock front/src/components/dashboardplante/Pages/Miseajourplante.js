import React , { useState } from "react";
import axios from "axios"; // import axios module
//import { Link } from 'react-router-dom';
import "./Ajouterplante.css";

function Miseajourplante() {
    const [nomplante, setnomplante] = useState("");
    const [typedesol, settypedesol] = useState("");
    const [etatdesante, setetatdesante] = useState("");
    const [vitamine, setvitamine] = useState("");
    const [nomChamp, setnomChamp] = useState("");
    const [ph, setph] = useState("");
    const [Idplante, setIdplante] = useState("");
    const [dateplante, setdateplante] = useState("");
    const [datereclote, setdatereclote] = useState("");

    const handleSubmit = async (event) => {
        event.preventDefault();
        if (
          !validatenomplante(nomplante) ||
          !validatetypedesol(typedesol) ||
          !validateetatdesante(etatdesante) ||
          !validatevitamine(vitamine)||!validatenomChamp(nomChamp)||!validateph(ph)
          ||!validateIdPlante(Idplante)
        ) {
            alert("Le formulaire contient des erreurs");
          return;
        }
        alert("Formulaire valide, envoi des données...");
        // Ajouter votre code pour envoyer les données du formulaire ici


        try {                                            
          const response = await axios.post(`/api/Updateplante/${Idplante}`, {
        
       
            // Add the rest of the form data to the request payload
            nomplante,
            datereclote,
            typedesol,
            etatdesante,
            dateplante,
            vitamine,
            nomChamp,
            ph,
          });
          console.log(response.data);
          // Redirect to a success page or show a success message
        } catch (error) {
          console.log(error.response.data);
          // Show an error message to the user
        }
      };


      const validatenomplante = (value) => {
        if (value === "" || /[0-9]/.test(value)) {
            alert(
            "Le champ Nomdeplante doit être non vide et ne doit pas contenir de chaine de caractere"
          );
          return false;
        }
        return true;
      };

      const validatetypedesol = (value) => {
        if (value === "" || /[0-9]/.test(value)) {
            alert(
            "Le champ Nomdeplante doit être non vide et ne doit pas contenir de chaine de caractere"
          );
          return false;
        }
        return true;
      };


      const validateetatdesante = (value) => {
        if (value === "" || /[0-9]/.test(value)) {
            alert(
            "Le champ Nomdeplante doit être non vide et ne doit pas contenir de chaine de caractere"
          );
          return false;
        }
        return true;
      };

      const validatevitamine = (value) => {
        if (value === "" || /[0-9]/.test(value)) {
            alert(
            "Le champ Nomdeplante doit être non vide et ne doit pas contenir de chaine de caractere"
          );
          return false;
        }
        return true;
      };

      const validatenomChamp = (value) => {
        if (value === "" || /[0-9]/.test(value)) {
          alert(
            "Le champ nomchamp doit être non vide et ne doit pas contenir de chaine de caractere"
          );
          return false;
        }
        return true;
      };
    
    
    
    
      const validateph = (value) => {
        if (value === "" || /[a-zA-Z]{1,}[a-zA-Z0-9]{0,1}$/.test(value)) {
          alert(
            "Le champ phchamp doit être non vide et ne doit pas contenir de chaîne de caractères."
          );
          return false;
        }
        return true;
      };

      const validateIdPlante = (value) => {
        if (value === "" || !/\d/.test(value)) {
          alert("Le champ Idplante doit être non vide et contenir au moins un chiffre.");
          return false;
        }
        return true;
      };

  return (
    <div className="registre">
    <form   onSubmit={handleSubmit}>

    <div className="textt">
        <h1>Update plante</h1>
    </div>

    <div className="form-group">
        <input type="text" className="form-control paper" id="Idplante" placeholder="id de plante"  
         value={Idplante}  onChange={(event) => setIdplante(event.target.value)}/>
    </div>

    <div className="form-group">
        <input type="text" className="form-control paper" id="nomplante" placeholder="Nom de plante"  
         value={nomplante}  onChange={(event) => setnomplante(event.target.value)}/>
    </div>

    <div className="form-group">
        <input type="text" className="form-control paper" id="typedesol" placeholder="type de sol"  
         value={typedesol}  onChange={(event) => settypedesol(event.target.value)}/>
    </div>

    <div className="form-group">
        <input type="Date" className="form-control paper" id="dateplante" placeholder="date de plante " 
         value={dateplante}  onChange={(event) => setdateplante(event.target.value)} required/>
    </div>

    <div className="form-group">
        <input type="Date" className="form-control paper" id="datereclote" placeholder="date de recette"
        value={datereclote}  onChange={(event) => setdatereclote(event.target.value)}  required/>
    </div>

    <div className="form-group">
        <input type="text" className="form-control paper" id="etatdesante" placeholder="etat de sante" 
         value={etatdesante}  onChange={(event) => setetatdesante(event.target.value)} />
    </div>

    <div className="form-group">
        <input type="text" className="form-control paper" id="vitamine" placeholder="vitamine"  
         value={vitamine}  onChange={(event) => setvitamine(event.target.value)} />
    </div>

    <div className="form-group">
        <input type="text" className="form-control paper" id="nomChamp" placeholder="nom_champ" 
        value={nomChamp}  onChange={(event) => setnomChamp(event.target.value)} />
    </div>

    <div className="form-group">
        <input type="text" className="form-control paper" id="ph" placeholder="ph_champ" 
        value={ph}  onChange={(event) => setph(event.target.value)} />
    </div>
    
    <div className="form-group">
    <button type="reset" className="btn btn-block createcompte">Annuler</button>
         <button type="submit" className="btn btn-block createcompte">Update</button>
        
       
         
    </div>
</form>
</div>

  );
}

export default Miseajourplante;
