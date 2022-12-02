import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCircleCheck} from "@fortawesome/free-solid-svg-icons";
import { Link } from "react-router-dom";
import React from "react";
import "../Components/ConfirmacionReserva.css"; 
const ConfirmacionReserva = () =>{
    return(
    <div className="container-check">
        <div className="cuadro-reserv">
        <figure className="check">
        <FontAwesomeIcon style={{"background-color":"white"}} icon={faCircleCheck} />
        </figure>
        <div className="dosparrafos-rsv">
        <p className="p-reservass"> Muchas Gracias! </p>
        <p className="p-reservasbis"> Su reserva se ha realizado con exito </p>
        </div>
        <Link to="/AdministradorTemplate" className="l-text"><button className="botton-check">ok</button></Link>
        </div>
    </div>
    )
}
export default ConfirmacionReserva; 