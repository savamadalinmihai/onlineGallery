package org.fasttrackit.onlineGallery.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Folder {

    @Id
    @GeneratedValue
    @Column(name = "folder_id")
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String path;
    @NotNull
    private int numberOfFilesInside;
    @NotNull
    private long sizeInKb;
    @NotNull
    private Date createdDate;

    @ManyToMany(mappedBy = "folders")
    private Set<Photo> photos = new HashSet<>();

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", numberOfFilesInside=" + numberOfFilesInside +
                ", sizeInKb=" + sizeInKb +
                ", createdDate=" + createdDate +
                '}';
    }
}
