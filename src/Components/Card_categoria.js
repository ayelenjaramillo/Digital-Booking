import React from 'react';
import { Link } from 'react-router-dom';
import './Card_categoria.css'

export default function Card_categoria(props) {

return (
    <div >
        <div className='card'>
            <img alt={props.card.titulo} src={props.card.url_imagen}></img>
            <div className='rightproductdetails'>
                <p><Link to="/alojamiento">{props.card.titulo}</Link> </p>
                <p>{props.card.descripcion} </p>
            </div>
        </div>
    </div>
)}







// export default function Card(props) {

//     return (
//         <div className='container'>
//             <div className='card'>
//                 <img alt={props.producto.nombre} src={props.producto.img}></img>
//                 <div className='rightproductdetails'>
//                     <p>{props.producto.category} </p>
//                     <h3>{props.producto.title} </h3>
//                     <p>{props.producto.location} </p>
//                     <p>{props.producto.description} </p>
//                     <button>Ver más/Ver detalle</button>
//                 </div>
//             </div>
//         </div>
//     )}