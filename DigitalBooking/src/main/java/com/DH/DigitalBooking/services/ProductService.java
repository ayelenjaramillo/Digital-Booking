package com.DH.DigitalBooking.services;
import com.DH.DigitalBooking.exceptions.CreatingExistingEntityException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.DH.DigitalBooking.repositories.ProductRepository;
import com.DH.DigitalBooking.repositories.ImageRepository;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CityService cityService;


    public List<Product> listAll() {
        return productRepository.findAll();
    }


    public Product findById(Long id) throws ResourceNotFoundException {
        Optional<Product> result = productRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            throw new ResourceNotFoundException("Could not find specified resource.");
        }
    }

   public List<Product> filterByCategory(String category) {
        List<Product> result = productRepository.filterProductsByCategoryTitle(category);
        return result;
    }

    public List<Product> filterByCity(String city_name) {
        List<Product> result = productRepository.filterProductsByCityName(city_name);
        return result;
    }

    public Product create(DTOProductBuilder dtoProductBuilder) throws EmptyFieldException, CreatingExistingEntityException, ResourceNotFoundException {
        //revisar temanull
        //recibe dto producto y ese dto producto se lo pasas al metodo privado, y el metodo devuelve el objeto producto.

        if (dtoProductBuilder.getTitle() == null || dtoProductBuilder.getTitle().trim().isEmpty()) {
            throw new EmptyFieldException("Empty field for: title");
        }
        if (dtoProductBuilder.getId() != null) {
            throw new CreatingExistingEntityException("Products' IDs are auto-generated, you cannot specify it");
        }
        Product product= new Product();

        product.setCategory(categoryService.findById(dtoProductBuilder.getCategory_id()));
        product.setPolicy("DNLKNASDNÑLA");
        //product.setCity(cityService.findById(dtoProductBuilder.getCity().getId()));
        product.setCity(cityService.findById(dtoProductBuilder.getCity_id()));
        Product savedProduct = productRepository.save(product);

        Iterator<Image> itI = product.getImages().iterator();
        while (itI.hasNext()) {
            Image im = itI.next();
            im.setProduct(product);
            imageRepository.save(im);
        }
        savedProduct.setImages(product.getImages());
        return productRepository.save(savedProduct);
        }

        public Product edit (Product product) throws EmptyFieldException {
            if(product.getId() == null){
                throw new EmptyFieldException("Product must have an id to edit");
            }
            productRepository.findById(product.getId());
            if(product.getTitle() != null && !product.getTitle().trim().isEmpty()){
                return productRepository.save(product);
            }else{
                throw new EmptyFieldException("Empty field for title");
            }
        }

        public Product delete(Product product) throws EmptyFieldException {
            if(product.getId() == null){
                throw new EmptyFieldException("Product must have an id to delete");
            }
            Optional<Product> resultado = productRepository.findById(product.getId());
            if(resultado.isPresent()){
                productRepository.delete(resultado.get());
                return product;
            }else{
                throw new EmptyFieldException("Could not find a product with the specified id");
            }
        }

        public Product deleteById(Long id) throws ResourceNotFoundException{
            Product result = findById(id);
            productRepository.delete(result);
            return result;
        }

        //hacer metodo privado y hacer transformacion aca. Y que devuelva el objeto en el que quiero que se transforme.
      /*  private Product toProduct(DTOProductBuilder dtoProductBuilder){
            return new Product(dtoProductBuilder.getTitle(), dtoProductBuilder.getDescription(), dtoProductBuilder.getDescription_title(), dtoProductBuilder.getRating(), dtoProductBuilder.getAddress(),
                    new Category( null, null, null),
                    new City(dtoProductBuilder.getCity_id(), null, null), images,features,"Aquí van las políticas de este establecimiento");
        }*/



    }