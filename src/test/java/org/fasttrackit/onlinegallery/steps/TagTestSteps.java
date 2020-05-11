package org.fasttrackit.onlinegallery.steps;

import org.fasttrackit.onlineGallery.domain.Tag;
import org.fasttrackit.onlineGallery.service.TagService;
import org.fasttrackit.onlineGallery.transfer.tag.SaveTagRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@Component
public class TagTestSteps {
    @Autowired
    private TagService tagService;

    public Tag createTag(){
        SaveTagRequest request = new SaveTagRequest();
        request.setTagName("vacation");

        Tag tag = tagService.createTag(request);

        assertThat(tag, notNullValue());
        assertThat(tag.getId(), greaterThan(0L));
        assertThat(tag.getTagName(), is(request.getTagName()));

        return tag;
    }
}
