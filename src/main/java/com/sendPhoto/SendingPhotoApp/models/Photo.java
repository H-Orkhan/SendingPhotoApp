package com.sendPhoto.SendingPhotoApp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String url;

    public String getUrl() {
        return url;
    }

    public Photo(String path) {
        this.url = path;
    }

    public Photo() {
    }
}
