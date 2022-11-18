import "../Components/Reserva.css"
import NavBar from "./Navbar";
import "react-datepicker/dist/react-datepicker.css"; 
import DatePicker from "react-datepicker";
import React from "react";
import axios from "axios";
import { useState, useEffect, useParams } from "react";
import DataList from './dataList.json';


const Reserva = () =>{
    const[startDate, setStartDate] = useState(); 
    const [endDate, setEndDate]= useState();
    

    function onChangeDateHandler(value){
        setStartDate(value[0]); 
        setEndDate(value[1]);
        }   
    return(
    <div>
        <div>
            <DatePicker placeholderText= " CheckIn - CheckOut" selectsRange={true}
                    onChange = {onChangeDateHandler}
                    startDate={startDate}
                    endDate={endDate}
                    monthsShown={2}
                    inline
                    dateFormat="dd MM yyyy"/>
        
            <p> Tu horario de llegada </p>
             <div> 
            <figure><i class="fa-solid fa-circle-check"></i> Tu habitacion va a estar lista para el check-in entre las 10.00AM y las 11.30PM</figure>
            <p> Inclui tu horario estimado de llegada</p>
            <select>
                <option> 10:00 AM</option>
                <option> 12:00 AM</option>
                <option> 14:00 PM</option>
                <option> 16:00 AM</option>
                <option> 18:00 AM</option>
            </select>
            </div> 
            <div>
            <span>
                <i class="puntuacion fa-solid fa-star"></i>
                <i class="puntuacion fa-solid fa-star"></i>
                <i class="puntuacion fa-solid fa-star"></i>
                <i class="puntuacion fa-solid fa-star"></i>
                <i style={{color: "#CBCBCF"}} class="puntuacion fa-solid fa-star"></i>
            </span>
            <span>
            <i class="ubicacion fa-solid fa-location-dot"></i>
            </span>
            <p>{null}</p>
            <p> Check In:</p>
            <p>Check Out: </p>
            </div> 
        </div>
    </div>
    )
}
export default Reserva; 