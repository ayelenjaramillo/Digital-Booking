import React from 'react';
import { Link } from 'react-router-dom';
import "./Card_Cate.css";

const Card = ({categoria}) => {


return (
    <div className='main'>
        <div className='imagen_cate'>
            <img alt={categoria.titulo} src={categoria.url_imagen}/>
        </div>
        <div className='detalle'>
            <h3><Link to="/alojamiento">{categoria.titulo}</Link> </h3>
            <h4>{categoria.location}</h4>
        </div>
    </div>
)}

export default Card