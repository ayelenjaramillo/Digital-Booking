import "../Components/Reserva.css"
import NavBar from "./Navbar";
import "react-datepicker/dist/react-datepicker.css"; 
import DatePicker from "react-datepicker";
import React from "react";
import axios from "axios";
import { Link, Outlet } from "react-router-dom";
import { useState, useEffect} from "react";


const Reserva = () =>{
    const[startDate, setStartDate] = useState(); 
    const [endDate, setEndDate]= useState();

    function onChangeDateHandler(value){
        console.log(value)
        setStartDate(value[0]); 
        setEndDate(value[1]);
        }  
        console.log(endDate)
 return(
    <div>
    <div className="container-principal-reservas">
        <div className="reservas-horiz">
            
            <p className="title"> Completa tus datos </p> 
            <div className="datos-personales-reserva">
            <div className="datos-div">
                <label for="lname" className="lblock">Nombre
                <input className="input-registro" type="text" id="apellido" name="apellido"/></label>
                <label for="lname" className="lblock">Apellido
                <input className="input-registro" type="text" id="apellido" name="apellido"/></label>
                <label for="lname" className="lblock">Correo Electronico
                <input className="input-registro" type="text" id="apellido" name="apellido"/></label>
                <label for="lname" className="lblock">Ciudad
                <input className="input-registro" type="text" id="apellido" name="apellido"/></label>
                </div>
            </div>
            <div className="datepicket-reservas">
            <p className="title"> Selecciona tu fecha de reserva</p>
            <DatePicker placeholderText= "CheckIn - CheckOut" selectsRange={true}
                    onChange = {onChangeDateHandler}
                    startDate={startDate}
                    endDate={endDate}
                    monthsShown={2}
                    inline
                    dateFormat="dd/MM/yyyy"
                    />
            </div>
             <p className="title"> Tu horario de llegada </p>
            <div className="hs-llegada-reservacion"> 
            <figure className="info-reservas">
                <i class="fa-solid fa-circle-check"></i> Tu habitacion va a estar lista para el check-in entre las 10.00AM y las 11.30PM
            </figure>
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
            <figure>
                <img src="../bed_and_breakfast.jpg" alt="bed_and_breakfast" className="image-reserva"/>
            </figure>
            <p style={{"font-weight": "bold", "font-size":15, color:"#545776"}}> HOTEL</p>
             <span>
                <i class="puntuacion fa-solid fa-star"></i>
                <i class="puntuacion fa-solid fa-star"></i>
                <i class="puntuacion fa-solid fa-star"></i>
                <i class="puntuacion fa-solid fa-star"></i>
                <i style={{color: "#CBCBCF"}} class="puntuacion fa-solid fa-star"></i>
            </span>
            <span className="vert-location">
                <p style={{"font-weight":"bold", "font-size":25, color: "#545776"}}> Pepito Hotel </p>
                <p style={{color: "#545776"}}><span><i class="ubicacion fa-solid fa-location-dot"></i></span> Av. Colon 1643, Buenos Aires, Ciudad Autonoma de Bs As, Argentina.</p>
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
    <div className="politicas-alojamiento">

   
 </div>
 </div>
    
    )
}
export default Reserva; 