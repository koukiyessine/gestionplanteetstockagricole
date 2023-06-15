import React, { useState, useEffect } from "react";
import "./Rapportstock.css";
import axios from 'axios';

function Rapport() {
  const [descriptionStock, setdescriptionStock] = useState("");
  const [referenceproduit, setreferenceproduit] = useState("");
  const [quantitetotal, setquantitetotal] = useState("");
  const [quantitealerte, setquantitealerte] = useState("");
  const [numtelephonefournisseur, setnumtelephonefournisseur] = useState("");
  const [img, setimg] = useState("");
  const [nomproduit, setnomproduit] = useState("")

  const validatedescription = (value) => {
    if (value === "") {
      alert("Le champ Description doit être non vide");
      return false;
    }
    return true;
  };


  const validatenomproduit = (value) =>{  
    if (value === "" || /[0-9]/.test(value)) {
      alert(
        "Le champ nom de produit doit être non vide et ne doit pas contenir de chaine de caractere"
      );
      return false;
    }
    return true;
  };



  const handleSubmit = async (event) => {
    event.preventDefault();

    if (!validatedescription(descriptionStock) && !validatenomproduit(nomproduit)) {
      alert("Le formulaire contient des erreurs !! ");
     
    }

/*
    if (!validatenomproduit(nomproduit)) {
      alert("Le champ nom produit elle ni pas valider !! ");
     
    }*/

    try {
      const response = await axios.post('/api/addrapportstockbyexistance', {descriptionStock});
      console.log(response.data); // Succès
    } catch (error) {
      console.log(error.response.data); // Message d'erreur retourné par le serveur
      alert("Une erreur s'est produite lors de l'envoi du rapport");
    }
  };

  useEffect(() => {
    if (nomproduit) {
      fetchData();
    }
  }, [nomproduit]);

  async function fetchData() {
    try {
      const response = await fetch(`/api/getallProduitByname/${nomproduit}`);
      if (!response.ok) {
        throw new Error("Request failed with status code " + response.status);
      }
      const data = await response.json();

      // Mettez à jour l'état avec les données récupérées
      setreferenceproduit(data[0].referenceproduit);
      setquantitetotal(data[0].quantitetotal);
      setquantitealerte(data[0].quantitealerte);
      setnumtelephonefournisseur(data[0].numtelephonefournisseur);
      setimg(data[0].img);
    } catch (error) {
      console.error(error);
    }
  }

  return (
    <div className="registrationn-formm">
      <form onSubmit={handleSubmit}>
        <div className="formm-ttext">
          <h1>Rapport</h1>
        </div>
        <div className="form-group">
          <input type="text" className="form-control itemm" id="nomproduit" placeholder="Nom de produit" value={nomproduit} onChange={e => setnomproduit(e.target.value)}/>
        </div>
        <div className="form-group">
          <input type="text" className="form-control itemm" id="referenceproduit" placeholder="reference de produit" value={referenceproduit} readOnly />
        </div>
        <div className="form-group">
          <input type="text" className="form-control itemm" id="quantitetotal" placeholder="quantite total " value={quantitetotal} readOnly />
        </div>
        <div className="form-group">
          <input type="text" className="form-control itemm" id="quantitealerte" placeholder="quantite d'alerte" value={quantitealerte} readOnly />
        </div>
        <div className="form-group">
          <input type="text" className="form-control itemm" id="numtelephonefournisseur" placeholder="num telephone fournisseur" value={numtelephonefournisseur} readOnly />
        </div>
        <div className="form-group">
          <input type="text" className="form-control itemm" id="img" placeholder="img" value={img} readOnly />
        </div>
        <div className="form-group">
          <textarea
            id="description"
            className="form-control itemm"
            placeholder="description "
            style={{ height: "135px" }}
            
            value={descriptionStock}
            onChange={e => setdescriptionStock(e.target.value)}
          />
        </div>
        <div className="form-group">
          <button type="reset" className="btn btn-block createaccountt">Annuler</button>
          <button type="submit" className="btn btn-block createaccountt">envoyer</button>
        </div>
      </form>
    </div>
  );
}

export default Rapport;
