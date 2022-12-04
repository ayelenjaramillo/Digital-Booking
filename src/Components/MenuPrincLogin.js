import Avatar from "@material-ui/core/Avatar"; 
import Componente from "../assets/Componente.png"; 
import IconMob from "../assets/logo1.png"; 
import { Outlet, Link } from "react-router-dom";
import Reserva from "../Components/Reserva";
import './MenuPrincLogin.css';
import { useLocation } from "react-router-dom"; 
import { GiHamburgerMenu } from 'react-icons/gi';
import React, {useState} from "react";
import {BsFacebook} from 'react-icons/bs';
import {FaLinkedinIn} from 'react-icons/fa';
import {BsInstagram} from 'react-icons/bs';
import {AiOutlineTwitter} from 'react-icons/ai';


const MenuPrincLogin =(props)=>{
    const location = useLocation();
    console.log(location, " props"); 
    console.log(location, "useLocation Hook"); 
    const usuario = location.state?.loginState.usuario; 

    const [navbarOpenmpl, setNavbarOpenmpl] = useState(false)
    
    const handleTogglempl = () => {
        setNavbarOpenmpl(prev => !prev)
    }

    const closeMenumpl = () => {
        setNavbarOpenmpl(false)
    }

    return(
        <div>
            <div className="div-header-menuprinc">
                {/* <Link to="/"><img className="imagempl" src={Componente} alt="titlempl"/></Link>
                <Link to="/"><img className="imagempl2" src={IconMob} alt="titlempl2"/></Link> */}
                {/* <Outlet/> */}
                <div className="imagesmpl">
                    <Link to="/" onClick={() => closeMenumpl()}><img className="imagempl" src={Componente} alt="titlempl"/></Link>
                    <Link to="/"onClick={() => closeMenumpl()} ><img className="imagempl2" src={IconMob} alt="titlempl2"/></Link>
                </div>
                <div className="text-avatar">
                        
                    <button src={usuario?usuario: ""} className="avatar">{usuario[0].toUpperCase()}</button>
                        <p>
                            <span>Hola, </span>
                            <span>{usuario}!</span>
                        </p>
                </div>       
                <div className="navBar-mobilempl" onClick={handleTogglempl}>
                <div>{navbarOpenmpl ? "" : <GiHamburgerMenu size={25}/>}</div>  
                <ul className={`menuNavmpl ${navbarOpenmpl ? " showMenumpl" : ""}`}>
                <div>{navbarOpenmpl ? "X" : ""}</div> 
                <div className="avatarmobile">                    
                    <button src={usuario?usuario: ""} className="avatar">{usuario[0].toUpperCase()}</button>
                        <p>
                            <span>Hola, </span>
                            <span>{usuario}!</span>
                        </p>   
                </div>       
                <p>¿Deseas<Link to="/">cerrar sesión?</Link></p>       
                <li className="redes-mobilempl"><BsInstagram size={20}/></li>
                <li className="redes-mobilempl"><AiOutlineTwitter size={20}/></li>
                <li className="redes-mobilempl"><FaLinkedinIn size={20}/></li>
                <li className="redes-mobilempl"><BsFacebook size={20}/></li>
                </ul>
            </div>             
                <div className="closeButtonLogin">
                    <Link to="/">X</Link>
                </div>
            </div>
            
            <Reserva/>
        </div>
    ); 
}
export default MenuPrincLogin; 