import React, { useState } from "react";
import axios from "axios"; 
import "./Contactform.css";


function Contactform(){

  const [Name, setName] = useState('');
  const [Email, setEmail] = useState('');
  const [Subject, setSubject] = useState('');
  const [Message, setMessage] = useState('');


  const handleSubmit = async (event) => {
    event.preventDefault();
 
    try {
      const response = await axios.post(`/api/addContactform`, {
        // Reste des données du formulaire
        Name,
        Email,
        Subject,
        Message
      });

      console.log(response.data); // Success
      // Redirect to a success page or show a success message
    } catch (error) {
      console.log(error.response.data); // Error message returned by the server
      // Show an error message to the user
    }

    
  }
  

  return(
<div className="from-container">
  <h1>Send a message to us !</h1>
   <form  onSubmit={handleSubmit}>

     <input placeholder="Name"  required   value={Name}  onChange={(event) => setName(event.target.value)}/>
     <input placeholder="Email"required   value={Email}  onChange={(event) => setEmail(event.target.value)}/>
     <input placeholder="Subject" required  value={Subject}  onChange={(event) => setSubject(event.target.value)}/>
     <textarea placeholder="Message" rows="4" required  value={Message}  onChange={(event) => setMessage(event.target.value)}></textarea>
     <button>Send Message</button>

   </form>
</div>
);
}


export default Contactform;