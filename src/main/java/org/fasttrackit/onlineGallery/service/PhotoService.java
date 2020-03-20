package org.fasttrackit.onlineGallery.service;

import org.fasttrackit.onlineGallery.domain.Folder;
import org.fasttrackit.onlineGallery.domain.Photo;
import org.fasttrackit.onlineGallery.exception.ResourceNotFoundException;
import org.fasttrackit.onlineGallery.transfer.folder.GetFolderRequest;
import org.fasttrackit.onlineGallery.transfer.folder.SaveFolderRequest;
import org.fasttrackit.onlineGallery.transfer.photo.SavePhotoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PhotoService {


    private static final Logger LOGGER = LoggerFactory.getLogger(FolderService.class);

    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Photo createPhoto(SavePhotoRequest request) {
        LOGGER.info("Creating folder {}", request);

        Photo photo = new Photo();
        photo.setName(request.getName());

        return photoRepository.s(photo);
    }


    public Page<Folder> getFoldersBySearchParameters(GetFolderRequest request, Pageable pageable) {
        LOGGER.info("Searching for folders {}", request);

        if (request != null) {
            if (request.getPartialName() != null) {
                return folderRepository.findByNameContaining(request.getPartialName(), pageable);
            }
        }
        return folderRepository.findAll(pageable);
    }

    public Folder getFolder(long id){
        LOGGER.info("Retrieving folder {}", id);

        return folderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Folder " + id + " not found."));
    }

    public Folder updateFolder(long id, SaveFolderRequest request){
        LOGGER.info("Updating folder {}: {}", id, request);

        Folder folder  = getFolder(id);

        BeanUtils.copyProperties(request, folder);

        return folderRepository.save(folder);
    }

    public void deleteFolder(long id) {
        LOGGER.info("Deleting folder {}", id);

        folderRepository.deleteById(id);
    }
}
