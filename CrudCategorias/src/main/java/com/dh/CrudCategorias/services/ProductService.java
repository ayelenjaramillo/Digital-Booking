package com.dh.CrudCategorias.services;
import com.dh.CrudCategorias.exceptions.ResourceNotFoundException;
import com.dh.CrudCategorias.models.Product;
import com.dh.CrudCategorias.models.ProductDTO;
import com.dh.CrudCategorias.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    ProductRepository productoRepository;

    public Product agregarProducto(ProductDTO productDTO) {
        Product product = new Product(productDTO.getId());
        return productoRepository.save(product);
    }

    //@Transactional ¿si o no?
    public Product actualizarProducto(ProductDTO productDTO, Integer id) throws ResourceNotFoundException {
        Product product = buscarProductoPorId(id);
        product.setNombre(productDTO.getNombre());
        product.setDireccion(productDTO.getDireccion());

        return productoRepository.save(product);

    }

    //@Transactional ¿si o no?
    public void eliminarProducto(Integer id) throws ResourceNotFoundException{
        Product product = buscarProductoPorId(id); //command option V
        productoRepository.delete(product);
    }

    public Product buscarProductoPorId(Integer id) throws ResourceNotFoundException{
        Product product = productoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro el producto con el id: " + id));
        return product;
    }

    public List<Product> listarProductos(){
        List<Product> productList = productoRepository.findAll();
        return productList;
    }

    public List<Product> buscarPorCiudad(String ciudad) {
        List<Product> resultados = productoRepository.buscarProductosPorCiudad(ciudad);
        return resultados;
    }

    public List<Product> buscarPorTituloDeCategoria(String titulo) {
        List<Product> resultados = productoRepository.buscarProductosPorTituloDeCategoria(titulo);
        return resultados;
    }



}
