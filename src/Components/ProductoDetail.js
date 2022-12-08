import React from "react";
import { useState, useEffect } from 'react';
import { Link } from "react-router-dom";
import { useParams } from "react-router-dom";
import axios from "axios";
import "../Components/ProductoDetail.css"; 
import "react-datepicker/dist/react-datepicker.css"; 
import DatePicker from "react-datepicker";
import Carrusel from "./Carrusel";
import Spinner from "./Spinner";
import { faLocationDot, faAngleLeft, faStar, faCar, faTv, faPaw, faPersonSwimming, faSnowflake, faWifi, faKitchenSet, faBathtub, faDumbbell, faSpa, faLock, faCutlery, faClock} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useNavigate } from "react-router-dom";


const ProductoDetail=()=>{
    const navigate = useNavigate();
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

    const baseUrl = "http://localhost:8080/api/v1/"

    
    const getProductById = async (id) => {
        const endpoint = `${baseUrl}product/${id}`;
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
        }, 3000)


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
                    <p>{ isLoading ?  <Spinner />  : product.address} </p>
                </p>
                <div className="rating-general-producto">
                    <span>
                    <p className="titleh5aloj">Muy bueno</p>
                    <div className="estrellas">                    
                        <FontAwesomeIcon className="puntuacion" icon={faStar} />
                        <FontAwesomeIcon className="puntuacion" icon={faStar} />
                        <FontAwesomeIcon className="puntuacion" icon={faStar} />
                        <FontAwesomeIcon className="puntuacion" icon={faStar} />
                        <FontAwesomeIcon style={{color: "#CBCBCF"}} className="puntuacion" icon={faStar} />
                    </div>
                </span>
                {/* DARLE FORMATO AL SPAN DE ABAJO. VA AL LADO DEL MUY BUENO Y LAS ESTRELLAS, CON FONDO AZUL */}
                <button className="rating-product">{ isLoading ? <Spinner />  : product.rating}</button>
                </div>
                
            
            </div> 
            {isLoading ? <Spinner /> : <Carrusel product={product}/>}
            {/* <CarruselB/> */}
            <span>
                <h3 className="titleh3aloj">{ isLoading ? <Spinner />  : product.description_title}</h3>
                <p className="p-hotel-negro">{ isLoading ? <Spinner />  : product.description}</p>
            </span>
            <div>
                <h3 className="titleh3aloj"> Que ofrece este lugar?</h3>
                <hr style={{color: "#1DBEB4", background: "#1DBEB4", opacity: 20}}></hr>
                <div className="servicios-alojamiento">

                    {isLoading ? <Spinner /> : 
                    (product.features.map((f) => {
                        let variable = f.icon
                        return <><FontAwesomeIcon className="icons" icon={variable} /> <span>{f.description}</span></>
                    })

                    )}



                    {/* {isLoading ? <Spinner /> : <figure><FontAwesomeIcon className="icons" icon={product.features[0].icon} />{product.features[0].description}</figure>} */}
                    {/* <figure><FontAwesomeIcon className="icons" icon={faCar} />Parking</figure>
                    <figure><FontAwesomeIcon className="icons" icon={faTv} /> Television</figure>
                    <figure><FontAwesomeIcon className="icons" icon={faPaw} />Apto Mascotas</figure>
                    <figure><FontAwesomeIcon className="icons" icon={faPersonSwimming} /> Pileta</figure>
                    <figure style={{width: 300}}><FontAwesomeIcon className="icons" icon={faSnowflake} /> Aire Acondicionado </figure>
                    <figure><FontAwesomeIcon className="icons" icon={faWifi} /> WI FI </figure> */}
                </div>
                <h3 className="titleh3aloj">Que tenes que saber</h3>
                <hr style={{color: "#1DBEB4", background: "#1DBEB4", opacity: 20}}></hr>
                <div className="politicas-alojamiento">
                    <div className="politicas-pautas-div">
                        <h5 className="titleh5aloj">Normas de la casa</h5>
                        <p>{ isLoading ? <Spinner />  : product.policy.documentation}</p>
                    </div>
                    <div className="politicas-pautas-div">
                        <h5 className="titleh5aloj">Salud y seguridad</h5>
                        <p>Se aplican las pautas de distanciamiento social
                            y otras normas relacionadas con el COVID19
                        </p>
                        <p>Deposito de seguridad: { isLoading ? <Spinner />  : product.policy.penalty_fee}</p>
                    </div>
                    <div className="politicas-pautas-div">
                        <h5 className="titleh5aloj">Politicas de cancelacion</h5>
                        <p>Agrega las fechas de tu viaje para obtener los detalles de cancelacion de esta estadia</p>
                    </div>
                </div>
                <hr style={{color: "#1DBEB4", background: "#1DBEB4", opacity: 20}}></hr>
                <div className="map_location">
                    {/* <img src="../map.jpg" alt="map_location" className="map-img"/> */}
                    <h3 className="titleh3aloj">Fechas disponibles</h3>
                    
                    <div className="datepicker-div">
                        <DatePicker placeholderText= " CheckIn - CheckOut" selectsRange={true}
                                    onChange = {onChangeDateHandler}
                                    startDate={startDate}
                                    endDate={endDate}
                                    monthsShown={2}
                                    inline
                                    dateFormat="dd MM yyyy"
                        />

                        <div className="cajaauxiliarfechas">
                            <p className= "p-reservasprod">Agrega tus fechas para obtener precios exactos</p>
                            <Link to="/LogIn">
                                <button className="boton-iniciar-reserva">Iniciar reserva</button>
                            </Link>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    )    
} 

export default ProductoDetail; 
