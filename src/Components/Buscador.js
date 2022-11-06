import "react-datepicker/dist/react-datepicker.css"; 
import DatePicker from "react-datepicker";
import "../Components/Buscador.css"; 
import React, { useState} from 'react';


const Buscador =()=>{
const[startDate, setStartDate] = useState(); 
const [endDate, setEndDate]= useState(); 
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
                <select name="ciudad">
                    <option disabled selected hidden >A dónde vamos?</option>
                    <option>Trelew, Chubut, Argentina</option>
                    <option>Rio Cuarto, Cordoba, Argentina</option>
                    <option>Capital Federal, Buenos Aires, Argentina</option>
                    <option>Villa La Angostura, Neuquen, Argentina</option>
                </select>
                <DatePicker placeholderText="Check in - Check out" selectsRange={true}
                    onChange = {onChangeDateHandler}
                    startDate={startDate}
                    endDate={endDate}
                    dateFormat="dd MM yyyy"/>
                <button className = "boton-principal"type="submit"> Buscar </button>
            </div>
        </form>
        </div>

    </div>

)
   }; 
export default Buscador; 