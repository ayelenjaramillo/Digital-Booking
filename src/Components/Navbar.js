import {Link, Outlet} from "react-router-dom"; 
import Componente from "../assets/Componente.png"; 
import IconMob from "../assets/logo1.png"; 
import './Navbar.css';
import { GiHamburgerMenu } from 'react-icons/gi';
import React, {useState} from "react";
import {BsFacebook} from 'react-icons/bs';
import {FaLinkedinIn} from 'react-icons/fa';
import {BsInstagram} from 'react-icons/bs';
import {AiOutlineTwitter} from 'react-icons/ai';



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
    <Link to="/" activeclassname="active-link" onClick={() => closeMenu()}exact="true">
      <img className="image" src={Componente} alt="title"/>
      <img className="image2" src={IconMob} alt="title2"/>
    </Link>
  </div>  
  <div>
    <ul className="h-list">    
      {window.location.pathname.includes("/LogIn")? null : <li><button><Link to = "/LogIn"> Iniciar Sesion </Link></button></li>}
      {window.location.pathname.includes("/Registro")? null : <li><button><Link to = "/Registro"> Crear Cuenta </Link></button></li>}
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
      <li className="redes-mobile"><BsInstagram size={20}/></li>
      <li className="redes-mobile"><AiOutlineTwitter size={20}/></li>
      <li className="redes-mobile"><FaLinkedinIn size={20}/></li>
      <li className="redes-mobile"><BsFacebook size={20}/></li>
    </ul>
  </div>
</header>
<Outlet/>
</>
)}; 

export default NavBar; 