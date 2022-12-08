package com.DH.DigitalBooking.services;

import com.DH.DigitalBooking.exceptions.BadRequestException;
import com.DH.DigitalBooking.exceptions.EmptyFieldException;
import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.dto.BookmarkDTO;
import com.DH.DigitalBooking.models.entities.Bookmark;

import java.util.Set;

public interface IBookmarkService {

    Bookmark addBookmark(BookmarkDTO bookmarkDTO) throws ResourceNotFoundException, EmptyFieldException;
    Set<BookmarkDTO> listBookmarks()throws ResourceNotFoundException;
    Set<BookmarkDTO> listBookmarksByUser(Long id) throws ResourceNotFoundException;
  /*  void deleteBookmarkByUserAndProduct(Long idUser, Long idProduct) throws BadRequestException, ResourceNotFoundException;
    Boolean deleteBookmarkByUserAndProduct(Long idUser, Long idProduct) throws BadRequestException, ResourceNotFoundException;
    //TODO VER EL TEMA DE ID USER Y ID PRODUCT*/





}
