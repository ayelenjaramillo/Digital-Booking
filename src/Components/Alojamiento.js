import React from "react";
import { useState} from 'react';
import { Link } from "react-router-dom";
import "../Components/Alojamiento.css"; 
import "react-datepicker/dist/react-datepicker.css"; 
import DatePicker from "react-datepicker";

const Alojamiento=()=>{
    const[startDate, setStartDate] = useState(); 
    const [endDate, setEndDate]= useState(); 
    function onChangeDateHandler(value){
        setStartDate(value[0]); 
        setEndDate(value[1]);
        }   
return(
<div className="main-imagenes">
   <div className="header-hotel">
    <p className="p-hotel">Alojamiento
        <h4>Nombre del Alojamiento</h4>
    </p>
    <span className="iconos">
        <Link to="/Home"><i class="flecha fa-solid fa-arrow-left"></i></Link>
    </span>
 </div>
   <div className="infolocation-hotel">
    <p className="p-hotel">
        <i class="fa-solid fa-location-dot"></i>
            Buenos Aires, Argentina
        <p>A 150 m del centro; </p>
    </p>
    <span>
        <h5 >Muy Bueno</h5>
        <i class="puntuacion fa-solid fa-star"></i>
        <i class="puntuacion fa-solid fa-star"></i>
        <i class="puntuacion fa-solid fa-star"></i>
        <i class="puntuacion fa-solid fa-star"></i>

    </span>
   </div> 
  
   <p>-----------AQUI IRIA EL BLOQUE DE IMAGENEs---------------</p>
    <span>
        <h3>Alojate en el corazon de Location</h3>
        <p className="p-hotel-negro">El Médanos Patagonia se encuentra en Las Grutas, a 500 metros de Primeras Bajadas, y ofrece alojamiento con aire acondicionado, wifi gratis y acceso a una terraza.
        <br/>
        Todos los alojamientos incluyen zona de cocina con zona de comedor y heladera, sala de estar con sofá y baño privado con secador de pelo.A las parejas les gusta la ubicación. Le pusieron un puntaje de 9,4 para un viaje de a dos.
        <br/>
        Médanos Patagonia recibe usuarios de Booking.com desde el 30 de mayo de 2018.</p>
    </span>
    <div>
        <h3> Que ofrece este lugar?</h3>
        <div className="servicios-alojamiento">
           <div>
            <i class="icons fa-solid fa-kitchen-set"></i>cocina
            <i class="icons plus fa-solid fa-car"></i> Estacionamiento gratuito
            <i class="icons fa-solid fa-tv"></i> Television
            <i class="icons fa-solid fa-paw"></i> Apto mascotas
            </div>
            <div>
            <i class="icons fa-solid fa-person-swimming"></i>Pileta
            <i class="icons plus fa-solid fa-snowflake"></i>Aire Acondicionado
           <i class="icons fa-solid fa-wifi"></i>WIFI

           </div>
        </div>
        <h3>Que tenes que saber</h3>
        <div className="politicas-alojamiento">
           <div className="politicas-pautas-div">
            <h5>Normas de la casa</h5>
            <p>Check out:10am</p>
            <p>No se permiten fiestas</p>
            <p>No fumar</p>
            </div>
            <div className="politicas-pautas-div">
             <h5>Salud y seguridad</h5>
             <p>Se aplican las pautas de distanciamiento social
                y otras normas relacionadas con el COVID19
             </p>
             <p>Deposito de seguridad</p>
            </div>
            <div className="politicas-pautas-div">
                <h5>Politicas de cancelacion</h5>
                <p>Agrega las fechas de tu viaje para obtener los detalles de cancelacion de esta estadia</p>
            </div>
        </div><h3>Fechas disponibles</h3>
        <div className="datepicker-div">
        
        <DatePicker placeholderText= " CheckIn - CheckOut" selectsRange={true}
                    onChange = {onChangeDateHandler}
                    startDate={startDate}
                    endDate={endDate}
                    monthsShown={2}
                    inline
                    dateFormat="dd MM yyyy"/>

                    <div className="cajaauxiliarfechas">
                        <p>Agrega tus fechas para obtener precios exactos</p>
                        <button>Iniciar reserva</button>
                    </div>
                 
        </div>
    </div>

</div>
    )    
}
export default Alojamiento; 