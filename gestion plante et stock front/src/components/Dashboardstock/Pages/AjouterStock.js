import React, { useState } from "react";
import "./AjouterStock.css";
import axios from "axios"; // import axios module

function Ajouterplante() {
  const [nomproduit, setnomproduit] = useState("");
  const [quantitetotal, setquantitetotal] = useState("");
  const [quantitealerte, setquantitealerte] = useState("");
  const [referenceproduit, setreferenceproduit] = useState("");
  const [numtelephonefournisseur, setnumtelephonefournisseur] = useState("");
  const [img, setimg] = useState("");
 


  const handleSubmit = async (event) => {
    event.preventDefault();
    if (
      !validatenomproduit(nomproduit) ||
      !validatequantitetotal(quantitetotal) ||
      !validatequantitealerte(quantitealerte) ||
      !validatenumtelephonefournisseur(numtelephonefournisseur)
    ) {
        alert("Le formulaire contient des erreurs");
      return;
    }
    alert("Formulaire valide, envoi des données...");
    // Ajouter votre code pour envoyer les données du formulaire ici

    try {
      const response = await axios.post(`/api/addProduitbyexistance`, {
        
       
        // Add the rest of the form data to the request payload
        
         nomproduit,
        referenceproduit,
        quantitetotal,
        quantitealerte,
        numtelephonefournisseur,
        img
      });

      console.log(response.data); // Success
      // Redirect to a success page or show a success message
    } catch (error) {
      console.log(error.response.data); // Error message returned by the server
      // Show an error message to the user
    }
  };

  const validatenomproduit = (value) => {
    if (value === "" || /[0-9]/.test(value)) {
        alert(
        "Le champ Nomdeproduit doit être non vide et ne doit pas contenir de chiffres"
      );
      return false;
    }
    return true;
  };

  const validatequantitetotal = (value) => {
    if (value === "" || /[a-zA-Z]/.test(value)) {
      alert(
        "Le champ quantitedeproduittotal doit être non vide et ne doit pas contenir de lettres"
      );
      return false;
    }
    return true;
  };

  const validatequantitealerte = (value) => {
    if (value === "" || /[a-zA-Z]/.test(value)) {
        alert(
        "Le champ quantitedealerte doit être non vide et ne doit pas contenir de lettres"
      );
      return false;
    }
    return true;
  };

  const validatenumtelephonefournisseur = (value) => {
    if (value === "" || !/^\d{1,8}$/.test(value)) {
        alert(
        "Le champ telfournisseur doit contenir entre 1 et 8 chiffres"
      );
      return false;
    }
    return true;
  };

  return (
    <div className="registration">
      <form onSubmit={handleSubmit}>
        <div className="form-text">
          <h1>Ajouter Stock</h1>
        </div>

        <div className="form-group">
          <input
            type="text"
            className="form-control item"
            id="nomproduit"
            placeholder="Nom de produit"
            value={nomproduit}
            onChange={(event) => setnomproduit(event.target.value)}
          />
        </div>

        <div className="form-group">
          <input type="file" className="form-control item" id="img" required
          value={img}
          onChange={(event) => setimg(event.target.value)} />
        </div>

        <div className="form-group">
          <input
            type="text"
            className="form-control item"
            id="referenceproduit"
            placeholder="reference de produit "
            value={referenceproduit}
            onChange={(event) => setreferenceproduit(event.target.value)}
          />
        </div>

        <div className="form-group">
          <input
            type="text"
            className="form-control item"
            id="quantitedeproduittotal"
            placeholder="quantite  de produit total"
            value={quantitetotal}
            onChange={(event) => setquantitetotal(event.target.value)}
          />
        </div>

        <div className="form-group">
          <input

type="text"
className="form-control item"
id="quantitedealerte"
placeholder="quantite de alerte"
value={quantitealerte}
onChange={(event) => setquantitealerte(event.target.value)}
/>
</div>


    <div className="form-group">
      <input
        type="text"
        className="form-control item"
        id="telfournisseur"
        placeholder="numtelephonefournisseur"
        value={numtelephonefournisseur}
        onChange={(event) => setnumtelephonefournisseur(event.target.value)}
      />
    </div>

    <div className="form-group">
    <button type="reset" className="btn btn-block create-account">Annuler</button>
    <button type="submit" className="btn btn-block create-account">Ajouter</button>

    </div>
  </form>
</div>
);
}

export default Ajouterplante;