import { Link, Outlet } from "react-router-dom";
import "../Components/Registro.css"
import Componente from "../assets/Componente.png"; 
import { BsEyeSlash } from 'react-icons/bs';

const Registro =()=>{
    return(
        <div>
            <div className="r-navbar">
        <Link to="/Home"><img  src={Componente} alt="title"/></Link>
        <button className="r-boton"><Link to = "/LogIn"> Iniciar Sesion </Link></button>
        <Outlet/></div>
           <div className="container_principal">
            <form className="formulario">
            <p className="text"> Crear cuenta</p>
                <label className="r-l-especial"> Nombre</label><label> Apellido </label>
                <br/>
                <input className="r-input-especial" type ="text"/>
                <input className="r-input-especial" type="text"/>
                <br/>
                <label> Email</label>
                <br/>
                <input type="email"/>
                <br/>
                <label>Contraseña</label>
                <br/>
                <input type="password"/><BsEyeSlash />
                <br/>
                <label> Confirmar Contraseña</label>
                <br/>
                <input type="password"/>
                
                <br/>
                <button className="boton_principal">
                Crear Cuenta
                </button>
                <br/>
                <p>Ya tenes cuenta?
                <Link to="/LogIn" className="r-text">
                    Iniciar sesion
                </Link></p>
                </form>
                </div>
                </div> 
        
    ); 
}
export default Registro; 