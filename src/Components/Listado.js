import Card from './Card';
import './Listado.css';
import Data from './data.json';


export default function Listado(props) {
    return (
    <div className='listado'>
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

