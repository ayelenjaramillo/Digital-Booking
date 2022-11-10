import React from 'react';
import "./Card_list.css";
import {RiStarSFill} from 'react-icons/ri';
import {IoLocationSharp} from 'react-icons/io5';
import {BiWifi, BiSwim} from 'react-icons/bi';



export default function Card_list(props) {

return (
    <div>
        <div className='cardlist'>
            <img className='imagelist' alt={props.producto.nombre} src={props.producto.img}></img>
            <div className='rightproductdetailslist'>
                <p>{props.producto.category}<RiStarSFill/><RiStarSFill/><RiStarSFill/><RiStarSFill/><RiStarSFill/></p>
                <p>{props.producto.title}</p>
                <p><IoLocationSharp/> {props.producto.location}</p>
                <p><BiWifi/><BiSwim/></p>
                <p>{props.producto.description} </p>
                <button>Ver más</button>
            </div>
        </div>
    </div>
)}

// const Card = ({categoria}) => {


// return (
//     <div className='main'>
//         <div className='imagen_cate'>
//             <img alt={categoria.titulo} src={categoria.url_imagen}/>
//         </div>
//         <div className='detalle'>
//             <h3>{categoria.titulo} </h3>
//             <h4>{categoria.location}</h4>
//         </div>
//     </div>
// )}

// export default Card