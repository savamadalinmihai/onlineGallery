package org.fasttrackit.onlineGallery.service;

import org.fasttrackit.onlineGallery.domain.Photo;
import org.fasttrackit.onlineGallery.domain.Tag;
import org.fasttrackit.onlineGallery.exception.ResourceNotFoundException;
import org.fasttrackit.onlineGallery.persistance.PhotoRepository;
import org.fasttrackit.onlineGallery.transfer.photo.AddTagsToPhotoRequest;
import org.fasttrackit.onlineGallery.transfer.photo.GetPhotosRequest;
import org.fasttrackit.onlineGallery.transfer.photo.SavePhotoRequest;
import org.fasttrackit.onlineGallery.transfer.tag.GetTagRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PhotoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FolderService.class);

    private final PhotoRepository photoRepository;
    private final TagService tagService;

    @Autowired
    public PhotoService(PhotoRepository photoRepository, TagService tagService) {
        this.photoRepository = photoRepository;
        this.tagService = tagService;
    }

    @Transactional
    public void addTagToPhoto(AddTagsToPhotoRequest request) {
        LOGGER.info("Adding tag to photo {}", request);

        Photo photo = photoRepository.findById(request.getPhotoId())
                .orElse(new Photo());
        for (Long tagId : request.getTagIds()) {
            Tag tag = tagService.getTag(tagId);
            photo.addTagToPhoto(tag);
        }
        photoRepository.save(photo);
    }

    @Transactional
    public void removeTagFromPhoto(AddTagsToPhotoRequest request){
        LOGGER.info("Removing tag from photo {}", request);

        Photo photo = photoRepository.findById(request.getPhotoId()).orElse(new Photo());

        for (Long tagId : request.getTagIds()){
            Tag tag = tagService.getTag(tagId);
            photo.removeTagFromPhoto(tag);
        }
        photoRepository.save(photo);
    }

    public Photo createPhoto(SavePhotoRequest request) {
        LOGGER.info("Creating photo {}", request);

        Photo photo = new Photo();
        photo.setName(request.getName());
        photo.setCreatedDate(request.getCreatedDate());
        photo.setTaggedAsFavorite(request.isTaggedAsFavorite());
        photo.setxAxisDimension(request.getxAxisDimension());
        photo.setyAxisDimension(request.getyAxisDimension());
        photo.setSizeInKb(request.getSizeInKb());
        photo.setUrl(request.getUrl());

        return photoRepository.save(photo);
    }

    public Page<Photo> getPhotos(GetPhotosRequest request, GetTagRequest tagRequest, Pageable pageable) {
        LOGGER.info("Searching for photos {}", request);

        if (request != null) {
            if (request.getPartialName() != null) {
                return photoRepository.findByNameContaining(request.getPartialName(), pageable);
            } else if (tagRequest.getTagName() != null) {
                return photoRepository.findPhotoBy(tagRequest.getTagName(), pageable);
            }
        }
        return photoRepository.findAll(pageable);
    }

    public Photo getPhoto(long id) {
        LOGGER.info("Retrieving photo {}", id);

        return photoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Photo " + id + " not found."));
    }

    public Photo updatePhoto(long id, SavePhotoRequest request) {
        LOGGER.info("Updating photo {}: {}", id, request);

        Photo photo = getPhoto(id);

        BeanUtils.copyProperties(request, photo);

        return photoRepository.save(photo);
    }

    public void deletePhoto(long id) {
        LOGGER.info("Deleting photo {}", id);

        photoRepository.deleteById(id);
    }
}
