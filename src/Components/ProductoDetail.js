import React from "react";
import { useState, useEffect } from 'react';
import { Link } from "react-router-dom";
import { useParams } from "react-router-dom";
import axios from "axios";
import "../Components/ProductoDetail.css"; 
import "react-datepicker/dist/react-datepicker.css"; 
import DatePicker from "react-datepicker";
import Carrusel from "./Carrusel";
import CarruselB from "./CarruselB";
import DataList from './dataList.json';

const ProductoDetail=()=>{
    const[startDate, setStartDate] = useState(); 
    const [endDate, setEndDate]= useState(); 
    const[product, setProduct]= useState({})
    const {id} = useParams();

    function onChangeDateHandler(value){
        setStartDate(value[0]); 
        setEndDate(value[1]);
        }   

    const baseUrl = "http://localhost:3000/"


    const getProductById = async(id) => {
        const endpoint = `${baseUrl}producto/${id}`;
        return await axios.get(endpoint);
    }



    useEffect( () => {
        getProductById(id).then( (response) => {
            setProduct(response.data)
            console.log(response.data)
        })
    }, [id])


return(
<div className="main-imagenes">
   <div className="header-hotel">
    <p className="p-hotel">{DataList[id-1].producto.category}
        <h4>{DataList[id-1].producto.title}</h4>
    </p>
    <span className="iconos">
        <Link to="/Home"><i class="flecha fa-solid fa-arrow-left"></i></Link>
    </span>
 </div>
   <div className="infolocation-hotel">
    <p className="p-hotel">
        <i class="ubicacion fa-solid fa-location-dot"></i>
        {DataList[id-1].producto.location}
        <p>{DataList[id-1].producto.description} </p>
    </p>
    <span>
        <h5 className="titleh5aloj">Muy Bueno</h5>
        <i class="puntuacion fa-solid fa-star"></i>
        <i class="puntuacion fa-solid fa-star"></i>
        <i class="puntuacion fa-solid fa-star"></i>
        <i class="puntuacion fa-solid fa-star"></i>

    </span>

   </div> 
    <Carrusel/>
    {/* <CarruselB/> */}
    <span>
        <h3 className="titleh3aloj">Alojate en el corazon de Location</h3>
        <p className="p-hotel-negro">El Médanos Patagonia se encuentra en Las Grutas, a 500 metros de Primeras Bajadas, y ofrece alojamiento con aire acondicionado, wifi gratis y acceso a una terraza.
        <br/>
        Todos los alojamientos incluyen zona de cocina con zona de comedor y heladera, sala de estar con sofá y baño privado con secador de pelo.A las parejas les gusta la ubicación. Le pusieron un puntaje de 9,4 para un viaje de a dos.
        <br/>
        Médanos Patagonia recibe usuarios de Booking.com desde el 30 de mayo de 2018.</p>
    </span>
    <div>
        <h3 className="titleh3aloj"> Que ofrece este lugar?</h3>
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
        <h3 className="titleh3aloj">Que tenes que saber</h3>
        <div className="politicas-alojamiento">
           <div className="politicas-pautas-div">
            <h5>Normas de la casa</h5>
            <p>Check out:10am</p>
            <p>No se permiten fiestas</p>
            <p>No fumar</p>
            </div>
            <div className="politicas-pautas-div">
             <h5 className="titleh5aloj">Salud y seguridad</h5>
             <p>Se aplican las pautas de distanciamiento social
                y otras normas relacionadas con el COVID19
             </p>
             <p>Deposito de seguridad</p>
            </div>
            <div className="politicas-pautas-div">
                <h5 className="titleh5aloj">Politicas de cancelacion</h5>
                <p>Agrega las fechas de tu viaje para obtener los detalles de cancelacion de esta estadia</p>
            </div>
        </div><h3 className="titleh3aloj">Fechas disponibles</h3>
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
export default ProductoDetail; 
