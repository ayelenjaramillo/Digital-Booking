import {Link, Outlet} from "react-router-dom"; 
import Componente from "../assets/Componente.png"; 
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
  <h2 >
    <Link to="/Home" activeclassname="active-link" onClick={() => closeMenu()}exact>
      <img className="image" src={Componente} alt="title"/>
    </Link>
  </h2>  
  <div>
  <ul className="h-list">    
    <li><button><Link to = "/LogIn"> Iniciar Sesion </Link></button></li>
    <li><button><Link to = "/Registro"> Crear Cuenta </Link></button></li>
  </ul>
  </div>  
  <div className="navBar-mobile" onClick={handleToggle}>
    <button>{navbarOpen ? "" : <GiHamburgerMenu/>}</button>  
    <ul className={`menuNav ${navbarOpen ? " showMenu" : ""}`}>
      <button>{navbarOpen ? "X" : ""}</button>  
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