import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCircleCheck} from "@fortawesome/free-solid-svg-icons";
import React from "react";
import "../Components/ConfirmacionReserva.css"; 
const ConfirmacionReserva = () =>{
    return(
    <div className="container-check">
        <div className="cuadro-reserv">
        <figure className="check">
        <FontAwesomeIcon style={{"background-color":"white"}} icon={faCircleCheck} />
        </figure>
        <p style={{"font-weight":"bold", "font-size":23, color: "#1DBEB4", "background-color":"white"}} className="p-reservas"> Muchas Gracias! </p>
        <p style={{"font-weight":"bold", "font-size":15, "background-color":"white"}} className="p-reservasbis"> Su reserva se ha realizado con exito </p>
        <button className="botton-check">ok</button></div>
    </div>
    )
}
export default ConfirmacionReserva; 