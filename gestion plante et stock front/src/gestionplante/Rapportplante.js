import React, { useState ,useEffect } from "react";
import axios from 'axios';
import "./Rapportplante.css";

function Rapport() {
  const [nomplante, setnomplante] = useState("");
  const [typedesol, settypedesol] = useState("");
  const [etatdesante, setetatdesante] = useState("");
  const [dateplante, setdateplante] = useState("");
  const [datereclote, setdatereclote] = useState("");
  const [nomChamp, setnomChamp] = useState("");
  const [description, setdescription] = useState("");
  const [vitamine, setvitamine] = useState("");
  const [ph, setph] = useState("");
  

  const validatenomplante = (value) =>{  
    if (value === "" || /[0-9]/.test(value)) {
      alert(
        "Le champ Nomdeplante doit être non vide et ne doit pas contenir de chaine de caractere"
      );
      return false;
    }
    return true;
  };


  const validatedescription = (value) => {
    if (value === "") {
      alert("Le champ Description doit être non vide");
      return false;
    }
    return true;
  };

  async function handleSubmit(event) {
    event.preventDefault();

    if (!validatenomplante(nomplante) || !validatedescription(description)) {
      alert("Le formulaire contient des erreurs !! ");
     
    }

    
    

    try {
      const response = await axios.post('/api/addrapportbyexistance', {
          description
      }
      
      );
      console.log(response.data); // Success
      
    } catch (error) {
      console.log(error.response.data); // Error message returned by the server
    }


    

  }

  useEffect(() => {
    fetchData();
  }, [nomplante]);
//console.log()
 // console.log(`/api/getallPlanteByname/${nomplante}`);
  async function fetchData() {
    try {
      const response = await axios.get(`/api/getallPlanteByname/${nomplante}`);
      const data = response.data;
      // console.log(data[0].nomChamp);
     settypedesol(data[0].typedesol);
      setetatdesante(data[0].etatdesante);
      setdateplante(data[0].dateplante.substring(0, 10));   
      setdatereclote(data[0].datereclote.substring(0, 10));
      setnomChamp(data[0].nomChamp);
      setvitamine(data[0].vitamine);
      setph(data[0].ph);
      // Set other state variables with the respective data
    } catch (error) {
      console.error(error);
    }
  }
  
  
 

  
    
  
  


return (
    <div className="rregistrationn">
      <form onSubmit={handleSubmit}>
        <div className="formmtext">
          <h1>Rapport</h1>
        </div>
        <div className="form-group">
          <input type="text" className="form-control Itemm" id="nomplante" placeholder="Nom de plante" value={nomplante} onChange={e => setnomplante(e.target.value)} />
        </div>
        <div className="form-group">
          <input type="text" className="form-control Itemm" id="etatdesante" placeholder="etat de sante" value={etatdesante} readOnly  />
        </div>
        <div className="form-group">
          <input type="text" className="form-control Itemm" id="typedesol" placeholder="type de sol " value={typedesol} readOnly />
        </div>


<div className="form-group">
<input type="date" className="form-control Itemm" id="dateplante" value={dateplante} readOnly  />
</div>

<div className="form-group">
<input type="date" className="form-control Itemm" id="datereclote" value={datereclote}  readOnly />
</div>

    <div className="form-group">
      <input type="text" className="form-control Itemm" id="nomChamp" placeholder="nom de Champ" value={nomChamp} readOnly />
    </div>

    <div className="form-group">
      <input type="text" className="form-control Itemm" id="ph" placeholder="ph" value={ph}  readOnly />
    </div>

    <div className="form-group">
      <input type="text" className="form-control Itemm" id="vitamine" placeholder="vitamine" value={vitamine } readOnly />
    </div>

    <div className="form-group">
      <textarea
        id="description"
        className="form-control Itemm"
        placeholder="description "
        style={{ height: "135px" }}
        value={description}
        onChange={e => setdescription(e.target.value)}
        
      />
    </div>

    <div className="form-group">
      <button type="reset" className="btn btn-block createe-buttonn">Annuler</button>
      <button type="submit" className="btn btn-block createe-buttonn">envoyer</button>

    </div>
  </form>
</div>
);
};

export default Rapport;