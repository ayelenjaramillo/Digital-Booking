package com.dh.CrudCategorias.services;
import com.dh.CrudCategorias.exceptions.ResourceNotFoundException;
import com.dh.CrudCategorias.models.Producto;
import com.dh.CrudCategorias.models.ProductoDTO;
import com.dh.CrudCategorias.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public Producto agregarProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto(productoDTO);
        return productoRepository.save(producto);
    }

    @Transactional
    public Producto actualizarProducto(ProductoDTO productoDTO, Integer id) throws ResourceNotFoundException {
        Producto producto = buscarProductoPorId(id);
        producto.setNombre(productoDTO.getNombre());
        producto.setDireccion(productoDTO.getDireccion());

        return productoRepository.save(producto);

    }

    @Transactional
    public void eliminarProducto(Integer id) throws ResourceNotFoundException{
        Producto producto = buscarProductoPorId(id); //command option V
        productoRepository.delete(producto);
    }

    public Producto buscarProductoPorId(Integer id) throws ResourceNotFoundException{
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro el producto con el id: " + id));
        return producto;
    }

    public List<Producto> listarProductos(){
        List<Producto> productoList = productoRepository.findAll();
        return productoList;
    }

}