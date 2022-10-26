import { useState } from "react";
import { Link } from "react-router-dom";
import "../Components/Login.css"; 
const LogIn =()=>{
    
    const[loginState, setLoginState] = useState({
        usuario:"", 
        contrasenia: "", 
    });     
    return(
    <div> 
        
        <div className="container_principal"> 
  <form className="formulario">
                <h3>Iniciar sesion</h3>
                <label>Correo Electronico</label>
                <br/>
                <input type="email" placeholder="@..." onChange={(event)=>{
                    const value = event.target.value; 
                    console.log(value);
                    setLoginState({...loginState, usuario: value})
                }}/>
                <br/>
                <label>Contraseña</label>
                <br/>
                <input type="password" onChange={(event)=>{
                    const value = event.target.value; 
                    setLoginState({...loginState, contrasenia: value})}}/>
                <br/>
                <Link to="/MenuPrincLogin">
                <button className="boton_principal" disabled ={!loginState.contrasenia || !loginState.usuario}>
                INGRESAR     
                </button>
                </Link>
                <br/>
                <p> Aun no tenes cuenta? 
                <Link to="/Registro" className="text">
                  Registrarme
                </Link>  </p>
                </form>
        </div>
       
 </div>
    ); 
}; 
export default LogIn; 