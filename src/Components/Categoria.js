import Card from './Card_categoria';
import './Categoria.css';
import Data from './data.json';


export default function Categoria(props) {
    return (
    <div>
        <div>
            <p className='titlecat'>Buscar por tipo de alojamiento</p>
        </div>
        <div className='contenedor'>
            {Data.map((card) => (
            <Card 
            key={card.id}
            card = {card}
            />
        ))}
        </div>
    </div>
)}

