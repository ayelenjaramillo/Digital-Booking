import React from "react";
import "../Components/Carrusel.css"; 
const Carrusel=()=>{
return(
    <main>
        <h1 className="title">Galleria de imagenes</h1>
        <div className="principal">
        <section className="img-alone">
        <figure>
                <img src="./bed_and_breakfast.jpg" className="gallery-img"/>
            </figure>
        </section>
        <section className="gallery">
            <figure className="gallery-picture galeria-1">
                <img src="./Hostel.jpg" className="gallery-img"/>
            </figure>
            <figure className="gallery-picture galeria-2">
                <img src="./bed_and_breakfast.jpg" className="gallery-img"/>
            </figure>
            
            <figure className="gallery-picture galeria-4">
                <img src="./Hotel.jpg" className="gallery-img"/>
            </figure>
            <figure className="gallery-picture galeria-5">
                <img src="./Hostel.jpg" className="gallery-img"/>
            </figure>
        </section></div>
    </main>
)
}
export default Carrusel;