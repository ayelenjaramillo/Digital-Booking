import "react-datepicker/dist/react-datepicker.css"; 
import DatePicker from "react-datepicker";
import "../Components/Buscador.css"; 
import React, { useState } from 'react';
import axios from "axios";



const Buscador =()=>{
const[startDate, setStartDate] = useState(); 
const [endDate, setEndDate]= useState(); 
const [ciudades, setCiudades] = useState([])
const [elegirCiudad, serElegirCiudad] = useState(true)

const baseUrl = "http://localhost:8080/api/v1"

const buscarCiudades = async () => {
    try {
        const res = await axios.get(`${baseUrl}/city`)
        setCiudades(res.data);
        console.log("RES DATA")
        console.log(res.data)
        serElegirCiudad(false)
    } catch (err) {
        console.log(err);
    }
};


function onChangeDateHandler(value){
    setStartDate(value[0]); 
    setEndDate(value[1]);
    }

    





return(
    <div>
        <div className="h-principal">
        <form> 
            <p>Busca ofertas en hoteles, casas y mucho más</p>
            <div className="h-sec">
            {/* VER ESTO CON WIN PORQUE TENEMOS QUE ELIMINAR EL SELECT Y CAMBIARLO POR UN INPUT<input placeholder= "A donde vamos?"></input> */}
                <select  className="fontAwesome" name="ciudad" onClick={ () => buscarCiudades()}>
                    {/* <option disabled selected hidden >A dónde vamos?</option>
                    <option>Trelew, Chubut, Argentina</option>
                    <option>Rio Cuarto, Cordoba, Argentina</option>
                    <option>Capital Federal, Buenos Aires, Argentina</option>
                    <option>Villa La Angostura, Neuquen, Argentina</option> */}

                    {elegirCiudad ? <option className="fa" disabled selected hidden >&#xf3c5; A dónde vamos?</option> : (  ciudades.map(e => (
                        <option key={e.id} value={e.i}>{e.city_name}</option>
                    )
                    ) ) }
                </select>
                <DatePicker className="fontAwesome" placeholderText="&#xf783; Check in - Check out" selectsRange={true}
                    onChange = {onChangeDateHandler}
                    monthsShown={2}
                    startDate={startDate}
                    endDate={endDate}
                    dateFormat="dd/MM/yyyy"/>
                    
                <button className = "boton-principal"type="submit"> Buscar </button>
            </div>
        </form>
        </div>

    </div>

)
   }; 
export default Buscador; 