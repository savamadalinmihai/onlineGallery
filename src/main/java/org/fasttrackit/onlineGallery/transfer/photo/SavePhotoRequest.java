package org.fasttrackit.onlineGallery.transfer.photo;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class SavePhotoRequest {

    @NotNull
    private String name;
    @NotNull
    private String url;
    @NotNull
    private int xAxisDimension;
    @NotNull
    private int yAxisDimension;
    @NotNull
    private long sizeInKb;
    private boolean taggedAsFavorite;
    @NotNull
    private Date createdDate;
    private List<String> tags;

    @Override
    public String toString() {
        return "Photo{" +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", xAxisDimension=" + xAxisDimension +
                ", yAxisDimension=" + yAxisDimension +
                ", sizeInKb=" + sizeInKb +
                ", taggedAsFavorite=" + taggedAsFavorite +
                ", createdDate=" + createdDate +
                ", tags=" + tags +
                '}';
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
