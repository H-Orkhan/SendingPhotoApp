package com.sendPhoto.SendingPhotoApp.service;

import com.sendPhoto.SendingPhotoApp.models.Photo;
import com.sendPhoto.SendingPhotoApp.repo.PhotoDb;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Optional;

@Service
public class StorageService {

    private final PhotoDb photoDb;

    public StorageService(PhotoDb photoDb) {
        this.photoDb = photoDb;
    }

    public void uploadPhoto(Collection<MultipartFile> files) {
        String path = "D:\\Learning Java\\SendingPhotoApp\\uploadPhotos\\";
        files.forEach(file -> {
            try {
                file.transferTo(new File(path + file.getOriginalFilename()));
            } catch (IOException e) {
                System.out.println("Some problems with files.Please try again!!!");
            }
        });
        files.forEach(file -> photoDb.save(new Photo(path + file.getOriginalFilename())));
    }

    public Iterable<Photo> getPhoto() {
        return photoDb.findAll();
    }

    public Photo getPhotoById(int id) {
        Optional<Photo> optionalPhoto = photoDb.findById(id);
        optionalPhoto.orElseThrow(IllegalAccessError::new);
        return optionalPhoto.get();
    }
}
