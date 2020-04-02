package org.fasttrackit.onlineGallery.transfer.folder;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SaveFolderRequest {

    @NotNull
    private String name;
    @NotNull
    private String url;
    @NotNull
    private int numberOfFilesInside;
    @NotNull
    private long sizeInKb;
    private Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public int getNumberOfFilesInside() {
        return numberOfFilesInside;
    }

    public void setNumberOfFilesInside(int numberOfFilesInside) {
        this.numberOfFilesInside = numberOfFilesInside;
    }

    public long getSizeInKb() {
        return sizeInKb;
    }

    public void setSizeInKb(long sizeInKb) {
        this.sizeInKb = sizeInKb;
    }

    @Override
    public String toString() {
        return "SaveFolderRequest{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", numberOfFilesInside=" + numberOfFilesInside +
                ", sizeInKb=" + sizeInKb +
                ", createdDate=" + createdDate +
                '}';
    }
}
