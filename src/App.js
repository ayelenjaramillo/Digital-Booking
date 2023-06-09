import { BrowserRouter, Routes, Route } from "react-router-dom";
// import Alojamiento from "./Components/Alojamiento";
import NavBar from "./Components/Navbar";
import Home from "./Components/Home"; 
import Registro from "./Components/Registro"; 
import LogIn from "./Components/LogIn"; 
import MenuPrincLogin from "./Components/MenuPrincLogin"; 
import Footer from "./Components/Footer";
import ProductoDetail from "./Components/ProductoDetail";
import Avatar from "@material-ui/core/Avatar"; 
import "./App.css"; 
import CarruselB from "./Components/CarruselB";
import Reserva from "./Components/Reserva";
import ConfirmacionReserva from "./Components/ConfirmacionReserva";
import AdministradorTemplate from "./Components/AdministradorTemplate"; 
const App = () => {
  
  return (
    <>
      <BrowserRouter>
        <NavBar/>
        <Routes>
          <Route path="/" element={<Home/>}></Route>
          {/* <Route index element = {<Home/>}></Route>
          <Route path="/home" element= {<Home/>}></Route> */}
          {/* <Route path="/Alojamiento" element= {<Alojamiento/>}></Route> */}
          <Route path="/CarruselB" element={<CarruselB/>}></Route>
          <Route path="/Login" element= {<LogIn/>}></Route>
          <Route path="/MenuPrincLogin" element = {<MenuPrincLogin/>}></Route> 
          <Route path="/registro" element = {<Registro/>}></Route>
          <Route path="/producto/:id" element= {<ProductoDetail/>} ></Route> 
          <Route path="/Reserva" element = {<Reserva/>}></Route>
          <Route path="/ConfirmacionReserva" element= {<ConfirmacionReserva/>}></Route>
          <Route path="/AdministradorTemplate" element= {<AdministradorTemplate/>}></Route>
        </Routes>
      </BrowserRouter>
      <Footer/>
    </>
  );
};

export default App;

