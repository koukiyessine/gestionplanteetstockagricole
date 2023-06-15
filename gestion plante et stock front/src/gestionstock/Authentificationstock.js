import React, { useState } from 'react';
import './Authentificationstock.css';
import axios from 'axios';

function Authentification() {
  const [selectedOption, setSelectedOption] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleOptionChange = (event) => {
    setSelectedOption(event.target.value);
  };

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleLogin = async (event) => {
    event.preventDefault();

    const validateEmail = (email) => {
      const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      return regex.test(email);
    };

    const validatePassword = (password) => {
      const regex = /^(?=.*\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{8,}$/;
      return regex.test(password);
    };

    if (!validateEmail(email)) {
      alert('Veuillez saisir une adresse e-mail valide.');
      return;
    }

    if (!validatePassword(password)) {
      alert(
        'Veuillez saisir un mot de passe valide (8 caractères minimum, avec des lettres et des chiffres).'
      );
      return;
    }

    let link;
    if (selectedOption === 'Agriculteur') {
      link = '/Rapportstock';
    } else if (selectedOption === 'responsable') {
      link = '/DashboardStockapp/*';
    }

    try {
      const response = await axios.post('/api/addsessionbyexistance', {
        email,
        password,
        selectedOption,
      });

      console.log(response.data); // Success
      window.location.href = link;
    } catch (error) {
      console.log(error.response.data); // Error message returned by the server
    }
  };

  return (
    <div className="container">
      <div className="gauchee">
        <div className="entêtee">
          <h2 className="animation a1">Welcome Back</h2>
          <h4 className="animation a2">
            Log in to your account using email and password and id
          </h4>
        </div>
        <form className="formulairee" onSubmit={handleLogin}>
          <input
            type="email"
            className="form-field animation a3"
            placeholder="EmailAddress"
            value={email}
            onChange={handleEmailChange}
          />
          <input
            type="password"
            className="form-field animation a4"
            placeholder="Password"
            value={password}
            onChange={handlePasswordChange}
          />
          <select
            id="id"
            className="form-field animation a5"
            value={selectedOption}
            onChange={handleOptionChange}
            required
          >
            <option value="">Choose an option</option>
            <option value="responsable">Responsable</option>
            <option value="Agriculteur">Agriculteur</option>
          </select>
          <p className="animation a5">
            <a href="/forgotpassword">Forgot Password</a>
          </p>
          <button type="submit" className="animation a6">
            LOGIN
          </button>
        </form>
      </div>
      <div className="droitee"></div>
    </div>
  );
}

export default Authentification;
