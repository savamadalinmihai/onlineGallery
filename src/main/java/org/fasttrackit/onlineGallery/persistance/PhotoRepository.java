package org.fasttrackit.onlineGallery.persistance;

import org.fasttrackit.onlineGallery.domain.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    Page<Photo> findByNameContaining(String partialName, Pageable pageable);

    @Query(value = "SELECT * FROM photo WHERE `name` LIKE '%?0'", nativeQuery = true)
    Page<Photo> findPhotosBySearchParameters(String partialName, Pageable pageable);

    Page<Photo> findByTagsIn(List<String> tags, Pageable pageable);


}


