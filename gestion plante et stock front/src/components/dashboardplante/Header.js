import React, { useEffect,useState } from "react";
import {  Image,Space,List,  Typography, Badge, Drawer } from "antd";
import { BellFilled, MailOutlined } from "@ant-design/icons";
import { getComments ,getOrders} from "./Pages/API";


function Header(){

    const [comments, setComments] = useState([]);
    const [orders, setOrders] = useState([]);
    const[commentsopen, setCommentsopen] = useState(false);
    const[notificationsOpen, setnotificationsOpen] = useState(false);
    useEffect(() => {
        getComments().then(res => {
          if (res && res.comments) { // add a check for res and res.total
            setComments(res.comments);
          }
        });
      }, []);

      useEffect(() => {
        if (getOrders) { // vérifier si getOrders est défini
          getOrders().then(res => {
            if (res && res.products) { // ajouter une vérification pour res et res.total
              setOrders(res.products);
            }
          });
        }
      }, []);
      
      
    return(
        <div className="tete">
                  <Image
        width={127} 
        src="./image1/11.jpg" alt="farm"/>
     
      <Typography.Title level={3}>plant Dashboard</Typography.Title>
      <Space>
             <Badge count={comments.length} dot>
             <MailOutlined    style={{ fontSize: 22 }} onClick={() => 
                 {setCommentsopen(true);  }}
                 />

             </Badge>
             <Badge count={orders.length}>
             <BellFilled     style={{ fontSize: 22 }}  
              onClick={() => 
                {setnotificationsOpen(true);  }}/>
             </Badge>
         </Space>
         <Drawer
        title="Comments"
        open={commentsopen}
        onClose={() => {
          setCommentsopen(false);
        }} maskClosable>

          <List
          dataSource={comments}
          renderItem={(item) => {
            return <List.Item>{item.body}</List.Item>;
          }}
        ></List>
      </Drawer>


      <Drawer
        title="Notification"
        open={notificationsOpen}
        onClose={() => {
          setnotificationsOpen(false);
        }} maskClosable>
             <List
          dataSource={orders}
          renderItem={(item) => {
            return (
              <List.Item>
                <Typography.Text strong>{item.title}</Typography.Text> has been
                ordered!
              </List.Item>
            );
          }}
        ></List>
      </Drawer>
        </div>

    );
}

export default Header;