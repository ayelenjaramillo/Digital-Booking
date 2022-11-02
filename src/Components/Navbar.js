import {Link, Outlet} from "react-router-dom"; 
import Componente from "../assets/Componente.png"; 
import './Navbar.css';
import { GiHamburgerMenu } from 'react-icons/gi';


const NavBar =()=> {
    return(
<>
<header className="header-navbar">
  <h2 ><Link to="/Home"><img className="image" src={Componente} alt="title"/></Link></h2>  
  <ul className="h-list">    
  <div className="hamburger-menu">
  <GiHamburgerMenu />
  </div>  
    <li><button><Link to = "/LogIn"> Iniciar Sesion </Link></button></li>
    <li><button><Link to = "/Registro"> Crear Cuenta </Link></button></li>
  </ul>
</header>
<Outlet/>
</>
)}; 

export default NavBar; 