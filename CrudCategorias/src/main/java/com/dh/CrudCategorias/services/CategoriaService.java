package com.dh.CrudCategorias.services;
import com.dh.CrudCategorias.exceptions.BadRequestException;
import com.dh.CrudCategorias.exceptions.ResourceNotFoundException;
import com.dh.CrudCategorias.models.Categoria;
import com.dh.CrudCategorias.models.CategoriaDTO;
import com.dh.CrudCategorias.repositories.CategoriaRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;



    //
    // @Autowired
    //ObjectMapper mapper;
    //@Transactional /metodos con efecto
    public Categoria agregarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria(categoriaDTO);
        return categoriaRepository.save(categoria);
    }
    //@Transactional
    public Categoria actualizarCategoria(CategoriaDTO categoriaDTO, Integer id) throws ResourceNotFoundException{
        Categoria categoria = buscarCategoriaPorId(id);
        categoria.setTitulo(categoriaDTO.getTitulo());
        categoria.setDescripcion(categoriaDTO.getDescripcion());
        /*categoria.setUrlImagen(categoriaDTO.getUrlImagen());*/

        return categoriaRepository.save(categoria);

    }
    //@Transactional
    public void eliminarCategoria(Integer id) throws ResourceNotFoundException{
        Categoria categoria = buscarCategoriaPorId(id); //command option V
        categoriaRepository.delete(categoria);
    }

    public Categoria buscarCategoriaPorId(Integer id) throws ResourceNotFoundException{
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro la categoria con el id: " + id));
        return categoria;
    }

    public List<Categoria> listarCategorias(){
        List<Categoria> categoriaList = categoriaRepository.findAll();
        return categoriaList;
    }


}
