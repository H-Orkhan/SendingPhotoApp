package com.sendPhoto.SendingPhotoApp.api;

import com.sendPhoto.SendingPhotoApp.models.Photo;
import com.sendPhoto.SendingPhotoApp.service.StorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class PhotoUploadController {

    private final StorageService storageService;

    public PhotoUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/")
    public void uploadPhoto(@RequestParam("file") MultipartFile file) throws IOException {
        storageService.uploadPhoto(file);
    }

    @GetMapping("/")
    public Iterable<Photo> getPhoto () {
        return storageService.getPhoto();
    }
}
