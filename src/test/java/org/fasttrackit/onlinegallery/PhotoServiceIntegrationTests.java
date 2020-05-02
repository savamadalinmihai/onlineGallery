package org.fasttrackit.onlinegallery;

import org.fasttrackit.onlineGallery.service.PhotoService;
import org.fasttrackit.onlineGallery.transfer.photo.AddTagsToPhotoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhotoServiceIntegrationTests {

    private PhotoService photoService;

    @Test
    void addTagsToPhoto_whenNewPhoto_thenPhotoIsCreated(){
        AddTagsToPhotoRequest tagRequest = new AddTagsToPhotoRequest();
        tagRequest.setPhotoId();


        photoService.addTagToPhoto();
    }
}
