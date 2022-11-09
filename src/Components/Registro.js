import { Link, Outlet } from "react-router-dom";
import "../Components/Registro.css"
import Componente from "../assets/Componente.png"; 
import NavBar from "../Components/Navbar";
import { BsEyeSlash } from 'react-icons/bs';

const Registro =()=>{
    return(
        <div>
            {/* <div className="r-navbar">
        <Link to="/Home"><img  src={Componente} alt="title"/></Link>
        <button className="r-boton"><Link to = "/LogIn"> Iniciar Sesion </Link></button>
        <Outlet/></div> */}
        <NavBar/>
        <div className="registro">
        <form action="/action_page.php">
        <p className="ptext"> Crear cuenta</p>
            <label for="fname">Nombre</label>
            <input className="input-registro" type="text" id="nombre" name="nombre" />
            <label for="lname">Apellido</label>
            <input className="input-registro" type="text" id="apellido" name="apellido"/>
            <label for="fname">Correo electrónico</label>
            <input className="input-registro" type="text" id="correo" name="correo" />
            <label for="fname">Contraseña </label>
            <input className="input-registro" type="password" id="contraseña" name="contraseña" />
            <label for="fname">Repetir contraseña</label>
            <input className="input-registro" type="password" id="rcontraseña" name="rcontraseña" />
            <div className="buttonholder">
                <input className="submit-registro" type="submit" value="Crear cuenta"/>
            </div>
            <p className="loginalign">Ya tienes una cuenta?<Link to="/LogIn" className="r-text">Iniciar sesion</Link></p>
        </form>
        </div>

        {/* <div className="container-registro">
            <form className="formulario">
            <p className="ptext"> Crear cuenta</p>
            <div className="r-l-especial">
                <label> Nombre</label>
                    <input type ="text"/>
                <label > Apellido </label>
                    <input type="text"/>
            </div>
                <label > Email</label>
                    <input type="email"/>
                <label>Contraseña</label>
                    <input  type="password"/><BsEyeSlash />
                <label> Confirmar Contraseña</label>
                <input type="password"/>                
                <button >Crear Cuenta</button>
                <p>Ya tenes cuenta?<Link to="/LogIn" className="r-text">Iniciar sesion</Link></p>
            </form>
        </div> */}

        </div> 
    ); 
}
export default Registro; 