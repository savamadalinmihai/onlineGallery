package org.fasttrackit.onlineGallery.transfer.folder;

public class GetFolderRequest {
    private String partialName;

    public String getPartialName() {
        return partialName;
    }

    public void setPartialName(String partialName) {
        this.partialName = partialName;
    }

    @Override
    public String toString() {
        return "GetFolderRequest{" +
                "partialName='" + partialName + '\'' +
                '}';
    }
}
