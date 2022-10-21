import {Link, Outlet} from "react-router-dom"; 
import Componente from "../assets/Componente.png"; 

const NavBar =()=> {
    return(
<>

<ul>
  <li><Link to="/Home"><img className="image" src={Componente}/></Link></li>
  <li><Link to = "/LogIn"> LogIn </Link></li>
  <li><Link to ="/Registro"> Registro </Link></li>
</ul>
  
<Outlet/>
</>
    )
}; 
export default NavBar; 