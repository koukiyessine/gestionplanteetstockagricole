import React, { useState } from "react";
import "./AjouterStock.css";
import axios from "axios";

function Supprimerplante() {
  const [Idproduit, setIdproduit] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (!validateIdproduit(Idproduit)) {
      alert("Le formulaire contient des erreurs");
      return;
    }

    alert("Formulaire valide, envoi des données...");
    try {
      const response = await axios.delete(`/api/deleteProduit/${Idproduit}`);
      console.log(response.data);
      // Redirect to a success page or show a success message
    } catch (error) {
      console.log(error.response.data);
      // Show an error message to the user
    }
  };

  const validateIdproduit = (value) => {
    if (value === "" || !/\d/.test(value)) {
      alert("Le champ idproduit doit être non vide et contenir au moins un chiffre.");
      return false;
    }
    return true;
  };
  return (
    <div className="registration">
      <form onSubmit={handleSubmit}>
        <div className="form-text">
          <h1>Supprimer Stock</h1>
        </div>

        <div className="form-group">
          <input
            type="text"
            className="form-control item"
            id="idproduit"
            placeholder="id de produit"
            value={Idproduit}
            onChange={(e) => setIdproduit(e.target.value)}
          />
          
        </div>

       
   

        <div className="form-group">

        <button type="reset" className="btn btn-block create-account">
            Annuler
          </button>
          
          <button type="submit" className="btn btn-block create-account">
            Delete
          </button>

        </div>
      </form>
    </div>
  );
}

export default Supprimerplante;
