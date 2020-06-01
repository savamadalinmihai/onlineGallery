package org.fasttrackit.onlinegallery;

import org.fasttrackit.onlineGallery.domain.Folder;
import org.fasttrackit.onlineGallery.service.FolderService;
import org.fasttrackit.onlineGallery.transfer.folder.AddPhotoToFolderRequest;
import org.fasttrackit.onlinegallery.steps.FolderTestSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FolderServiceIntegrationTests {

    @Autowired
    private FolderService folderService;

    @Autowired
    private FolderTestSteps folderTestSteps;

    @Test
    void createFolder_whenValidRequest_thenFolderIsCreated(){folderTestSteps.createFolder();}

    @Test
    void addPhotoToFolder_whenValidRequest_thenPhotoIsAdded(){
        Folder folder = folderTestSteps.createFolder();

        AddPhotoToFolderRequest request = new AddPhotoToFolderRequest();
        request.setPhotoId(folder.getId());

        // creating a list to add ids to and pass over to tagRequest
        List<Long> tagList = new ArrayList<>();
        tagList.add(19L);
        tagList.add(20L);
        tagList.add(21L);
        tagRequest.setTagIds(tagList);

        photoService.addTagToPhoto(tagRequest);

        assertThat(photo.getTags(), notNullValue());
    }
}
