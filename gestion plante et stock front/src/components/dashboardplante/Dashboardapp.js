import React from "react";
import { Space } from "antd";
import "./Dashboardapp.css";
import Footer from "./Footer";
import Header from "./Header";
import Pagecontent from "./Pagecontent";
import Sidemenu from "../dashboardplante/Sidemenu";


function Dashboardapp(){
return(

<div className="APP">
<Header/>
<Space className="SideMenuAndPage">
    <Sidemenu/>
    <Pagecontent/>
</Space>
<Footer/>
</div>

);
}

export default Dashboardapp;