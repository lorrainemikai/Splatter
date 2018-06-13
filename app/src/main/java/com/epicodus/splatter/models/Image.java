
package com.epicodus.splatter.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Image {

    private String id;
    private String createdAt;
    private String updatedAt;
    private Integer width;
    private Integer height;
    private String color;
    private String description;
    private Urls urls;
    private Links links;
    private List<Object> categories = null;
    private Boolean sponsored;
    private Integer likes;
    private Boolean likedByUser;
    private List<Object> currentUserCollections = null;
    private Object slug;
    private User user;
    private List<Tag> tags = null;
    private List<PhotoTag> photoTags = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    /**
     * 
     * @param tags
     * @param currentUserCollections
     * @param urls
     * @param width
     * @param links
     * @param id
     * @param updatedAt
     * @param height
     * @param color
     * @param createdAt
     * @param description
     * @param likes
     * @param photoTags
     * @param slug
     * @param categories
     * @param likedByUser
     * @param sponsored
     * @param user
     */
    public Image(String id, String createdAt, String updatedAt, Integer width, Integer height, String color, String description, Urls urls, Links links, List<Object> categories, Boolean sponsored, Integer likes, Boolean likedByUser, List<Object> currentUserCollections, Object slug, User user, List<Tag> tags, List<PhotoTag> photoTags) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.width = width;
        this.height = height;
        this.color = color;
        this.description = description;
        this.urls = urls;
        this.links = links;
        this.categories = categories;
        this.sponsored = sponsored;
        this.likes = likes;
        this.likedByUser = likedByUser;
        this.currentUserCollections = currentUserCollections;
        this.slug = slug;
        this.user = user;
        this.tags = tags;
        this.photoTags = photoTags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public Boolean getSponsored() {
        return sponsored;
    }

    public void setSponsored(Boolean sponsored) {
        this.sponsored = sponsored;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public List<Object> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<Object> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    public Object getSlug() {
        return slug;
    }

    public void setSlug(Object slug) {
        this.slug = slug;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<PhotoTag> getPhotoTags() {
        return photoTags;
    }

    public void setPhotoTags(List<PhotoTag> photoTags) {
        this.photoTags = photoTags;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
