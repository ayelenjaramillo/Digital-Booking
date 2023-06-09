import { Link } from "react-router-dom";
import "../Components/Registro.css"
import NavBar from "../Components/Navbar";


const Registro =()=>{
    return(
        <div>
            <NavBar/>
            <div className="registro">
                <form >
                    <p className="ptext"> Crear cuenta</p>
                    <div className="nya-inlinen">
                        <label for="fname" className="nblock">Nombre</label>
                        <input className="input-registro" type="text" id="nombre" name="nombre" />
                    </div>
                    <div className="nya-inlinea">
                        <label for="lname" className="lblock">Apellido</label>
                        <input className="input-registro" type="text" id="apellido" name="apellido"/>
                    </div>    
                    <div>
                        <label for="fname">Correo electrónico</label>
                        <input className="input-registro" type="text" id="correo" name="correo" />
                        <label for="fname">Contraseña </label>
                        <input className="input-registro" type="password" id="contraseña" name="contraseña" />
                        <label for="fname">Repetir contraseña</label>
                        <input className="input-registro" type="password" id="rcontraseña" name="rcontraseña" />
                        <div className="buttonholder">
                            <input className="submit-registro" type="submit" value="Crear cuenta"/>
                        </div>
                        <p className="loginalign">Ya tienes una cuenta?<Link to="/LogIn" className="r-text" style={{color:"black"}}>Iniciar sesion</Link></p>
                    </div> 
                </form>
            </div>
        </div> 
    ); 
}
export default Registro; 