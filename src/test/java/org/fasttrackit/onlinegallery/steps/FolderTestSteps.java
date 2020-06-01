package org.fasttrackit.onlinegallery.steps;

import org.fasttrackit.onlineGallery.domain.Folder;
import org.fasttrackit.onlineGallery.service.FolderService;
import org.fasttrackit.onlineGallery.transfer.folder.SaveFolderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@Component
public class FolderTestSteps {

    @Autowired
    private FolderService folderService;

    public Folder createFolder(){
        SaveFolderRequest request = new SaveFolderRequest();
        request.setName("honeymoon");
        request.setUrl("http://url");
        request.setCreatedDate(Date.valueOf("2019-12-22"));

        Folder folder = folderService.createFolder(request);

        assertThat(folder, notNullValue());
        assertThat(folder.getId(), greaterThan(0L));
        assertThat(folder.getName(), is(request.getName()));
        assertThat(folder.getUrl(), is(request.getUrl()));
        assertThat(folder.getCreatedDate(), is(request.getCreatedDate()));

        return folder;
    }
}
