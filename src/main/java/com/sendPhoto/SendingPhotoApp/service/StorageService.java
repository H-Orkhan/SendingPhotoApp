package com.sendPhoto.SendingPhotoApp.service;

import com.sendPhoto.SendingPhotoApp.models.Photo;
import com.sendPhoto.SendingPhotoApp.repo.PhotoDb;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {

    private final PhotoDb photoDb;

    public StorageService(PhotoDb photoDb) {
        this.photoDb = photoDb;
    }

    public void uploadPhoto(MultipartFile file) throws IOException {
        String path = "D:\\Learning Java\\SendingPhotoApp\\uploadPhotos\\";
        file.transferTo(new File(path + file.getOriginalFilename()));
        photoDb.save(new Photo(path));
    }

    public Iterable<Photo> getPhoto() {
        return photoDb.findAll();
    }

    public Photo getPhotoById(int id)  {
        Optional<Photo> optionalPhoto = photoDb.findById(id);
        optionalPhoto.orElseThrow(IllegalAccessError::new);
        return optionalPhoto.get();
    }
}
