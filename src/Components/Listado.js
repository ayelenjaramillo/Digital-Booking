import React, { useState, useEffect} from 'react';
import CardCate from './Card_list';
import './Listado.css';
import axios from "axios";
import Spinner from './Spinner';

export default function Listado() {
    const [product, setProduct] = useState({})
    const [isLoading, setIsLoading] = useState(true);
    const baseUrl = "http://localhost:8080/api/v1/"

    const getProductById = async () => {
        const endpoint = `${baseUrl}product`;
        return await axios.get(endpoint);
    }

    useEffect( () => {
        getProductById().then( (response) => {
            setProduct(response.data)

            // console.log(response.data?.title)

            // console.log("Response")
            // console.log(response)
            // console.log("Response Data")
            // console.log(response.data)
            // console.log("PRODUCTO")
            // console.log(product)
            // console.log("RRESPONSE CATEGORY TITLE")
            // console.log(response.data.category.title)
            // console.log("RESPONSE TITLE")
            // console.log(response.data.title)

            

        }).catch((error) => {
            console.log(error)
        })

        setTimeout(() => {
            setIsLoading(false);
        }, 3000)


    }, [])

    return(
        <div>
            <div>
                <p className='titlelist'>Recomendaciones</p>
            </div>
            <div className='contenedorlist'>
                {isLoading ? <Spinner/> : (product.map((p) => {
                    return <CardCate key={p.id} id= {p.id} title={p.title} image={p.images[0].url_image} cat={p.category.title} des={p.description}/>
                })
                )}

            </div>
        </div>
    )
}
