package org.fasttrackit.onlinegallery;

import org.fasttrackit.onlineGallery.service.FolderService;
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

}
