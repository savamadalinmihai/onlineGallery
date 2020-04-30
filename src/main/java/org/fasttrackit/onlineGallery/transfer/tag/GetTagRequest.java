package org.fasttrackit.onlineGallery.transfer.tag;

public class GetTagRequest {

    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "GetTagRequest{" +
                "tagName='" + tagName + '\'' +
                '}';
    }
}
