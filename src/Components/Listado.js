import React from 'react';
import Card from './Card';
import Data from './data.json';
import './Listado.css';

export default function Listado(props) {
    return (
    <div >
        <div>
            <h2 className='title'>Recomendaciones</h2>
        </div>
        <div className='container'>
            {Data.map((card) => (
            <Card 
            key={card.id}
            producto = {card.producto}
            />
        ))}
        </div>
    </div>
)}

