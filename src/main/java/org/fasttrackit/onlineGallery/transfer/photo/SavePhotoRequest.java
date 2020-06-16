package org.fasttrackit.onlineGallery.transfer.photo;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class SavePhotoRequest {

    @NotNull
    private String name;
    @NotNull
    @Lob
    private String imageData;
    @NotNull
    private int xAxisDimension;
    @NotNull
    private int yAxisDimension;
    @NotNull
    private long sizeInKb;
    private boolean taggedAsFavorite;
    @NotNull
    private Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isTaggedAsFavorite() {
        return taggedAsFavorite;
    }

    public void setTaggedAsFavorite(boolean taggedAsFavorite) {
        this.taggedAsFavorite = taggedAsFavorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public int getxAxisDimension() {
        return xAxisDimension;
    }

    public void setxAxisDimension(int xAxisDimension) {
        this.xAxisDimension = xAxisDimension;
    }

    public int getyAxisDimension() {
        return yAxisDimension;
    }

    public void setyAxisDimension(int yAxisDimension) {
        this.yAxisDimension = yAxisDimension;
    }

    public long getSizeInKb() {
        return sizeInKb;
    }

    public void setSizeInKb(long sizeInKb) {
        this.sizeInKb = sizeInKb;
    }

    @Override
    public String toString() {
        return "Photo{" +
                ", name='" + name + '\'' +
                ", imageData='" + imageData + '\'' +
                ", xAxisDimension=" + xAxisDimension +
                ", yAxisDimension=" + yAxisDimension +
                ", sizeInKb=" + sizeInKb +
                ", taggedAsFavorite=" + taggedAsFavorite +
                ", createdDate=" + createdDate +
                '}';
    }
}
