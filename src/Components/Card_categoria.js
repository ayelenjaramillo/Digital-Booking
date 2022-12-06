import React from 'react';
import { Link } from 'react-router-dom';
import './Card_categoria.css'

export default function Card_categoria( {card} ) {

    return (
        <div >
            <div className='card'>
                <img alt={card.title} src={card.image_url}></img>
                <div className='rightproductdetails'>
                    <p><Link to="/alojamiento">{card.title}</Link> </p>
                    <p>{card.description} </p>
                </div>
            </div>
        </div>
    )
}
