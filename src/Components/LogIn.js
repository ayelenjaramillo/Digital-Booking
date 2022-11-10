import { useState } from "react";
import { Link, Outlet } from "react-router-dom";
import "../Components/Login.css"; 
import NavBar from "../Components/Navbar";
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
    <NavBar/>
        {/* <div className="r-navbar">
        <Link to="/Home"><img  src={Componente} alt="title"/></Link>
        <button className="l-botonnavbar" ><Link to = "/Registro"> Crear Cuenta </Link></button>
        <Outlet/></div> */}
        <div className="container_principal"> 
            <form onSubmit={compararDatos}>
            <p className="titlelogin">Iniciar sesion</p>
                <label>Correo Electronico</label>
                <input className="input-login" type="email" placeholder="@..." required pattern=".+@hotmail\.com" 
                    onChange={(event)=>{const value = event.target.value; 
                    console.log(value);
                    setLoginState({...loginState, usuario: value})
                }}/>
                <label>Contraseña</label>
                <input className="input-login" type="password" minLength={6} required 
                    onChange={(event)=>{
                    const value = event.target.value; 
                    setLoginState({...loginState, contrasenia: value})}}/>
                <div className="buttonholderlog">
                <button className="boton_principal">Ingresar</button>
                </div>
                <p className="accalign"> Aun no tenes cuenta?<Link to="/Registro" className="l-text">Registrate</Link></p>
            </form>
        </div>
    </div>
    ); 
}; 
export default LogIn; 