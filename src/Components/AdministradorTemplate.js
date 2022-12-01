import React from "react";
import "../Components/AdministradorTemplate.css"; 
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faAngleLeft, faSquarePlus} from "@fortawesome/free-solid-svg-icons";
const AdministradorTemplate = ()=>{
    return(
        <div>
             <div className="header-administrador">
            <span>
                <h2>Administracion</h2>
            </span>
               <span> <Link to="/"><FontAwesomeIcon  className="flecha-adm"    icon={faAngleLeft}/></Link>
            </span>
            </div>
            <div className="crear-propiedad-span">
            <h3 className="titulos-adm"> Crear Propiedad </h3>
            </div>
            <div className="contenedor-general">
            <div className="container-adm">
                <label className="subtitulos-adm"> Nombre de la propiedad 
                <input className="input-adm" placeholder="Hermirage Hotel"/></label>
                <label className="subtitulos-adm"> Categoria 
                    <select className="input-adm">
                        <option>Hotel</option>
                        <option>Hostel</option>
                        <option>B&B</option>
                        <option>Cabana</option>
                    </select></label>
                <label className="subtitulos-adm"> Direccion 
                <input className="input-adm" placeholder="Av. Colon 5989"/></label>
                <label className="subtitulos-adm"> Ciudad 
                    <select className="input-adm">
                        <option> Trelew, Chubut </option>
                        <option> Rio Cuarto, Cordoba </option>
                        <option> Puerto Madero, Buenos Aires </option>
                        <option> Epuyen, Chubut </option>
                    </select></label>
                <label className="subtitulos-adm"> Descripcion
                    <textarea className="input-adm textarea" placeholder="Escriba aqui"/></label>
            </div>
        <h4 className="titulos-adm"> Agregar atributos </h4>
            <div className="general-plus">
            <div className="container-adm2">
            <label className="subtitulos-adm"> Nombre </label>
            <input className="input" placeholder="Agregar atributo del producto"/>
            <label className="subtitulos-adm"> Icono </label>
            <input className="input" placeholder="Agregar icono"/></div>
            <div className="icono-plus">
            <FontAwesomeIcon className="icono-gral-atrib " icon={faSquarePlus}/>
            </div>
            </div>
          <h4 className="titulos-adm"> Politicas de producto</h4>
            <div className="politicas-div-adm">
                <div className="descripcion-adm">
                <div className="div">
                <h5>Normas de la casa </h5>
                <h5  className="descripcion-adm"> Descripcion</h5 >
                <textarea className="textarea-adm" placeholder="Escriba aqui"/>
                </div>
                <div className="div">
                <h5> Salud y seguridad  </h5>
                <h4  className="descripcion-adm"> Descripcion</h4>
                <textarea className="textarea-adm" placeholder="Escriba aqui"/>
                </div>
                <div className="div">
                <h5> Politicas de cancelacion</h5>
                <h4  className="descripcion-adm"> Descripcion</h4>
                <textarea className="textarea-adm" placeholder="Escriba aqui"/>
                </div>
                </div>
            </div>
            <h4 className="titulos-adm"> Cargar imagenes </h4>
            <div className="cargar-imagen-adm">
            <div className="text-area">
            <input className="input" placeholder=" Insertar https://"></input></div>
            <div className="icono-color">
            <FontAwesomeIcon className="icono-gral" icon={faSquarePlus}/>
            </div>
            </div>
            <div> 
            <button className="btn-crear-adm"> Crear </button>
            </div>
            </div>
        </div>
    
    )
}
export default AdministradorTemplate; 