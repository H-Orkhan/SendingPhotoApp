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


    private String name;

    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Photo(String originalFilename, String path) {
        this.name=originalFilename;
        this.url=path;
    }

    public Photo() {
    }
}
