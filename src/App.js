import { BrowserRouter, Routes, Route } from "react-router-dom";
import NavBar from "./Components/Navbar";
import Home from "./Components/Home"; 
import Registro from "./Components/Registro"; 
import LogIn from "./Components/LogIn"; 
import Footer from "./Components/Footer";

import "./App.css"; 
const App = () => {
  
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<NavBar/>}>
          <Route index element = {<Home/>}></Route>
          <Route path="/home" element= {<Home/>}></Route>
          <Route path="/Login" element= {<LogIn/>}></Route>
          <Route path="/registro" element = {<Registro/>}></Route>
          </Route>
        </Routes>
      </BrowserRouter>
    <Footer/>
    </>
  );
};
export default App;