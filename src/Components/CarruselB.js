import "../Components/CarruselB.css"; 
const CarruselB =()=>{
    return(
        <div className="div-caruselB">
        <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active" data-bs-interval="3000">
            <img src="./Hotel.jpg" class="d-block w-100"/>
          </div>
          <div class="carousel-item" data-bs-interval="3000">
            <img src="./bed_and_breakfast.jpg" class="d-block w-100" />
          </div>
          <div class="carousel-item"  data-bs-interval="3000">
            <img src="./Hostel.jpg" class="d-block w-100"/>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
      <p className="parrafo-carrusel"> 1/? </p>
      <div className="contenedor-menor">
      {/* <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="./Hotel.jpg" class="d-block w-100" alt="..."/>
    </div>
    <div class="carousel-item">
      <img src="./bed_and_breakfast.jpg" class="d-block w-100" alt="..."/>
    </div>
    <div class="carousel-item">
      <img src="./Hostel.jpg" class="d-block w-100" alt="..."/>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div> */}




        <figure className="figure-carrusel">
          <img src="./bed_and_breakfast.jpg" className="gallery-img"/>
        </figure>
        <figure className="figure-carrusel">
          <img src="./Hostel.jpg" className="gallery-img"/>
        </figure>
        <figure className="figure-carrusel">
          <img src="./bed_and_breakfast.jpg" className="gallery-img"/>
        </figure>
        <figure className="figure-carrusel">
          <img src="./Hotel.jpg" className="gallery-img"/>
        </figure>
      
      </div>
      </div>
    )
}
export default CarruselB; 