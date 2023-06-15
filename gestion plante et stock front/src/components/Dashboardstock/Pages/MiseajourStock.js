import React, { useState } from "react";
import "./AjouterStock.css";
import axios from "axios"; // import axios module


function MiseajourStock() {

  const [nomproduit, setnomproduit] = useState("");
  const [quantitetotal, setquantitetotal] = useState("");
  const [quantitealerte, setquantitealerte] = useState("");
  const [img, setimg] = useState("");
  const [numtelephonefournisseur, setnumtelephonefournisseur] = useState("");
  const [Idproduit, setIdproduit] = useState("");
  const [referenceproduit, setreferenceproduit] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (
      !validatenomproduit(nomproduit) ||
      !validatequantitetotal(quantitetotal) ||
      !validatequantitealerte(quantitealerte) ||
      !validatenumtelephonefournisseur(numtelephonefournisseur) ||  !validateIdproduit(Idproduit)
      ||!validatereferenceproduit(referenceproduit)

    ) {
        alert("Le formulaire contient des erreurs");
      return;
    }
    alert("Formulaire valide, envoi des données...");
    // Ajouter votre code pour envoyer les données du formulaire ici


    try {                                            
      const response = await axios.post(`/api/updateProduit/${Idproduit}`, {
    
   
        // Add the rest of the form data to the request payload

 nomproduit,
 referenceproduit,
 quantitetotal,
 quantitealerte,
 numtelephonefournisseur,
 img
      });
      console.log(response.data);
      // Redirect to a success page or show a success message
    } catch (error) {
      console.log(error.response.data);
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

  const validateIdproduit = (value) => {
    if (value === "" || !/\d/.test(value)) {
      alert("Le champ Idplante doit être non vide et contenir au moins un chiffre.");
      return false;
    }
    return true;
  };


  const validatereferenceproduit = (value) => {
    if (value === "" || /[a-zA-Z]/.test(value)) {
      alert(
        "Le champ reference de produit doit être non vide et ne doit pas contenir de lettres"
      );
      return false;
    }
    return true;
  };
  

  const validatequantitetotal = (value) => {
    if (value === "" || /[a-zA-Z]/.test(value)) {
      alert(
        "Le champ quantite de produit total doit être non vide et ne doit pas contenir de lettres"
      );
      return false;
    }
    return true;
  };

  const validatequantitealerte = (value) => {
    if (value === "" || /[a-zA-Z]/.test(value)) {
        alert(
        "Le champ quantite de alerte doit être non vide et ne doit pas contenir de lettres"
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
          <h1>Update Stock</h1>
        </div>

        <div className="form-group">
          <input
            type="text"
            className="form-control item"
            id="idproduit"
            placeholder="id de produit"
            value={Idproduit}
            onChange={(event) => setIdproduit(event.target.value)}
          />
        </div>

        <div className="form-group">
          <input
            type="text"
            className="form-control item"
            id="Nomdeproduit"
            placeholder="Nom de produit"
            value={nomproduit}
            onChange={(event) => setnomproduit(event.target.value)}
          />
        </div>

        <div className="form-group">
          <input type="file" className="form-control item" id="img"
          value={img}
          onChange={(event) => setimg(event.target.value)}  required/>
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
            id="quantitetotal"
            placeholder="quantite  de produit total"
            value={quantitetotal}
            onChange={(event) => setquantitetotal(event.target.value)}
          />
        </div>

        <div className="form-group">
          <input

type="text"
className="form-control item"
id="quantitealerte"
placeholder="quantite de alerte"
value={quantitealerte}
onChange={(event) => setquantitealerte(event.target.value)}
/>
</div>


    <div className="form-group">
      <input
        type="text"
        className="form-control item"
        id="numtelephonefournisseur"
        placeholder="numtelephone de fournisseur"
        value={numtelephonefournisseur}
        onChange={(event) => setnumtelephonefournisseur(event.target.value)}
      />
    </div>

    <div className="form-group">
    <button type="reset" className="btn btn-block create-account">Annuler</button>
    <button type="submit" className="btn btn-block create-account">Update</button>
    
    </div>
  </form>
</div>
);
}

export default MiseajourStock;