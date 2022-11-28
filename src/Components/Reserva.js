import "../Components/Reserva.css"
import NavBar from "./Navbar";
import "react-datepicker/dist/react-datepicker.css"; 
import DatePicker from "react-datepicker";
import React from "react";
import axios from "axios";
import { Link, Outlet } from "react-router-dom";
import { useState, useEffect} from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCircleCheck, faAngleLeft} from "@fortawesome/free-solid-svg-icons";



const Reserva = () =>{
    const[startDate, setStartDate] = useState(); 
    const [endDate, setEndDate]= useState();

    function onChangeDateHandler(value){
      
        setStartDate(value[0]); 
        setEndDate(value[1]);
        }  
        
 return(
    <div>
        <div className="header-hotel">
            {/* Esta parte tiene q salir de la API */}
            <p className="p-hotel"> Hotel 2<h4>Producto 2</h4></p>
            <span className="iconos"><Link to="/"><FontAwesomeIcon className="flecha" icon={faAngleLeft}/></Link>
            </span>
        </div>
        <div className="container-principal-reservas">
            <div className="reservas-horiz">
                <p className="title"> Completá tus datos </p> 
                <div className="datos-personales-reserva">
                    <div className="datos-div">
                        <label for="nombre" className="lblock">Nombre
                        <input className="input-registrorva" type="text" id="nombre" name="nombre"/></label>
                        <label for="apellido" className="lblock">Apellido
                        <input className="input-registrorva" type="text" id="apellido" name="apellido"/></label>
                        <label for="email" className="lblock">Correo Electronico
                        <input className="input-registrorva" type="text" id="email" name="email"/></label>
                        <label for="ciudad" className="lblock">Ciudad
                        <input className="input-registrorva" type="text" id="ciudad" name="ciudad"/></label>
                    </div>
                </div>
                <div className="">
                    <p className="title"> Selecciona tu fecha de reserva</p>
                    <div className="datepicket-reservas">                
                    <DatePicker placeholderText= "CheckIn - CheckOut" selectsRange={true}
                        onChange = {onChangeDateHandler}
                        startDate={startDate}
                        endDate={endDate}
                        monthsShown={2}
                        inline
                        dateFormat="dd/MM/yyyy"
                    />
                    </div>
                </div>
                <p className="title"> Tu horario de llegada </p>
                <div className="hs-llegada-reservacion"> 
                    <figure className="info-reservas"><FontAwesomeIcon  icon={faCircleCheck} /> Tu habitacion va a estar lista para el check-in entre las 10.00AM y las 11.30PM</figure>
                    <p> Inclui tu horario estimado de llegada</p>
                    <select className="select-reserv">
                        <option> 10:00 AM</option>
                        <option> 12:00 AM</option>
                        <option> 14:00 PM</option>
                        <option> 16:00 AM</option>
                        <option> 18:00 AM</option>
                    </select>
                    <hr style={{color:"#1DBEB4"}}></hr>
                </div> 
            </div>
            <div className="reservas-vert">
                    <p style={{color:"#545776", "font-weight":"bold"}}> Detalle de la reserva </p>
                <figure><img src="../bed_and_breakfast.jpg" alt="bed_and_breakfast" className="image-reserva"/></figure>
                <p className="parrafo-info"> HOTEL</p>
                <span>
                    <i class="puntuacion fa-solid fa-star"></i>
                    <i class="puntuacion fa-solid fa-star"></i>
                    <i class="puntuacion fa-solid fa-star"></i>
                    <i class="puntuacion fa-solid fa-star"></i>
                    <i style={{color: "#CBCBCF"}} class="puntuacion fa-solid fa-star"></i>
                </span>
                <span className="vert-location">
                    <p className= "parrafo-info"> Producto 2 </p>
                    <p style={{color: "#545776"}}><span><i class="ubicacion fa-solid fa-location-dot"></i></span> Rosario, Argentina</p>
                    <hr style={{color:"#1DBEB4"}}/>
                </span>
                <span className="vert-check-in">
                    <p> Check In: </p>
                    <p className="fecha"> {startDate?.toLocaleDateString()}</p>
                </span>
                <hr style={{color:"#1DBEB4"}}></hr>
                <span className="vert-check-out">
                    <p> Check out: </p>
                    <p className="fecha">  {endDate?.toLocaleDateString()}</p>
                </span>
                <Link to="/ConfirmacionReserva">
                <button className="btn-confirmacion"> Confirmar Reserva </button>
                </Link><Outlet/>
            </div>        
        </div>
        
    </div>
    )
}
export default Reserva; 