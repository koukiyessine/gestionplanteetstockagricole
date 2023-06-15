import React from "react";
import { Typography } from "antd";

function FooterStock(){
  
    return(
        <div className="footerr">
      <Typography.Link href="tel:+42498338">+42498338</Typography.Link>
      <Typography.Link href="https://www.google.com" target={"_blank"}>
        Privacy Policy
      </Typography.Link>
      <Typography.Link href="https://www.google.com" target={"_blank"}>
        Terms of Use
      </Typography.Link>
        </div>
    );
}

export default FooterStock;