
import FB from "../assets/FB.png"; 
import IG from "../assets/IG.png";
import LINKEDIN from "../assets/LINKEDIN.png";
import logo from "../assets/logo.png"; 



const Footer =() =>(
    <div className="footer"> 
    <ul>
        <li className="list"><img className="image" src={logo}/></li> 
        <li className="list"><a href="#"><img className="image"src={FB}/></a></li>
        <li className="list"><a href="#"><img className="image"src ={IG}/></a></li>
        <li className="list"><a href="#"><img className="image" src ={LINKEDIN}/></a></li>
    </ul>
    </div>); 
  

export default Footer; 