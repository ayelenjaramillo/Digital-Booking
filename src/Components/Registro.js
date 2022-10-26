import { Link } from "react-router-dom";
import "../Components/Registro.css"

const Registro =()=>{
    return(
        <div>
        
           <div className="container_principal">
            <form className="formulario">
            <p className="text"> Crear cuenta</p>
                <label> Nombre</label>
                <br/>
                <input type ="text"/>
                <label> Apellido </label>
                <input type="text"/>
                <br/>
                <label> Email</label>
                <br/>
                <input type="email"/>
                <br/>
                <label>Contraseña</label>
                <br/>
                <input type="password"/>
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
                <Link to="/LogIn" className="text">
                    Iniciar sesion
                </Link></p>
                </form>
                </div>
                </div> 
        
    ); 
}
export default Registro; 