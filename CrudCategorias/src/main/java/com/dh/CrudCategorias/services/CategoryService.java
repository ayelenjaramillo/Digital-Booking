package com.dh.CrudCategorias.services;
import com.dh.CrudCategorias.exceptions.ResourceNotFoundException;
import com.dh.CrudCategorias.models.Category;
import com.dh.CrudCategorias.models.CategoryDTO;
import com.dh.CrudCategorias.repositories.CategoryRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoriaRepository;
    // @Autowired
    //ObjectMapper mapper;
    //@Transactional /metodos con efecto
    public Category agregarCategoria(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO);
        return categoriaRepository.save(category);
    }
    //@Transactional
    public Category actualizarCategoria(CategoryDTO categoryDTO, Integer id) throws ResourceNotFoundException{
        Category category = buscarCategoriaPorId(id);
        category.setTitle(categoryDTO.getTitle());
        category.setDescription(categoryDTO.getDescription());
        /*categoria.setUrlImagen(categoriaDTO.getUrlImagen());*/

        return categoriaRepository.save(category);

    }
    //@Transactional
    public void eliminarCategoria(Integer id) throws ResourceNotFoundException{
        Category category = buscarCategoriaPorId(id); //command option V
        categoriaRepository.delete(category);
    }

    public Category buscarCategoriaPorId(Integer id) throws ResourceNotFoundException{
        Category category = categoriaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro la categoria con el id: " + id));
        return category;
    }

    public List<Category> listarCategorias(){
        List<Category> categoryList = categoriaRepository.findAll();
        return categoryList;
    }


}
