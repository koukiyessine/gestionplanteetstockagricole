
import React, { useState, useEffect } from 'react';
import { Typography, Table } from 'antd';


function Customers() {
  const [Customers, setCustomers] = useState([]);

 /* useEffect(() => {
    fetch('https://dummyjson.com/users')
      .then(response => response.json())
      .then(data => setCustomers(data))
      .catch(error => console.error(error));
  }, []);*/

  const columns = [
    {
      title: 'image',
      dataIndex: 'image',
     
    },

    {
      title: 'FirstName',
      dataIndex: 'firstName',
 
    },

    {
      title: 'LastName',
      dataIndex: 'lastName',
      
    },

    {
      title: 'Gender',
      dataIndex: 'gender',
      
    },

    {
      title: 'Email',
      dataIndex: 'email',
      
    },

    {
        title: 'birthDate',
        dataIndex: 'birthDate',
       
      },

    {
      title: 'Phone',
      dataIndex: 'phone',
     
    },
  ];

  return (
    <div>
    <Typography.Title level={4}>Customers</Typography.Title>
    <Table dataSource={Customers} columns={columns} />
    </div>
  );
}

export default Customers;
