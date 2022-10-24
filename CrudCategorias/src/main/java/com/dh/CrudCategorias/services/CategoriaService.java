package com.dh.CrudCategorias.services;

import com.dh.CrudCategorias.models.Categoria;
import com.dh.CrudCategorias.models.CategoriaDTO;
import com.dh.CrudCategorias.repositories.CategoriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ObjectMapper mapper;

    public Categoria agregarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void actualizarCategoria(Categoria categoria){
        guardarCategoria(categoria);
    }

    public void eliminarCategoria(Integer id){
        categoriaRepository.deleteById(id);
    }
/*
    public Categoria buscarCategoriaPorId(Integer id){
        Optional<Categoria> categoriaPorEncontrar = categoriaRepository.findById(id);
        Categoria respuesta = null;
        if (categoriaPorEncontrar.isPresent()) {
             Categoria categoria = categoriaPorEncontrar.get();
             System.out.println(categoriaRepository.findById(id));
        }
        else{
            categoriaPorEncontrar.isEmpty();
        }
        return respuesta;
    }
*/
    public CategoriaDTO buscarCategoriaPorId(Integer id){
        Optional<Categoria> categoriaPorEncontrar = categoriaRepository.findById(id);
        CategoriaDTO respuesta = null;
        if (categoriaPorEncontrar.isPresent()){
            respuesta = mapper.convertValue(categoriaPorEncontrar, CategoriaDTO.class);
        }else{
            categoriaPorEncontrar.isEmpty();
        }
        return respuesta;
    }

    public Collection<CategoriaDTO> listarCategorias(){
        List<Categoria> categoriaList = categoriaRepository.findAll();
        Set<CategoriaDTO> categoriaDTO = new HashSet<>();
        for (Categoria categoria : categoriaList){
            categoriaDTO.add(mapper.convertValue(categoria, CategoriaDTO.class));
        }
        return categoriaDTO;
    }

    private void guardarCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }


}
