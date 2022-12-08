package com.DH.DigitalBooking.repositories;

import com.DH.DigitalBooking.models.entities.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    @Query("select b from Bookmark b where b.user.id =:userId")
    Set<Bookmark> getBookmarkByUserId(@Param("userId") Long id);

    @Query("select b from Bookmark b where b.user.id =:userId and b.product.id =:productId")
    Set<Bookmark> getBookmarkByUserIdAndProductId(@Param("userId") Long idUser, @Param("productId") Long idProduct);

}
