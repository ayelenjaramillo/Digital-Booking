import { Link, Outlet } from "react-router-dom";
import "../Components/Registro.css"
import Componente from "../assets/Componente.png"; 
import NavBar from "../Components/Navbar";


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

        </div> 
    ); 
}
export default Registro; 