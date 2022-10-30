import { useState } from "react";
import { Link } from "react-router-dom";
import "../Components/Login.css"; 
const LogIn =()=>{

    const prevLoginState = {
        usuario:"usuario@hotmail.com", 
        contrasenia: "123456"
    }; 
    
    const[loginState, setLoginState] = useState({
        usuario:"", 
        contrasenia: ""
    });     

    const compararDatos = (event) => {
        event.preventDefault();
        console.log(loginState.contrasenia)
        loginState.usuario === prevLoginState.usuario && loginState.contrasenia === prevLoginState.contrasenia ? window.location = "/MenuPrincLogin"
         : alert("Por favor vuelva a intentarlo, sus credenciales son inválidas")
        
    }

    return(
    <div> 
        
        <div className="container_principal"> 
            <form className="formulario" onSubmit={compararDatos}>
                <h3>Iniciar sesion</h3>
                <label>Correo Electronico</label>
                <br/>
                <input type="email" placeholder="@..." required pattern=".+@hotmail\.com" onChange={(event)=>{
                    const value = event.target.value; 
                    console.log(value);
                    setLoginState({...loginState, usuario: value})
                }}/>
                <br/>
                <label>Contraseña</label>
                <br/>
                <input type="password" minLength={6} required onChange={(event)=>{
                    const value = event.target.value; 
                    setLoginState({...loginState, contrasenia: value})}}/>
                    
                <br/>
                <Link to="/MenuPrincLogin" state={{ loginState: loginState }}>
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