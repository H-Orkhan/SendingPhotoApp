package com.sendPhoto.SendingPhotoApp.service;

import com.sendPhoto.SendingPhotoApp.models.Photo;
import com.sendPhoto.SendingPhotoApp.repo.PhotoDb;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class StorageService {

    private final PhotoDb photoDb;

    public StorageService(PhotoDb photoDb) {
        this.photoDb = photoDb;
    }

    public void uploadPhoto(MultipartFile file) throws IOException {
        String path = "D:\\Learning Java\\SendingPhotoApp\\uploadPhotos\\";
        file.transferTo(new File(path + file.getOriginalFilename()));
        Photo photo = new Photo(file.getOriginalFilename(),path);
        photoDb.save(photo);
    }

    public Iterable<Photo> getPhoto() {
        return photoDb.findAll();
    }
}
