package org.fasttrackit.onlineGallery.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    private int numberOfFilesInside;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
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

    public int getNumberOfFilesInside() {
        return numberOfFilesInside;
    }

    public void setNumberOfFilesInside(int numberOfFilesInside) {
        this.numberOfFilesInside = numberOfFilesInside;
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
                ", numberOfFilesInside=" + numberOfFilesInside +
                ", createdDate=" + createdDate +
                '}';
    }
}
