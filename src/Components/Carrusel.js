import React from "react";
import { Link } from "react-router-dom";
import { Carousel } from "react-responsive-carousel";
import "../Components/Carrusel.css"; 
import "react-responsive-carousel/lib/styles/carousel.css"; 
import { faHeart, faShareNodes } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";


const Carrusel=()=>{
return(
    <main>
        <FontAwesomeIcon icon="fa-sharp fa-solid fa-heart" />
        <FontAwesomeIcon className="iconoscarrusel" icon={faHeart} />
        <FontAwesomeIcon  className="iconoscarrusel" icon={faShareNodes} />
        <div className="principal">
       <div className="img-alone">
        <figure>
                <img src="../bed_and_breakfast.jpg" alt="bed_and_breakfast" className="gallery-img"/>
            </figure>
        </div>
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
                        <div class="img-text">
                            Ver Mas
                        </div>
                </a>
            </Link>
            </figure>
        </section>
    </div>
    <div className="mobile-slider">
        <Carousel>
            <div><img src="../Hostel.jpg" className="img-slider"/></div>
            <div><img src="../Hostel.jpg" className="img-slider"/></div>
            <div><img src="../Hotel.jpg" className="img-slider"/></div>
            <div><img src="../bed_and_breakfast.jpg" className="img-slider"/></div>
        </Carousel>
    </div>
    </main>
)
}
export default Carrusel;
