package org.fasttrackit.onlinegallery;

import org.fasttrackit.onlineGallery.domain.Photo;
import org.fasttrackit.onlineGallery.service.PhotoService;
import org.fasttrackit.onlineGallery.transfer.photo.AddTagsToPhotoRequest;
import org.fasttrackit.onlineGallery.transfer.photo.SavePhotoRequest;
import org.fasttrackit.onlinegallery.steps.PhotoTestSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class PhotoServiceIntegrationTests {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private PhotoTestSteps photoTestSteps;

    @Test
    void createPhoto_whenValidRequest_thenPhotoIsCreated(){ photoTestSteps.createPhoto(); }

    @Test
    void createPhoto_whenMissingName_thenExceptionIsThrown() {
        SavePhotoRequest request = new SavePhotoRequest();
        request.setPath("asfas");
        request.setyAxisDimension(124);
        try {
            photoService.createPhoto(request);
        } catch (Exception e) {
            assertThat(e, notNullValue());
            assertThat("Unexpected exception type.", e instanceof TransactionSystemException);
        }
    }

    @Test
    void addTagsToPhoto_whenValidRequest_thenTagIsAdded(){
        //creating a photo object to add the tags to
        Photo photo = photoTestSteps.createPhoto();

        // creating an AddTagsToPhotoRequest object that later I can pass to photoService
        AddTagsToPhotoRequest tagRequest = new AddTagsToPhotoRequest();
        tagRequest.setPhotoId(photo.getId());

        // creating a list to add ids to and pass over to tagRequest
        List<Long> tagList = new ArrayList<>();
        tagList.add(19L);
        tagList.add(20L);
        tagList.add(21L);
        tagRequest.setTagIds(tagList);

        photoService.addTagToPhoto(tagRequest);

        assertThat(photo.getTags(), notNullValue());
    }

//    @Test
//    void removeTagFromPhoto_whenValidRequest_thenTagIsRemoved(){
//        Photo photo = photoTestSteps.createPhoto();
//
//        AddTagsToPhotoRequest request = new AddTagsToPhotoRequest();
//        request.setPhotoId(photo.getId());
//
//        List<Long> list = Collections.singletonList(20L);
//
//        request.setTagIds(list);
//
//        photoService.removeTagFromPhoto(request);
//    }

    @Test
    void addTagToPhoto_whenNewTag_thenTagIsCreated(){
        Photo photo = photoTestSteps.createPhoto();

        AddTagsToPhotoRequest tagRequest = new AddTagsToPhotoRequest();
        tagRequest.setPhotoId(photo.getId());

        List<Long> tagList = new ArrayList<>();
        tagList.add(19L);
        tagList.add(20L);
        tagList.add(21L);
        tagRequest.setTagIds(tagList);
    }
}
