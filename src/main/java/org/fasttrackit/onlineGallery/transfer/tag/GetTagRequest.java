package org.fasttrackit.onlineGallery.transfer.tag;

public class GetTagRequest {

    private String partialName;
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getPartialName() {
        return partialName;
    }

    public void setPartialName(String partialName) {
        this.partialName = partialName;
    }

    @Override
    public String toString() {
        return "GetTagRequest{" +
                "partialName='" + partialName + '\'' +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}
