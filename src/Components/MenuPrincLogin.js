
import Avatar from "@material-ui/core/Avatar"; 
import Componente from "../assets/Componente.png"; 
import { Outlet, Link } from "react-router-dom";
import Home from "../Components/Home"
import './MenuPrincLogin.css';
import { useLocation } from "react-router-dom"; 


const MenuPrincLogin =(props)=>{
    const location = useLocation();
    console.log(location, " props"); 
    console.log(location, "useLocation Hook"); 
    const usuario = location.state?.loginState.usuario; 

    return(
        <div className="main-menuprincipal">
        <div className="div-header-menuprinc">
         <Link to="/Home"><img className="image" src={Componente} alt="title"/></Link>
            <Outlet/>
            <p className="text-avatar">Hola, {usuario}!
        <Avatar src={usuario?usuario: ""} className="avatar">{usuario[0].toUpperCase()}</Avatar></p>
      </div>
      <Home/>
        </div>
    ); 
}
export default MenuPrincLogin; 