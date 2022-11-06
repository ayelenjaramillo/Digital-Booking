import {Link, Outlet} from "react-router-dom"; 
import Componente from "../assets/Componente.png"; 
import IconMob from "../assets/logo1.png"; 
import './Navbar.css';
import { GiHamburgerMenu } from 'react-icons/gi';
import React, {useState} from "react";



const NavBar =()=> {
  const [navbarOpen, setNavbarOpen] = useState(false)
  
  const handleToggle = () => {
    setNavbarOpen(prev => !prev)
  }

  const closeMenu = () => {
    setNavbarOpen(false)
  }

  return(
<>
<header className="header-navbar">
  <div>
    <Link to="/Home" activeclassname="active-link" onClick={() => closeMenu()}exact>
      <img className="image" src={Componente} alt="title"/>
      <img className="image2" src={IconMob} alt="title2"/>
    </Link>
  </div>  
  <div>
    <ul className="h-list">    
      <li><button><Link to = "/LogIn"> Iniciar Sesion </Link></button></li>
      <li><button><Link to = "/Registro"> Crear Cuenta </Link></button></li>
    </ul>
  </div>  
  <div className="navBar-mobile" onClick={handleToggle}>
    <div>{navbarOpen ? "" : <GiHamburgerMenu size={25}/>}</div>  
    <ul className={`menuNav ${navbarOpen ? " showMenu" : ""}`}>
      <div>{navbarOpen ? "X" : ""}</div>  
      <h3>MENÚ</h3>    
      <li><Link to = "/Registro"> Crear Cuenta </Link></li>
      <hr></hr>
      <li><Link to = "/LogIn"> Iniciar Sesion </Link></li>
    </ul>
  </div>
</header>
<Outlet/>
</>
)}; 

export default NavBar; 