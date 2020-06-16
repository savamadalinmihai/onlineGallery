package org.fasttrackit.onlineGallery.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Photo {

    @Id
    @GeneratedValue
    @Column(name = "photo_id")
    private long id;
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

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "photo_tag",
        joinColumns = @JoinColumn(name = "photo_id"),
        inverseJoinColumns = @JoinColumn (name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "photo_folder",
        joinColumns = @JoinColumn(name = "photo_id"),
        inverseJoinColumns = @JoinColumn(name = "folder_id"))
    private Set<Folder> folders = new HashSet<>();

    public void addPhotoToFolder(Folder folder){
        folders.add(folder);

        folder.getPhotos().add(this);
    }

    public void addTagToPhoto(Tag tag){
        tags.add(tag);

        tag.getPhotos().add(this);
    }

    public void removeTagFromPhoto(Tag tag){
        tags.remove(tag);

        tag.getPhotos().remove(this);
    }


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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Folder> getFolders() {
        return folders;
    }

    public void setFolders(Set<Folder> folders) {
        this.folders = folders;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
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
