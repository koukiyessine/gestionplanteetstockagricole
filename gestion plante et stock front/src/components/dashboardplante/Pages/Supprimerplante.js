import React, { useState } from "react";
import axios from "axios";
import "./Ajouterplante.css";

function Supprimerplante() {
  const [idPlante, setIdPlante] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (!validateIdPlante(idPlante)) {
      alert("Le formulaire contient des erreurs");
      return;
    }

    alert("Formulaire valide, envoi des données...");
    try {
      const response = await axios.delete(`/api/deletePlante/${idPlante}`);
      console.log(response.data);
      // Redirect to a success page or show a success message
    } catch (error) {
      console.log(error.response.data);
      // Show an error message to the user
    }
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
      <form onSubmit={handleSubmit}>
        <div className="textt">
          <h1>Supprimer plante</h1>
        </div>
        <div className="form-group">
          <input
            type="text"
            className="form-control paper"
            id="Idplante"
            placeholder="id de plante"
            value={idPlante}
            onChange={(event) => setIdPlante(event.target.value)}
          />
        </div>
        <div className="form-group">
          <button type="reset" className="btn btn-block createcompte">
            Annuler
          </button>
          <button type="submit" className="btn btn-block createcompte">
            Delete
          </button>
        </div>
      </form>
    </div>
  );
}

export default Supprimerplante;
