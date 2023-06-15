import React, { useState, useEffect } from 'react';
import { Card, Typography, Table, Avatar } from 'antd';
import axios from "axios";
import { CloudOutlined, BulbOutlined, AlertOutlined, EnvironmentOutlined, UserOutlined, SafetyOutlined } from '@ant-design/icons';
import "./Dashboard.css";

const { Meta } = Card;

const PlantTemperatureCard = () => {
  const [temperature, setTemperature] = useState(0);

  useEffect(() => {
    axios.get('/api/getalltemperature')
      .then(response => {
        const temperatureData = response.data;
        const latestTemperature = temperatureData[temperatureData.length - 1].value;
        setTemperature(latestTemperature);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  return (
    <Card style={{ width: 360 , height : 116  }}>
      <Meta
        avatar={<BulbOutlined style={{
          color: "red",
          backgroundColor: "rgba(0,255,0,0,25)",
          borderRadius: 20,
          fontSize: 24,
          padding: 8,
        }} />}
        title="Température de la plante"
        description={`${temperature}°C`}
      />
    </Card>
  );
};

const PlantHumidityCard = () => {
  const [soilMoisture, setsoilMoisture] = useState(0);

  useEffect(() => {
    axios.get('/api/getAllHumidity')
      .then(response => {
        const soilMoistureData = response.data;
        if (soilMoistureData.length > 0) {
          const latestData = soilMoistureData[soilMoistureData.length - 1];
          const latestsoilMoisture = latestData.soilMoisture;
          setsoilMoisture(latestsoilMoisture);
        }
      })
      .catch(error => {
        console.log(error);
      });
  }, []);
  

  return (
    <Card style={{width: 360 , height : 116  }}>
      <Meta
        avatar={<EnvironmentOutlined style={{
          color: "SteelBlue",
          backgroundColor: "rgba(0,255,0,0,25)",
          borderRadius: 20,
          fontSize: 24,
          padding: 8,
        }} />}
        title="Humidité de la plante"
        description={`${soilMoisture}%`}
      />
    </Card>
  );
};


const WeatherCard = () => {
  const [weather, setWeather] = useState('');

  useEffect(() => {
    // Ajoutez ici votre requête API pour récupérer les données météo, y compris la température et l'humidité
    fetch('/api/getAllWeather')
      .then(response => response.json())
      .then(data => {
        if (data.length > 0) {
          const weatherData = data[data.length-1];
          const temperature = weatherData.temperature;
          const humidity = weatherData.humidity;
          setWeather(`Température: ${temperature}°C  Humidité: ${humidity}%`);
        }
      })
      .catch(error => {
        console.error('Erreur lors de la récupération des données météo :', error);
      });
  }, []);

  return (
    <Card style={{ width: 315 }}>
      <Meta
        avatar={<CloudOutlined style={{
          color: "Yellow",
          backgroundColor: "rgba(0,255,0,0,25)",
          borderRadius: 20,
          fontSize: 24,
          padding: 8,
        }} />}
        title="Météo"
        description={weather}
      />
    </Card>
  );
};


const PlantHealthCard = () => {
  const [health, setHealth] = useState('');

  useEffect(() => {
    axios.get('/api/getAllEtatdesante')
      .then(response => {
        const etatsantedata = response.data;
              console.log(etatsantedata);
        if (etatsantedata.length > 0) {
          const latestData = etatsantedata[etatsantedata.length - 1];
          const latestetatsante = latestData.plantHealthStatus;

          setHealth(latestetatsante);
        }
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  return (
    <Card style={{ width: 360, height: 116 }}>
      <Meta
        avatar={<SafetyOutlined style={{
          color: "Teal",
          backgroundColor: "rgba(0,255,0,0,25)",
          borderRadius: 20,
          fontSize: 24,
          padding: 8,
        }} />}
        title="État de santé de la plante"
        description={`${health}`}
      />
    </Card>
  );
};


const WaterLevelCard = () => {
  const [waterLevel, setWaterLevel] = useState(0);

  useEffect(() => {
    fetch('/api/getAllQuantiteeau') // Modifier l'URL si nécessaire
      .then(response => response.json())
      //console.log(reponse)
      .then(data => {
        // Récupérer le niveau d'eau à partir des données reçues
        // Supposons que le niveau d'eau se trouve dans la première quantité d'eau de la liste
        if (data.length > 0) {
          const firstQuantiteeau = data[data.length-1];
          const level = firstQuantiteeau.humidity;
          setWaterLevel(level);
        }
      })
      .catch(error => {
        console.error('Erreur lors de la récupération du niveau d\'eau :', error);
      });
  }, []);

  return (
    <Card style={{width: 366 , height : 116  }}>
      <Meta
        avatar={<AlertOutlined style={{
          color: "black",
          backgroundColor: "rgba(0,255,0,0.25)",
          borderRadius: 20,
          fontSize: 24,
          padding: 8,
        }} />}
        title="Niveau d'eau"
        description={`${waterLevel}%`}
      />
    </Card>
  );
};

const Customers = () => {
  const [customers, setCustomers] = useState(0);

  useEffect(() => {
    axios.get('/api/getTotalRows')
      .then(response => {
        setCustomers(response.data);
      })
      .catch(error => {
        console.error('Error fetching customer count:', error);
      });
  }, []);

  return (
    <Card style={{ width: 320 , height : 116  }}>
      <Meta
        avatar={
          <Avatar
            style={{
              color: 'green',
              backgroundColor: 'rgba(0, 255, 0, 0, 25)',
              borderRadius: 10,
              fontSize: 25,
              padding: 2,
            }}
            icon={<UserOutlined />}
          />
        }
        title="Customers"
        description={`${customers}`}
      />
    </Card>
  );
};

const RecentOrders = () => {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    fetch('/api/getAllProduits')
      .then(res => res.json())
      .then(data => setOrders(data))
      .catch(err => console.log(err));
  }, []);

  const columns = [
    {
      title: "nom produit",
      dataIndex: "nomproduit",
    },
    {
      title: "reference produit",
      dataIndex: "referenceproduit",
    },
    {
      title: "quantite total",
      dataIndex: "quantitetotal",
    },
    {
      title: "quantite alerte",
      dataIndex: "quantitealerte",
    },
    {
      title: "numtelephone fournisseur",
      dataIndex: "numtelephonefournisseur",
    },
    {
      title: "img de produit",
      dataIndex: "img",
    }
  ];

  return (
    <div>
      <Typography.Title level={4}>Recent Orders</Typography.Title>
      <Table
        columns={columns}
        dataSource={orders}
        rowKey="id"
      />
    </div>
  );
};

const Dashboard = () => {
  return (
    <div>
      <Typography.Title level={5}>Dashboard</Typography.Title>
      <table>
        <tbody>
          <tr>
            <th><PlantTemperatureCard /></th>
            <th><PlantHumidityCard /></th>
            <th><WeatherCard /></th>
          </tr>
          <tr>
            <th><WaterLevelCard /></th>
            <th><PlantHealthCard /></th>
            <th><Customers /></th>
          </tr>
        </tbody>
      </table>
      <table>
        <tbody>
          <tr>
            <th><RecentOrders /></th>
            {/*<th><PlantCard /></th>*/}
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default Dashboard;
