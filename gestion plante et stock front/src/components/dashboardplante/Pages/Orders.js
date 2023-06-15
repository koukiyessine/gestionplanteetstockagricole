import { Table } from 'antd';
import React, { useState, useEffect } from 'react';
import { Typography } from 'antd';

function Orders() {
  const [plants, setPlants] = useState([]);

  useEffect(() => {
   /* fetch('https://example.com/api/plants')
      .then(response => response.json())
      .then(data => setPlants(data))
      .catch(error => console.error(error));*/
  }, []);

  const columns = [
    { 
      title: "Date",   
      dataIndex: "date",    
    },
    {        
      title: "nom de Produit",   
      dataIndex: "product",    
    },  
    {    
      title: "Quantité d'alert ",    
      dataIndex: "quantity",   
    },   
    {     
      title: "Total produit",     
      dataIndex: "total",   
    },
  ];

  return (
    <div>
    <Typography.Title level={4}>Stock de plante</Typography.Title>
    <Table dataSource={plants} columns={columns} />
    </div>
  );
}

export default Orders;
