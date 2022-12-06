import React from "react";
import { Link } from "react-router-dom";
import { Carousel } from "react-responsive-carousel";
import "../Components/Carrusel.css"; 
import "react-responsive-carousel/lib/styles/carousel.css"; 
import { faHeart, faShareNodes } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";


const Carrusel=({product})=>{
return(
    <main>
        <FontAwesomeIcon icon="fa-sharp fa-solid fa-heart" />
        <FontAwesomeIcon className="iconoscarrusel" icon={faHeart} />
        <FontAwesomeIcon  className="iconoscarrusel" icon={faShareNodes} />
        <div className="principal">
            <div className="img-alone">
                <figure>
                    <img src={product.images[0].url_image} alt={product.images[0].title_image} className="gallery-img"/>
                </figure>
            </div>
            <div className="gallery">
                <figure className="gallery-picture galeria-1">
                    <img src={product.images[1].url_image} alt={product.images[1].title_image} className="gallery-img"/>
                </figure>
                <figure className="gallery-picture galeria-2">
                    <img src={product.images[2].url_image} alt={product.images[2].title_image} className="gallery-img"/>
                </figure>
                
                <figure className="gallery-picture galeria-4">
                    <img src={product.images[3].url_image} alt={product.images[3].title_image} className="gallery-img"/>
                </figure>
                <figure className="gallery-picture galeria-5">
                    <Link to="/CarruselB">
                        <a href="#" target="blank">
                            <img src={product.images[0].url_image} alt={product.images[0].title_image} className="gallery-img "/>
                                <div class="img-text">
                                    Ver Mas
                                </div>
                        </a>
                    </Link>
                </figure>
            </div>
        </div>
        <div className="mobile-slider">
            <Carousel>
                <div><img src={product.images[0].url_image} alt={product.images[0].title_image} className="img-slider"/></div>
                <div><img src={product.images[1].url_image} alt={product.images[1].title_image} className="img-slider"/></div>
                <div><img src={product.images[2].url_image} alt={product.images[2].title_image} className="img-slider"/></div>
                <div><img src={product.images[3].url_image} alt={product.images[3].title_image} className="img-slider"/></div>
            </Carousel>
        </div>
    </main>
)
}
export default Carrusel;
