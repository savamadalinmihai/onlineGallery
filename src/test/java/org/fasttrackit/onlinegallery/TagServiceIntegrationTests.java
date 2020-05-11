package org.fasttrackit.onlinegallery;

import org.fasttrackit.onlineGallery.service.TagService;
import org.fasttrackit.onlineGallery.transfer.tag.SaveTagRequest;
import org.fasttrackit.onlinegallery.steps.TagTestSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class TagServiceIntegrationTests {

    @Autowired
    private TagService tagService;
    @Autowired
    private TagTestSteps tagTestSteps;

    @Test
    void createTag_whenValidRequest_thenTagIsCreated(){ tagTestSteps.createTag();}

    @Test
    void createTag_whenEmptyTagName_thenExceptionIsThrown() {
        SaveTagRequest request = new SaveTagRequest();

        try {
            tagService.createTag(request);
        } catch (Exception e) {
            assertThat(e, notNullValue());
            assertThat("Unexpected exception type.", e instanceof TransactionSystemException);
        }
    }
}
