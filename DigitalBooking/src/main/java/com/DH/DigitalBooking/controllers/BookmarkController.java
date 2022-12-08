package com.DH.DigitalBooking.controllers;
import com.DH.DigitalBooking.exceptions.BadRequestException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.dto.BookmarkDTO;
import com.DH.DigitalBooking.services.BookmarkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/bookmarks")
@CrossOrigin(origins = "*")
@Tag(name = "Bookmarks", description = "It's mandatory valid token to used endpoints")
public class BookmarkController {

    @Autowired
    BookmarkService bookmarkService;

    // @Autowired
    //private static final Logger logger = Logger.getLogger(BookmarkService.class);


    @Operation(summary = "Crear un marcador", description = "Se necesita enviar un JWT válido en el header de la petición para utilizar el método.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se creó el marcador favorito con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookmarkDTO.class)) }),
            @ApiResponse(responseCode = "403", description = "No se recibió un JWT válido.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No se encontró un usuario con el id enviado.",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "Se intenta crear un favorito incompleto.",
                    content = @Content) })
    @PostMapping
    public ResponseEntity<String> createFBookmark(@Valid @RequestBody BookmarkDTO bookmarkDTO) throws EmptyFieldException, ResourceNotFoundException {
        bookmarkService.addBookmark(bookmarkDTO);
        return ResponseEntity.ok("El favorito se agregó correctamente");
    }


    @Operation(summary = "Listar favoritos", description = "Se necesita enviar un JWT válido en el header de la petición para utilizar el método.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se listaron los favoritos correctamente.",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "No se recibió un JWT válido.",
                    content = @Content)})
    @GetMapping
    public ResponseEntity<Set<BookmarkDTO>> listBookmarks() throws ResourceNotFoundException {
        return ResponseEntity.ok(bookmarkService.listBookmarks());
    }


    @Operation(summary = "Listar favoritos por usuario", description = "Se necesita enviar un JWT válido en el header de la petición para utilizar el método.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se listaron los favoritos del usuario correctamente.",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "No se recibió un JWT válido.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No se encontró un usuario con el id enviado.",
                    content = @Content)})
    @GetMapping("/user/{id}")
    public ResponseEntity<Set<BookmarkDTO>> listBookmarksByUser(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(bookmarkService.listBookmarksByUser(id));
    }

/*    @DeleteMapping
    public ResponseEntity<String> deleteBookmarkByUserAndProduct(@RequestParam ("idUsuario") Long idUsuario, @RequestParam("idProducto") Long idProducto) throws BadRequestException, ResourceNotFoundException {
        Boolean eliminado = bookmarkService.deleteBookmarkByUserAndProduct(idUser, idProduct);
        if(eliminado){
            return ResponseEntity.ok("El usuario con id " + idUsuario + " eliminó el favorito del producto con id: " + idProducto);
        }else{
            return ResponseEntity.ok("El producto no se encontró en los favoritos del usuario con id " + idUsuario);
        }
    }


    @Operation(summary = "Eliminar favorito", description = "Se necesita enviar un JWT válido en el header de la petición para utilizar el método.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se eliminó el favorito con éxito.",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "El id del usuario o el id del producto no pueden ser negativos.",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "No se recibió un JWT válido.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No se encontró un producto con el id enviado o el usuario no tiene como favorito al producto con el id enviado o no existe un usuario con el id enviado.",
                    content = @Content)})
    @DeleteMapping
    public ResponseEntity<String> deleteBookmarkByUserAndProduct(@RequestParam ("idUser") Long idUser, @RequestParam("idProduct") Long idProduct) throws BadRequestException, ResourceNotFoundException {
        bookmarkService.deleteBookmarkByUserAndProduct(idUser,idProduct);
        return ResponseEntity.ok("El usuario con id " + idUser + " eliminó el favorito del producto con id " + idProduct);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBookmarkByUserAndProduct(@RequestParam ("idUser") Long idUser, @RequestParam("idProduct") Long idProduct) throws BadRequestException, ResourceNotFoundException {
        Boolean delete = bookmarkService.deleteBookmarkByUserAndProduct(idUser, idProduct);
        if(delete){
            return ResponseEntity.ok("El usuario con id " + idUser + " eliminó el favorito del producto con id: " + idProduct);
        }else{
            return ResponseEntity.ok("El producto no se encontró en los favoritos del usuario con id " + idUser);
        }
    }*/

}
