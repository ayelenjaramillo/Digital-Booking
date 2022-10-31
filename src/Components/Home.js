import "react-datepicker/dist/react-datepicker.css"; 
import DatePicker from "react-datepicker";
import "../Components/Home.css"; 
import React, { useState} from 'react';
import Categoria from './Categoria';
import Listado from './Listado';


const Home =()=>{
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
            <h2>Busca ofertas en hoteles, casas y mucho mas</h2>
            <div className="h-sec">
                <select name="ciudad">
                    <option>Trelew, Chubut, Argentina</option>
                    <option>Rio Cuarto, Cordoba, Argentina</option>
                    <option>Capital Federal, Buenos Aires, Argentina</option>
                    <option>Villa La Angostura, Neuquen, Argentina</option>
                </select>
               
                <DatePicker placeholderText="CheckIn - CheckOut" selectsRange={true}
                    onChange = {onChangeDateHandler}
                    startDate={startDate}
                    endDate={endDate}
                    dateFormat="dd MM yyyy"/>
                <button className = "boton-principal"type="submit"> BUSCAR </button>
                
            </div>
        </form>
        </div>
        <Categoria/>
        <Listado/>
    </div>

)
   }; 
export default Home; 