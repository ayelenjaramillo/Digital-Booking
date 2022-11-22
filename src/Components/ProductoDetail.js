import React from "react";
import { useState, useEffect } from 'react';
import { Link } from "react-router-dom";
import { useParams } from "react-router-dom";
import axios from "axios";
import "../Components/ProductoDetail.css"; 
import "react-datepicker/dist/react-datepicker.css"; 
import DatePicker from "react-datepicker";
import Carrusel from "./Carrusel";
import DataList from './dataList.json';
import Spinner from "./Spinner";
import { faLocationDot, faAngleLeft, faStar} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";


const ProductoDetail=()=>{
    const[startDate, setStartDate] = useState(); 
    const [endDate, setEndDate]= useState(); 
    const [product, setProduct] = useState({})
    const [isLoading, setIsLoading] = useState(true);
    const {id} = useParams();

    console.log("PRODUCTO ES " + product)

    function onChangeDateHandler(value){
        setStartDate(value[0]); 
        setEndDate(value[1]);
        }   

    const baseUrl = "http://localhost:8080/"


    const getProductById = async (id) => {
        const endpoint = `${baseUrl}products/${id}`;
        return await axios.get(endpoint);
    }



    useEffect( () => {
        getProductById(id).then( (response) => {
            setProduct(response.data)

            console.log(response.data?.title)

            console.log("Response")
            console.log(response)
            console.log("Response Data")
            console.log(response.data)
            console.log("PRODUCTO")
            console.log(product)
            console.log("RRESPONSE CATEGORY TITLE")
            console.log(response.data.category.title)
            console.log("RESPONSE TITLE")
            console.log(response.data.title)

            

        }).catch((error) => {
            console.log(error)
        })

        setTimeout(() => {
            setIsLoading(false);
        }, 1000)


    }, [id])

    // useEffect(() => {
    //     setIsLoading(false);
    //     console.log("DESDE 2do useEffect. Product.title")
    //     console.log(product)
    //     console.log(product?.title)
    //     console.log("PRODUCTO CATEGORY TITLE")
    //     console.log(product.category.title)
    //     console.log("PRODUCTO TITLE")
    //     console.log(product.title)

    // }, [product])



return(
<div className="main-imagenes">
    
    <div className="header-hotel">
    <p className="p-hotel"> { isLoading ?  <Spinner />  : product.category.title}
        <h4>{isLoading ?  <Spinner />  : product.title}</h4>
    </p>
    <span className="iconos">
        <Link to="/"><FontAwesomeIcon className="flecha" icon={faAngleLeft} /></Link>
    </span>
    
    </div>
   <div className="infolocation-hotel">
        <p className="p-hotel">
        <FontAwesomeIcon className="ubicacion" icon={faLocationDot} />
            { isLoading ?  <Spinner />  : (<span>{product.city.city_name}, {product.city.country} </span> )}
            <p>{ isLoading ?  <Spinner />  : product.description} </p>
        </p>
    <span>
        <h5 className="titleh5aloj">Muy Bueno</h5>
        <div className="estrellas">
        <FontAwesomeIcon className="puntuacion" icon={faStar} />
        <FontAwesomeIcon className="puntuacion" icon={faStar} />
        <FontAwesomeIcon className="puntuacion" icon={faStar} />
        <FontAwesomeIcon className="puntuacion" icon={faStar} />
        <FontAwesomeIcon style={{color: "#CBCBCF"}} className="puntuacion" icon={faStar} />
        </div>
    </span>
    
    </div> 
        <Carrusel/>
        {/* <CarruselB/> */}
    <span>
        <h3 className="titleh3aloj">Alojate en el corazon de Location</h3>
        <p className="p-hotel-negro">El Médanos Patagonia se encuentra en Las Grutas, a 500 metros de Primeras Bajadas, y ofrece alojamiento con aire acondicionado, wifi gratis y acceso a una terraza.
        Todos los alojamientos incluyen zona de cocina con zona de comedor y heladera, sala de estar con sofá y baño privado con secador de pelo.A las parejas les gusta la ubicación. Le pusieron un puntaje de 9,4 para un viaje de a dos.
        Médanos Patagonia recibe usuarios de Booking.com desde el 30 de mayo de 2018.</p>
    </span>
    <div>
        <h3 className="titleh3aloj"> Que ofrece este lugar?</h3>
        <hr style={{color: "#1DBEB4", background: "#1DBEB4", opacity: 20}}></hr>
        <div className="servicios-alojamiento">
            <figure><i class="icons fa-solid fa-kitchen-set"></i>Cocina</figure>
            <figure><i class="icons plus fa-solid fa-car"></i> Parking</figure>
            <figure><i class="icons fa-solid fa-tv"></i> Television</figure>
            <figure><i class="icon fa-solid fa-paw"></i> Apto mascotas</figure>
            <figure><i class="icons fa-solid fa-person-swimming"></i>Pileta</figure>
            <figure style={{width: 300}}><i class="icons plus fa-solid fa-snowflake"></i>Aire Acondicionado</figure>
            <figure><i class="icons fa-solid fa-wifi"></i>WIFI</figure>
        </div>
        <h3 className="titleh3aloj">Que tenes que saber</h3>
        <hr style={{color: "#1DBEB4", background: "#1DBEB4", opacity: 20}}></hr>
        <div className="politicas-alojamiento">
           <div className="politicas-pautas-div">
            <h5 className="titleh5aloj">Normas de la casa</h5>
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
        </div>
        <hr style={{color: "#1DBEB4", background: "#1DBEB4", opacity: 20}}></hr>
        <div className="map_location">
        <img src="../map.jpg" alt="map_location" className="map-img"/>
        <h3 className="titleh3aloj">Fechas disponibles</h3>
        
        <div className="datepicker-div">
        <DatePicker placeholderText= " CheckIn - CheckOut" selectsRange={true}
                    onChange = {onChangeDateHandler}
                    startDate={startDate}
                    endDate={endDate}
                    monthsShown={2}
                    inline
                    dateFormat="dd MM yyyy"/>

        <div className="cajaauxiliarfechas">
            <p style={{"font-weight":"bold"}}>Agrega tus fechas para obtener precios exactos</p>
            <Link to="/Reserva">
                <button style={{"font-weight":"bold"}}>Iniciar reserva</button>
            </Link></div>
        </div>
        </div>
    </div>

</div>
    )    
} 

export default ProductoDetail; 
