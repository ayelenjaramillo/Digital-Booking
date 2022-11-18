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
    )
}
export default CarruselB; 
