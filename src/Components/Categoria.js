import React from 'react';
import Card from './Card_Cate';
import './Categoria.css';
import data from './dataCategoria.json'

const Categoria = () => {
return (
<div className= "main">
    <h2>Buscar por tipo de Alojamiento</h2>
    <p className="categorias">
    {
        data.map((categoria) => (
          <Card key={categoria.id} categoria={categoria}/>
        ))
    }
    </p>
</div>
)
}
export default Categoria
