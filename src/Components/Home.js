import "../Components/Home.css"; 
import NavBar from "../Components/Navbar";
import Buscador from './Buscador';
import Categoria from './Categoria';
import Listado from './Listado';

export default function Home(props) {
    return (
    <div className="home">
        <NavBar/> 
        <Buscador/>
        <Categoria/>
        <Listado/>
    </div>
)}
