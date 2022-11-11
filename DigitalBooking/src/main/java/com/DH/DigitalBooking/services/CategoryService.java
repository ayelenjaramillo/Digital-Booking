package com.DH.DigitalBooking.services;
import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.Category;
import com.DH.DigitalBooking.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //listCategories()  //listAllCategories()
    //addCategory  //createCategory

    //NECESITAN  DE findById
    //editCategory
    //deleteCategory

    public Category createCategory(Category category)throws EmptyFieldException, CreatingExistingEntityException {

        if(category.getTitle() == null || category.getTitle().trim().isEmpty()){
            throw new EmptyFieldException("Empty field for: title");
        }
        if(category.getId() != null){
            throw new CreatingExistingEntityException("Categories' IDs are auto-generated, you cannot specify it");
        }
        return categoryRepository.save(category);
    }

    public Category findById(Long id) throws ResourceNotFoundException{
        Optional<Category> result = categoryRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            throw new ResourceNotFoundException("Could not find specified resource");
        }
    }

    public List<Category> listAllCategories() throws ResourceNotFoundException {
        return categoryRepository.findAll();
    }

    public Category edit (Category category) throws EmptyFieldException{
        if(category.getId() == null){
            throw new EmptyFieldException("Category must have an id to edit");
        }
        categoryRepository.findById(category.getId());
        if(category.getTitle() != null && !category.getTitle().trim().isEmpty()){
            return categoryRepository.save(category);
        }else{
            throw new EmptyFieldException("Empty field for title");
        }
    }

    public Category delete(Category category) throws ResourceNotFoundException,EmptyFieldException{
        if(category.getId() == null){
            throw new EmptyFieldException("Category must have a valid Id to delete");
        }
        findById(category.getId());
        categoryRepository.delete(category);
        return category;
    }


    public Category deleteCategoryById (Long id) throws ResourceNotFoundException {
        Category result = findById(id);
        categoryRepository.delete(result);
            return result;
    }
}
