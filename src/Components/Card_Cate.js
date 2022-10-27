import React from 'react';
import "./Card_Cate.css";

const Card = ({categoria}) => {


return (
    <div className='main'>
        <div className='imagen_cate'>
            <img alt={categoria.titulo} src={categoria.url_imagen}/>
        </div>
        <div className='detalle'>
            <h3>{categoria.titulo} </h3>
        </div>
    </div>
)}

export default Card