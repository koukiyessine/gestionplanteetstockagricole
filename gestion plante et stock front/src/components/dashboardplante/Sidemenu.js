import React, { useEffect, useState } from "react";
import { Menu } from "antd";
import {
  AppstoreOutlined,
  BarChartOutlined,
  ShoppingCartOutlined,
  UserOutlined,
  EditFilled,
  DeleteFilled,
  DiffOutlined,
} from "@ant-design/icons";
import { useNavigate, useLocation } from "react-router-dom";

function Sidemenu() {
  const location = useLocation();
  const [selectedKeys, setSelectedKeys] = useState("/");

  useEffect(() => {
    const pathName = location.pathname;
    setSelectedKeys(pathName);
  }, [location.pathname]);

  const navigate = useNavigate();

  return (
    <div className="Sidemenuu">
      <Menu
        onClick={(item) => {
          navigate(item.key);
        }}
        defaultSelectedKeys={[selectedKeys]}
        items={[
          {
            label: "Dashbaord",
            key: "/Dashboardapp",
            icon: <AppstoreOutlined />,
          },
          {
            label: "Rapport",
            key: "/Dashboardapp/Rapport",
            icon: <BarChartOutlined />,
          },
        /*  {
            label: "Orders",
            key: "/Dashboardapp/Orders",
            icon: <ShoppingCartOutlined />,
          },
          {
            label: "Customers",
            key: "/Dashboardapp/Customers",
            icon: <UserOutlined />,
          },*/
          {
            label: "Ajouterplante",
            key: "/Dashboardapp/Ajouterplante",
            icon: <EditFilled />,
          },
          {
            label: "Supprimerplante",
            key: "/Dashboardapp/Supprimerplante",
            icon: <DeleteFilled />,
          },
          {
            label: "Mise a jour plante",
            key: "/Dashboardapp/Miseajourplante",
            icon: <DiffOutlined />,
          },
        ]}
      />
    </div>
  );
}

export default Sidemenu;
