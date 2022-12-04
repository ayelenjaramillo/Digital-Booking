import Avatar from "@material-ui/core/Avatar"; 
import Componente from "../assets/Componente.png"; 
import { Outlet, Link } from "react-router-dom";
import Reserva from "../Components/Reserva";
import './MenuPrincLogin.css';
import { useLocation } from "react-router-dom"; 


const MenuPrincLogin =(props)=>{
    const location = useLocation();
    console.log(location, " props"); 
    console.log(location, "useLocation Hook"); 
    const usuario = location.state?.loginState.usuario; 

    return(
        <div>
            <div className="div-header-menuprinc">
                <Link to="/"><img className="image" src={Componente} alt="title"/></Link>
                {/* <Outlet/> */}
                <div className="text-avatar">
                    <button src={usuario?usuario: ""} className="avatar">{usuario[0].toUpperCase()}</button>
                    <p>
                        <span>Hola, </span>
                        <span>{usuario}!</span>
                    </p>

                </div>                    
                <div className="closeButtonLogin">
                        <Link to="/">X</Link>
                    </div>
                {/* <p className="text-avatar">
                    <button src={usuario?usuario: ""} className="avatar">{usuario[0].toUpperCase()}</button>
                    &nbsp; Hola, 
                    <span>{usuario}!</span>
                    <div>
                        <Link to="/"><CloseButton/></Link>
                    </div>
                    
                </p> */}

            </div>
            <Reserva/>
        </div>
    ); 
}
export default MenuPrincLogin; 