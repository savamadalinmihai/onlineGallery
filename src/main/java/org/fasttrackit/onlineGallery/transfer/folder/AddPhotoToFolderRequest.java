package org.fasttrackit.onlineGallery.transfer.folder;

import javax.validation.constraints.NotNull;

public class AddPhotoToFolderRequest {

    @NotNull
    private Long photoId;
    @NotNull
    private Long folderId;

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    @Override
    public String toString() {
        return "AddPhotoToFolderRequest{" +
                "photoId=" + photoId +
                ", folderId=" + folderId +
                '}';
    }
}
