import {Link, Outlet} from "react-router-dom"; 
import Componente from "../assets/Componente.png"; 
import './Navbar.css'

const NavBar =()=> {
    return(
<>
<header className="h-title">
  <h2 ><Link to="/Home"><img className="image" src={Componente} alt="title"/></Link></h2>  
  <ul className="h-list">  
    <li><button><Link to = "/LogIn"> Iniciar Sesion </Link></button></li>
    <li><button><Link to = "/Registro"> Crear Cuenta </Link></button></li>
  </ul>
</header>
<Outlet/>
</>
)}; 

export default NavBar; 