package org.fasttrackit.onlineGallery.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
public class Folder {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String url;
    @NotNull
    private int numberOfFilesInside;
    @NotNull
    private long sizeInKb;
    @NotNull
    private Date createdDate;

    @Override
    public String toString() {
        return "Folder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", numberOfFilesInside=" + numberOfFilesInside +
                ", sizeInKb=" + sizeInKb +
                ", createdDate=" + createdDate +
                '}';
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
