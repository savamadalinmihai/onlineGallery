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
    private long id;
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

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "photo_tag",
        joinColumns = @JoinColumn(name = "photo_id"),
        inverseJoinColumns = @JoinColumn (name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", xAxisDimension=" + xAxisDimension +
                ", yAxisDimension=" + yAxisDimension +
                ", sizeInKb=" + sizeInKb +
                ", taggedAsFavorite=" + taggedAsFavorite +
                ", createdDate=" + createdDate +
                '}';
    }
}
