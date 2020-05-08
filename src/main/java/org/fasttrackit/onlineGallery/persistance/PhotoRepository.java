package org.fasttrackit.onlineGallery.persistance;

import org.fasttrackit.onlineGallery.domain.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    Page<Photo> findByNameContaining(String partialName, Pageable pageable);

    Page<Photo> findPhotoBy(String tagName, Pageable pageable);

}

