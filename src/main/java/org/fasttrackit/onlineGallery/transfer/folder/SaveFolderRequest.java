package org.fasttrackit.onlineGallery.transfer.folder;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SaveFolderRequest {

    @NotNull
    private String name;
    @NotNull
    private int numberOfFilesInside;
    @NotNull
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

    public int getNumberOfFilesInside() {
        return numberOfFilesInside;
    }

    public void setNumberOfFilesInside(int numberOfFilesInside) {
        this.numberOfFilesInside = numberOfFilesInside;
    }

    @Override
    public String toString() {
        return "SaveFolderRequest{" +
                "name='" + name + '\'' +
                ", numberOfFilesInside=" + numberOfFilesInside +
                ", createdDate=" + createdDate +
                '}';
    }
}
