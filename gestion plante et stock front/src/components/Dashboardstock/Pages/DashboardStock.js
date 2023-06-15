import React, { useState, useEffect } from 'react';
import { Card, Typography, /*Table*/ Avatar } from 'antd';
import "./DashboardStock.css"
import { UserOutlined, ShoppingCartOutlined } from '@ant-design/icons';
import axios from 'axios';





const StockDisplay = () => {
  const [stockTotal, setStockTotal] = useState('');

  useEffect(() => {
    axios.get('/api/getListNomProduitWithQuantiteTotal')
      .then(response => {
        const nomProduitList = response.data;
        const stockTotalText = nomProduitList.join(', ');
        setStockTotal(stockTotalText);
      })
      .catch(error => {
        console.error('Error fetching stock total:', error);
      });
  }, []);

  return (
    <Card style={{ width: 300, height: 165 }}>
      <Card.Meta
        avatar={
          <Avatar
            style={{
              color: 'green',
              backgroundColor: 'rgba(0, 255, 0, 0.25)',
              borderRadius: 10,
              fontSize: 25,
              padding: 2,
            }}
            icon={<ShoppingCartOutlined />}
          />
        }
        title="Stock total de produit"
        description={stockTotal}
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
    <Card style={{ width: 200, height: 165 }}>
      <Card.Meta
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

const Referenceproduit = () => {
  const [referenceProduit, setReferenceProduit] = useState('');

  useEffect(() => {
    axios.get('/api/getListNomProduitWithreferenceproduit')
      .then(response => {
        const nomProduitList = response.data;
        const referenceProduitText = nomProduitList.join(', ');
        setReferenceProduit(referenceProduitText);
      })
      .catch(error => {
        console.error('Error fetching reference produit:', error);
      });
  }, []);

  return (
    <Card style={{ width: 300, height: 165 }}>
      <Card.Meta
        avatar={
          <Avatar
            style={{
              color: 'green',
              backgroundColor: 'rgba(0, 255, 0, 0.25)',
              borderRadius: 10,
              fontSize: 25,
              padding: 2,
            }}
            icon={<ShoppingCartOutlined />}
          />
        }
        title="Référence de produit"
        description={referenceProduit}
      />
    </Card>
  );
};



/*
const product = [
  { name: "Pommes", stock: 50, alertQuantity: 10 },
  { name: "Oranges", stock: 75, alertQuantity: 15 },
  { name: "Bananes", stock: 100, alertQuantity: 20 },
  { name: "Tomates", stock: 25, alertQuantity: 5 },
];*/

const Quantitéalerte = () => {
  const [quantiteAlerte, setQuantiteAlerte] = useState('');

  useEffect(() => {
    axios.get('/api/getListNomProduitWithquantitealerte')
      .then(response => {
        const nomProduitList = response.data;
        const quantiteAlerteText = nomProduitList.join(', ');
        setQuantiteAlerte(quantiteAlerteText);
      })
      .catch(error => {
        console.error('Error fetching quantité alerte:', error);
      });
  }, []);

  return (
    <Card style={{ width: 300, height: 165 }}>
      <Card.Meta
        avatar={
          <Avatar
            style={{
              color: 'green',
              backgroundColor: 'rgba(0, 255, 0, 0.25)',
              borderRadius: 10,
              fontSize: 25,
              padding: 2,
            }}
            icon={<ShoppingCartOutlined />}
          />
        }
        title="Quantité d'alerte produit"
        description={quantiteAlerte}
      />
    </Card>
  );
};




const Fournisseurproduit = () => {
  const [fournisseurProduit, setFournisseurProduit] = useState('');

  useEffect(() => {
    axios.get('/api/getListNomProduitWithnumtelephonefournisseur')
      .then(response => {
        const nomProduitList = response.data;
        const fournisseurProduitText = nomProduitList.join(', ');
        setFournisseurProduit(fournisseurProduitText);
      })
      .catch(error => {
        console.error('Error fetching fournisseur produit:', error);
      });
  }, []);

  return (
    <Card style={{ width: 300, height: 165 }}>
      <Card.Meta
        avatar={
          <Avatar
            style={{
              color: 'green',
              backgroundColor: 'rgba(0, 255, 0, 0.25)',
              borderRadius: 10,
              fontSize: 25,
              padding: 2,
            }}
            icon={<UserOutlined />}
          />
        }
        title="Fournisseur de produit"
        description={fournisseurProduit}
      />
    </Card>
  );
};

      /*
const columns = [
  {
    title: 'ID',
    dataIndex: 'id',
    key: 'id',
  },
  {
    title: 'Nom',
    dataIndex: 'name',
    key: 'name',
  },
  {
    title: 'Téléphone',
    dataIndex: 'phone',
    key: 'phone',
  },
];

const data = [
  {
    id: 1,
    name: 'Fournisseur 1',
    phone: '0123456789',
  },
  {
    id: 2,
    name: 'Fournisseur 2',
    phone: '9876543210',
  },
];

const FournisseurTable = () => {
  const rowKey = (record) => record.id;
  
  const expandedRowRender = (record) => (
    <Card style={{ margin: '0 50px 30px' }}>
      <Card.Meta
        avatar={
          <Avatar
            style={{ backgroundColor: 'rgba(0,255,0,0.25)' }}
            icon={<UserOutlined />}
          />
        }
        title={`Fournisseur ${record.id}`}
        description={
          <div>
            <p>Nom: {record.name}</p>
            <p>Téléphone: {record.phone}</p>
          </div>
        }
      />
    </Card>
  );
  
  return (
    <>
    <Typography.Title level={4}>Recent Fournisseur</Typography.Title>
    <Table     
      dataSource={data}
      columns={columns}
      rowKey={rowKey}
      expandable={{ expandedRowRender }}
    />
    </>
  );
};
*/



const DashboardStock = () => {
  return (
    <div>
      <Typography.Title level={3}>Dashboard Stock</Typography.Title>
      <table>
        <tbody>
        <tr>
          <th>
            <StockDisplay />
          </th>

          <th>
            <Customers />
          </th>

          <th>
            <Referenceproduit />
          </th>
          <th>
            <Quantitéalerte />
          </th>
        </tr>
        </tbody>
      </table>
      <table>
        <tbody>
        <tr>
          <th><Fournisseurproduit/></th>
         
        </tr>
        </tbody>
      </table>
    </div>
  );
};

export default DashboardStock;
