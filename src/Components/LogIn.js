import { useState } from "react";
import { Link, Outlet } from "react-router-dom";
import "../Components/Login.css"; 
import Componente from "../assets/Componente.png"; 
import { useNavigate } from "react-router-dom";
import "../Components/Login.css"; 


const LogIn =()=>{
    //Variable/hook para redirigir despues de hacer las validaciones
    const navigate = useNavigate();

    //Usuario previo para comparar con el nuevo y ver las validaciones
    const prevLoginState = {
        usuario:"usuario@hotmail.com", 
        contrasenia: "123456"
    }; 
    
    //Estado donde se guardara el usuario del Login
    const[loginState, setLoginState] = useState({
        usuario:"", 
        contrasenia: ""
    });     

    //Funcion para comparar el usuario nuevo con el guardado
    const compararDatos = (event) => {
        event.preventDefault();
        console.log(loginState.contrasenia)
        loginState.usuario === prevLoginState.usuario && loginState.contrasenia === prevLoginState.contrasenia ? navigate("/MenuPrincLogin", { state: {loginState: loginState}})
         : alert("Por favor vuelva a intentarlo, sus credenciales son inválidas")
        
    }

    return(
    <div> 
         <div className="r-navbar">
        <Link to="/Home"><img  src={Componente} alt="title"/></Link>
        <button className="l-botonnavbar" ><Link to = "/Registro"> Crear Cuenta </Link></button>
        <Outlet/></div>
        <div className="container_principal"> 
            <form className="formulario" onSubmit={compararDatos}>
                <h3>Iniciar sesion</h3>
                <label>Correo Electronico</label>
                <input type="email" placeholder="@..." required pattern=".+@hotmail\.com" onChange={(event)=>{
                    const value = event.target.value; 
                    console.log(value);
                    setLoginState({...loginState, usuario: value})
                }}/>
                <label>Contraseña</label>
                <input type="password" minLength={6} required onChange={(event)=>{
                    const value = event.target.value; 
                    setLoginState({...loginState, contrasenia: value})}}/>
                    

                <button className="boton_principal">
                    INGRESAR
                </button>
                <p> Aun no tenes cuenta?
                <Link to="/Registro" className="l-text">
          Registrarme
                </Link>  </p>
            </form>
        </div>
       
    </div>
    ); 
}; 
export default LogIn; 