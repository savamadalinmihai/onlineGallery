package org.fasttrackit.onlineGallery.service;

import org.fasttrackit.onlineGallery.domain.Photo;
import org.fasttrackit.onlineGallery.exception.ResourceNotFoundException;
import org.fasttrackit.onlineGallery.persistance.PhotoRepository;
import org.fasttrackit.onlineGallery.transfer.photo.GetPhotoRequest;
import org.fasttrackit.onlineGallery.transfer.photo.SavePhotoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
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
        photo.setUrl(request.getUrl());
        photo.setCreatedDate(request.getCreatedDate());

        return photoRepository.save(photo);
    }

    public Page<Photo> getPhotos(GetPhotoRequest request, Pageable pageable) {
        LOGGER.info("Searching for photos {}", request);

        if (request != null) {
            if (request.getPartialName() != null) {
                return photoRepository.findByNameContaining(request.getPartialName(), pageable);
            } else if(request.getTags() != null){
                return photoRepository.findByTagsIn(request.getTags(), pageable);
            }
        }
        return photoRepository.findAll(pageable);
    }

    public Photo getPhoto(long id){
        LOGGER.info("Retrieving photo {}", id);

        return photoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Photo " + id + " not found."));
    }

    public Photo updatePhoto(long id, SavePhotoRequest request){
        LOGGER.info("Updating photo {}: {}", id, request);

        Photo photo  = getPhoto(id);

        BeanUtils.copyProperties(request, photo);

        return photoRepository.save(photo);
    }

    public void deletePhoto(long id) {
        LOGGER.info("Deleting photo {}", id);

        photoRepository.deleteById(id);
    }
}
