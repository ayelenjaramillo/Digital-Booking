import React from 'react';
import { Link } from 'react-router-dom';
import "./Card_list.css";
import {RiStarSFill} from 'react-icons/ri';
import {IoLocationSharp} from 'react-icons/io5';
import {BiWifi, BiSwim} from 'react-icons/bi';



export default function Card_list( {id, title, image, cat, des} ) {
    let idProd = `/producto/${id}`

return (
    <div>
        <div className='cardlist'>
            <img className='imagelist' alt={title} src={image}></img>
            <div className='rightproductdetailslist'>
                <p>{cat}<RiStarSFill/><RiStarSFill/><RiStarSFill/><RiStarSFill/><RiStarSFill/></p>
                <p>{title}</p>
                <p><IoLocationSharp/> {title}</p>
                <p><BiWifi/><BiSwim/></p>
                <p>{des} </p>
                <button ><Link to={idProd}>Ver más</Link></button>
                
            </div>
        </div>
    </div>
)}