package com.igypap.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by igypap on 29.01.17.
 */
@Entity
@Table(name = "gif")
public class Gif {

    @Id
    private String name;

    private String username;
    private int categoryId;
    private boolean favorite;

    public Gif() {
    }

    public Gif(String name, String username, boolean favorite) {
        this.name = name;
        this.username = username;
        this.favorite = favorite;
    }

    public Gif(String name, String username, int categoryId, boolean favorite) {
        this.name = name;
        this.username = username;
        this.categoryId = categoryId;
        this.favorite = favorite;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
