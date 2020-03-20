package org.fasttrackit.onlineGallery.transfer.folder;

public class GetFolderRequest {
    private String partialName;

    @Override
    public String toString() {
        return "GetFolderRequest{" +
                "partialName='" + partialName + '\'' +
                '}';
    }

    public String getPartialName() {
        return partialName;
    }

    public void setPartialName(String partialName) {
        this.partialName = partialName;
    }
}
