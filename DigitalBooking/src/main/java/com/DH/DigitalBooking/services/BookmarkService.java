package com.DH.DigitalBooking.services;
import com.DH.DigitalBooking.exceptions.BadRequestException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.dto.BookmarkDTO;
import com.DH.DigitalBooking.models.entities.Bookmark;
import com.DH.DigitalBooking.models.entities.Product;
import com.DH.DigitalBooking.models.entities.User;
import com.DH.DigitalBooking.repositories.BookmarkRepository;
import com.DH.DigitalBooking.repositories.ProductRepository;
import com.DH.DigitalBooking.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.emitter.EmitterException;

import java.awt.print.Book;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookmarkService implements IBookmarkService {

    @Autowired
    BookmarkRepository bookmarkRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ObjectMapper mapper;

    //@Autowired
    //private static final Logger logger = Logger.getLogger(BookmarkService.class);

    @Override
    public Bookmark addBookmark (BookmarkDTO bookmarkDTO) throws ResourceNotFoundException, EmptyFieldException {
        if(bookmarkDTO.getUser()==null || bookmarkDTO.getProduct()==null)
            throw  new EmptyFieldException(" Can't add to favorites");
        Optional<User> userFound = userRepository.findById(bookmarkDTO.getUser().getId());
        if(userFound.isPresent()) {
            Bookmark bookmark= mapper.convertValue(bookmarkDTO, Bookmark.class);
            //logger.info("Saved to your next trip")
            return bookmarkRepository.save(bookmark);
        }
        else{
            throw new ResourceNotFoundException("Problemes to find user id "+bookmarkDTO.getUser().getId());
        }
    }

    @Override
        public Set<BookmarkDTO> listBookmarks()throws ResourceNotFoundException{
        List<Bookmark> bookmarks= bookmarkRepository.findAll();
        Set<BookmarkDTO> bookmarksDTO= new HashSet<>();

        for (Bookmark bookmark : bookmarks){
            bookmarksDTO.add(mapper.convertValue(bookmark, BookmarkDTO.class));
        }
        //logger.info("Saved to your next trip")
        return bookmarksDTO;
    }


    @Override
    public Set<BookmarkDTO> listBookmarksByUser(Long id)throws ResourceNotFoundException {
        Optional<User> userFound = userRepository.findById(id);
        if(userFound.isPresent()) {
            Set<Bookmark> bookmarksByUser= bookmarkRepository.getBookmarkByUserId(id);
            Set<BookmarkDTO> bookmarksByUserDTO= new HashSet<>();
            for(Bookmark bookmark : bookmarksByUser){
                bookmarksByUserDTO.add(mapper.convertValue(bookmark, BookmarkDTO.class));
            }
                //logger.info("Saved to your next trip")
                return bookmarksByUserDTO;
            } else {throw new ResourceNotFoundException("Problemes to find user id "+id);
        }

    }

}


    /*@Override
    public Boolean deleteBookmarkByUserAndProduct(Long idUser, Long idProduct) throws BadRequestException, ResourceNotFoundException {
        Boolean delete = false;
        if (idUser<1)
            throw new BadRequestException("El id del usuario no puede ser negativo");
        if (idProduct<1)
            throw new BadRequestException("El id del producto no puede ser negativo");
        Optional<User> userFound = userRepository.findById(idUser);
        Optional<Product> productFound = productRepository.findById(idProduct);
        if(userFound.isPresent()){
            if(productFound.isPresent()) {
                Set<Bookmark> bookmarksByUserAndProduct = bookmarkRepository.getBookmarkByUserIdAndProductId(idUser, idProduct);
                //agregado por celeste
                if(bookmarksByUserAndProduct.isEmpty()){
                    throw new ResourceNotFoundException("El usuario con id "+idUser + " no selecciono al producto con id: " + idProduct + " como favorito.");
                } else {
                    for (Bookmark favorito : bookmarksByUserAndProduct) {
                        bookmarkRepository.delete(favorito);
                        delete = true;
                    }
                    //logger.info("El favorito se eliminó correctamente");
                    }
            }else {
                throw new ResourceNotFoundException("No se encontró un producto con id "+ idProduct);
            }
        }else {
            throw new ResourceNotFoundException("No se encontró un usuario con id "+ idUser);
        }
        return delete;
    }
*/

   /* @Override
    public void deleteBookmarkByUserAndProduct(Long idUser, Long idProduct) throws BadRequestException, ResourceNotFoundException {
        if (idUser<1)
            throw new BadRequestException("El id del usuario no puede ser negativo");
        if (idProduct<1)
            throw new BadRequestException("El id del producto no puede ser negativo");
        Optional<User> userFound = userRepository.findById(idUser);
        Optional<Product> productFound = productRepository.findById(idProduct);
        if(userFound.isPresent()){
            if(productFound.isPresent()) {
                Set<Bookmark> bookmarksByUserAndProduct = bookmarkRepository.getBookmarkByUserIdAndProductId(idUser, idProduct);
                if(bookmarksByUserAndProduct.isEmpty()){
                    throw new ResourceNotFoundException("El usuario con id "+idUser + " no selecciono al producto con id " + idProduct + " como favorito.");
                } else {
                    for (Bookmark bookmark : bookmarksByUserAndProduct) {
                        bookmarkRepository.delete(bookmark);
                    }
                    //logger.info("Deleted succesfully");
                }
            }else {
                throw new ResourceNotFoundException("No se encontró un producto con id "+idProduct);
            }
        }else {
            throw new ResourceNotFoundException("No se encontró un usuario con id "+idUser);
        }


    }*/

