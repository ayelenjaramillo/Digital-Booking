import React from 'react';
import CardCate from './Card_list';
import './Listado.css';
import Datacate from './dataList.json'

export default function Listado(props) {
    return (
    <div>
        <div>
            <p className='titlelist'>Recomendaciones</p>
        </div>
        <div className='contenedorlist'>
            {Datacate.map((cardcate) => (
            <CardCate 
            key={cardcate.id}
            producto = {cardcate.producto}
            />
        ))}
        </div>
    </div>
)}


