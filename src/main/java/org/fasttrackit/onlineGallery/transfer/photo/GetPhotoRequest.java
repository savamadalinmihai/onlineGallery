package org.fasttrackit.onlineGallery.transfer.photo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetPhotoRequest {
    private String partialName;
    private List<String> tags = new ArrayList<String>();
    private Date date;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List tag) {
        this.tags = tag;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPartialName() {
        return partialName;
    }

    public void setPartialName(String partialName) {
        this.partialName = partialName;
    }

    @Override
    public String toString() {
        return "GetPhotoRequest{" +
                "partialName='" + partialName + '\'' +
                ", tag='" + tags + '\'' +
                ", date=" + date +
                '}';
    }
}
