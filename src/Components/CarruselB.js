import { Carousel } from "react-responsive-carousel";
import "../Components/CarruselB.css"; 
import "react-responsive-carousel/lib/styles/carousel.css"; 
import NavBar from "../Components/Navbar"; 

const CarruselB =()=>{
    return(
      <>
      <NavBar/> 
      <Carousel className="main-slider">
        <div>
        <img src="./Hotel.jpg"className="img-slider"/>
        </div>
        <div>
        <img src="./Hostel.jpg" className="img-slider"/>
        </div>
        <div>
        <img src="./Hotel.jpg" className="img-slider"/>
        </div>
        <div>
        <img src="./bed_and_breakfast.jpg" className="img-slider"/>
        </div>
      </Carousel>
      
      </>
      //   <div className="div-caruselB">
      //   <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
      //   <div class="carousel-inner">
      //     <div class="carousel-item active" data-bs-interval="3000">
      //       <img src="./Hotel.jpg" class="d-block w-100"/>
      //     </div>
      //     <div class="carousel-item" data-bs-interval="3000">
      //       <img src="./bed_and_breakfast.jpg" class="d-block w-100" />
      //     </div>
      //     <div class="carousel-item"  data-bs-interval="3000">
      //       <img src="./Hostel.jpg" class="d-block w-100"/>
      //     </div>
      //   </div>
      //   <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
      //     <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      //     <span class="visually-hidden">Previous</span>
      //   </button>
      //   <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
      //     <span class="carousel-control-next-icon" aria-hidden="true"></span>
      //     <span class="visually-hidden">Next</span>
      //   </button>
      // </div>
      // <p className="parrafo-carrusel"> 1/? </p>
      // <div className="contenedor-menor">
      //   <figure className="figure-carrusel">
      //     <img src="./bed_and_breakfast.jpg" className="gallery-img"/>
      //   </figure>
      //   <figure className="figure-carrusel">
      //     <img src="./Hostel.jpg" className="gallery-img"/>
      //   </figure>
      //   <figure className="figure-carrusel">
      //     <img src="./bed_and_breakfast.jpg" className="gallery-img"/>
      //   </figure>
      //   <figure className="figure-carrusel">
      //     <img src="./Hotel.jpg" className="gallery-img"/>
      //   </figure>
      
      // </div>
      // </div>
    )
}
export default CarruselB; 
