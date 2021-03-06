package org.fasttrackit.onlineGallery.persistance;

import org.fasttrackit.onlineGallery.domain.Folder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FolderRepository extends JpaRepository<Folder, Long> {

    Page<Folder> findByNameContaining(String partialName, Pageable pageable);

    @Query(value = "SELECT * FROM folder WHERE `name` LIKE '%?0'", nativeQuery = true)
    Page<Folder> findByPartialName(String partialName, Pageable pageable);
}
