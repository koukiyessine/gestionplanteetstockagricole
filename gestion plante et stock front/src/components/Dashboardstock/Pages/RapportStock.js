
import { Table, Typography } from 'antd';
import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Rapport() {
  const [plants, setPlants] = useState([]);

  useEffect(() => {
    axios.get('/api/getAllProduits')
      .then(response => {
        const produits = response.data;
        setPlants(produits);
      })
      .catch(error => {
        console.error('Error fetching products:', error);
      });
  }, []);

  const columns = [
    {
      title: 'Nom de produit',
      dataIndex: 'nomproduit',
      key: 'nomproduit',
    },
    {
      title: 'reference de produit',
      dataIndex: 'referenceproduit',
      key: 'referenceproduit',
    },
    {
      title: 'quantite total',
      dataIndex: 'quantitetotal',
      key: 'quantitetotal',
    },
    {
      title: 'quantite alerte',
      dataIndex: 'quantitealerte',
      key: 'quantitealerte',
    },

    {
      title: 'numtelephone fournisseur',
      dataIndex: 'numtelephonefournisseur',
      key: 'numtelephonefournisseur',
    },

    {
      title: 'img produit ',
      dataIndex: 'img',
      key: 'img',
    },
  ];

  return (
    <div>
      <Typography.Title level={4}>Rapport Stock</Typography.Title>
      <Table dataSource={plants} columns={columns} />
    </div>
  );
}

export default Rapport;
