import React from "react";
import { Space } from "antd";
import "./DashboardStockapp.css";
import FooterStock from "./FooterStock";
import HeaderStock from "./HeaderStock";
import PagecontentStock from "./PagecontentStock";
import SidemenuStock from "./SidemenuStock";

function DashboardStockapp(){
return(
<div className="appp">
<HeaderStock/>
<Space className="sidemenuandpagecontent">
    <SidemenuStock/>
    <PagecontentStock/>
</Space>
<FooterStock/>
</div>
);
}

export default DashboardStockapp;