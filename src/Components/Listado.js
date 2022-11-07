import React from 'react';
import CardCate from './Card_list';
import './Listado.css';
import Datacate from './dataList.json'

export default function Listado(props) {
    return (
    <div>
        <div>
            <p className='titlelist'>Recomendaciones</p>
        </div>
        <div className='contenedorlist'>
            {Datacate.map((cardcate) => (
            <CardCate 
            key={cardcate.id}
            producto = {cardcate.producto}
            />
        ))}
        </div>
    </div>
)}


// const Categoria = () => {
// return (
// <div className= "main">
//     <h2>Buscar por tipo de Alojamiento</h2>
//     <div className="categorias">
//     {
//         data.map((categoria) => (
//           <Card key={categoria.id} categoria={categoria}/>
//         ))
//     }
//     </div>
// </div>
// )
// }
// export default Categoria
