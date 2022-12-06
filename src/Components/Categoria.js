import React, { useState, useEffect} from 'react';
import Card from './Card_categoria';
import './Categoria.css';
import axios from "axios";
import Spinner from './Spinner';


export default function Categoria() {
    const [category, setCategory] = useState([])
    const [isLoading, setIsLoading] = useState(true);
    const baseUrl = "http://localhost:8080/api/v1/"

    const getCategory = async () => {
        const endpoint = `${baseUrl}category`;
        return await axios.get(endpoint);
    }

    useEffect( () => {
        getCategory().then( (response) => {
            setCategory(response.data)
        }).catch((error) => {
            console.log(error)
        })

        setTimeout(() => {
            setIsLoading(false);
        }, 3000)


    }, [])

    return (    
    <div>
        <div>
            <p className='titlecat'>Buscar por tipo de alojamiento</p>
        </div>
        <div className='contenedor'>
            {isLoading ? <Spinner/> : (category.map((c) => {
                return <Card key={c.id} card={c} />

            })
            )}
        </div>
    </div>
    )
}

