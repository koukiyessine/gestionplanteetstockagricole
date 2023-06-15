import { Table } from 'antd';
import React, { useState, useEffect } from 'react';
import { Typography } from 'antd';

function Rapport() {
  const [plants, setPlants] = useState([]);

  useEffect(() => {
    fetch('/api/getAllplante')
      .then(response => response.json())
      .then(data => setPlants(data))
      .catch(error => console.error(error));
  }, []);

  const columns = [
    {
      title: 'nom plante',
      dataIndex: 'nomplante',
      key: 'nomplante',
    },
    {
      title: 'type sol',
      dataIndex: 'typedesol',
      key: 'typedesol',
    },
    {
      title: 'date plante',
      dataIndex: 'dateplante',
      key: 'dateplante',
    },
    {
      title: 'date de reclote',
      dataIndex: 'datereclote',
      key: 'datereclote',
    },
    {
      title: 'vitamine plante',
      dataIndex: 'vitamine',
      key: 'vitamine',
    },
    {
      title: 'nom Champ',
      dataIndex: 'nomChamp',
      key: 'nomChamp',
    },
    {
      title: 'ph plante',
      dataIndex: 'ph',
      key: 'ph',
    },
  ];

  return (
    <div>
      <Typography.Title level={3}>Rapport</Typography.Title>
      <Table dataSource={plants} columns={columns} />
    </div>
  );
}

export default Rapport;
