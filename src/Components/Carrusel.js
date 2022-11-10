import React from "react";
import { Link } from "react-router-dom";
import "../Components/Carrusel.css"; 
const Carrusel=()=>{
return(
    <main>
        <i class="iconoscarrusel fa-solid fa-share-nodes"></i>
        <i class="iconoscarrusel fa-regular fa-heart"></i>
        <div className="principal">
       <section className="img-alone">
        <figure>
                <img src="../bed_and_breakfast.jpg" alt="bed_and_breakfast" className="gallery-img"/>
            </figure>
        </section>
        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
        <section className="gallery">
            <figure className="gallery-picture galeria-1">
                <img src="../Hostel.jpg" alt="Hostel" className="gallery-img"/>
            </figure>
            <figure className="gallery-picture galeria-2">
                <img src="../bed_and_breakfast.jpg" alt="bed_and_breakfast" className="gallery-img"/>
            </figure>
            
            <figure className="gallery-picture galeria-4">
                <img src="../Hotel.jpg" alt="Hotel" className="gallery-img"/>
            </figure>
            <figure className="gallery-picture galeria-5">
            <Link to="/CarruselB">
                <a href="#" target="blank">
                <img src="../Hostel.jpg" alt="Hostel" className="gallery-img "/>
                <div class="img-text">Ver Mas </div></a></Link>
            </figure>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
        </section>
        </div>
        </div>
    </main>
)
}
export default Carrusel;
