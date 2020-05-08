package org.fasttrackit.onlinegallery;

import org.fasttrackit.onlineGallery.domain.Photo;
import org.fasttrackit.onlineGallery.domain.Tag;
import org.fasttrackit.onlineGallery.persistance.PhotoRepository;
import org.fasttrackit.onlineGallery.service.PhotoService;
import org.fasttrackit.onlineGallery.service.TagService;
import org.fasttrackit.onlineGallery.transfer.photo.AddTagsToPhotoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhotoServiceIntegrationTests {

    private PhotoService photoService;
    private PhotoRepository photoRepository;
    private TagService tagService;

    public PhotoServiceIntegrationTests(PhotoService photoService, PhotoRepository photoRepository, TagService tagService) {
        this.photoService = photoService;
        this.photoRepository = photoRepository;
        this.tagService = tagService;
    }


    void createPhoto_whenValidRequest_thenPhotoIsCreated(){
        
    }

    @Test
    void addTagsToPhoto_whenValidRequest_thenTagIsAdded(){
        AddTagsToPhotoRequest tagRequest = new AddTagsToPhotoRequest();

        Photo photo = photoRepository.findById(tagRequest.getPhotoId()).orElse(new Photo());

        if(photo.getTags() == null){
            Tag tag = tagService.getTag(tagRequest.getTagIds())
        }

        photoService.addTagToPhoto(tagRequest);
    }


}
