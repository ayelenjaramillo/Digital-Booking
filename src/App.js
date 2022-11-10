import { BrowserRouter, Routes, Route } from "react-router-dom";
import Alojamiento from "./Components/Alojamiento";
import NavBar from "./Components/Navbar";
import Home from "./Components/Home"; 
import Registro from "./Components/Registro"; 
import LogIn from "./Components/LogIn"; 
import MenuPrincLogin from "./Components/MenuPrincLogin"; 
import Footer from "./Components/Footer";
import Avatar from "@material-ui/core/Avatar"; 

import "./App.css"; 
const App = () => {
  
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<NavBar/>}></Route>
          <Route index element = {<Home/>}></Route>
          <Route path="/home" element= {<Home/>}></Route>
<<<<<<< HEAD
          <Route path="/Alojamiento" element={<Alojamiento/>}></Route>
          <Route path="/CarruselB" element={<CarruselB/>}></Route>
          </Route>
=======
          <Route path="/Alojamiento" element= {<Alojamiento/>}></Route>
>>>>>>> silvinasprint2
          <Route path="/Login" element= {<LogIn/>}></Route>
          <Route path="/MenuPrincLogin" element = {<MenuPrincLogin/>}></Route> 
          <Route path="/registro" element = {<Registro/>}></Route>
      </Routes>
      </BrowserRouter>
      {/* <Avatar src="./gatonegro.png" />  */}
    <Footer/>
    </>
  );
};

export default App;

