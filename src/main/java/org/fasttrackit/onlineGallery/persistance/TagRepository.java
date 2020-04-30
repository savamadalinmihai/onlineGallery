package org.fasttrackit.onlineGallery.persistance;

import org.fasttrackit.onlineGallery.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
