package org.fasttrackit.onlinegallery;

import org.fasttrackit.onlineGallery.domain.Photo;
import org.fasttrackit.onlineGallery.domain.Tag;
import org.fasttrackit.onlineGallery.service.PhotoService;
import org.fasttrackit.onlineGallery.service.TagService;
import org.fasttrackit.onlineGallery.transfer.photo.AddTagsToPhotoRequest;
import org.fasttrackit.onlinegallery.steps.PhotoTestSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhotoServiceIntegrationTests {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private PhotoTestSteps photoTestSteps;
    @Autowired
    private TagService tagService;


    @Test
    void createPhoto_whenValidRequest_thenPhotoIsCreated(){ photoTestSteps.createPhoto(); }

    @Test
    void addTagsToPhoto_whenValidRequest_thenTagIsAdded(){
        AddTagsToPhotoRequest tagRequest = new AddTagsToPhotoRequest();

        Photo photo = photoTestSteps.createPhoto();

        for (Long tag : tagRequest.getTagIds()){

        }

        if(photo.getTags() == null){
            Tag tag = tagService.getTag(tagRequest.getTagIds())
        }

        photoService.addTagToPhoto(tagRequest);
    }


}
