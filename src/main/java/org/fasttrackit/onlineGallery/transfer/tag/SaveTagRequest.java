package org.fasttrackit.onlineGallery.transfer.tag;

import javax.validation.constraints.NotNull;

public class SaveTagRequest {

    @NotNull
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "SaveTagRequest{" +
                "tagName='" + tagName + '\'' +
                '}';
    }
}
