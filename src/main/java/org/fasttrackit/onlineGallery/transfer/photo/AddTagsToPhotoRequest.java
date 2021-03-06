package org.fasttrackit.onlineGallery.transfer.photo;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AddTagsToPhotoRequest {

    @NotNull
    private long photoId;
    @NotNull
    private List<Long> tagIds;

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }

    @Override
    public String toString() {
        return "AddTagsToPhotoRequest{" +
                "photoId=" + photoId +
                ", tagIds=" + tagIds +
                '}';
    }
}
