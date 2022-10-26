import ReactDatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css"; 
import "../Components/Home.css"; 
import React, { useState} from 'react';

const Home =()=>{
    const[date, setDate] = useState(new Date()); 
    return(
        <div className="h-principal">
         <form> 
            <h2>Busca ofertas en hoteles, casas y mucho mas</h2>
                 <div className="h-sec">
                    <select name="ciudad">
                        <option>Chubut</option>
                        <option>Cordoba</option>
                        <option>Buenos Aires</option>
                        <option>Neuquen</option>
                    </select>
                    <ReactDatePicker selected={date}  onChange={(date: Date)=>{
                    setDate(date); 
                    console.log(date); 
                        }}/>
                        <button type="submit">BUSCAR </button>
                  </div>
            </form>
        </div>
)
   }; 
export default Home; 