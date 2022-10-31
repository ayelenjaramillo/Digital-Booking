
import FB from "../assets/FB.png"; 
import IG from "../assets/IG.png";
import LINKEDIN from "../assets/LINKEDIN.png";
import logo from "../assets/logo.png"; 
import './Footer.css';


const Footer =() =>(
    <div className="footer"> 
        <p className="f-p-text">© 2021 Digital Booking</p> 
        <ul className="f-list">
            <li className="list"><a href="#"><img className="image"src={FB} alt="fb"/></a></li>
            <li className="list"><a href="#"><img className="image"src ={IG} alt="ig"/></a></li>
            <li className="list"><a href="#"><img className="image" src ={LINKEDIN} alt="linke"/></a></li>
        </ul>
    </div>); 


export default Footer; 