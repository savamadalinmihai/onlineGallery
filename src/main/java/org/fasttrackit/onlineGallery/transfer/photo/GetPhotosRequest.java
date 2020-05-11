package org.fasttrackit.onlineGallery.transfer.photo;

import java.util.Date;

public class GetPhotosRequest {
    private String partialName;
    private Date date;

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
                ", date=" + date +
                '}';
    }
}
