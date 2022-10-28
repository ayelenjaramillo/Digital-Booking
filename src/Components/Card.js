import './Card.css'

export default function Card(props) {

return (
    <div className='container'>
        <div className='card'>
            <img alt={props.producto.nombre} src={props.producto.img}></img>
            <div className='rightproductdetails'>
                <p>{props.producto.category} </p>
                <h3>{props.producto.title} </h3>
                <p>{props.producto.location} </p>
                <p>{props.producto.description} </p>
                <button>Ver más/Ver detalle</button>
            </div>
        </div>
    </div>
)}
