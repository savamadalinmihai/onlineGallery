package org.fasttrackit.onlineGallery.persistance;

import org.fasttrackit.onlineGallery.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Page<Tag> findByTagNameContaining(String partialName, Pageable pageable);
    Tag findByTagName(String partialName);
}
