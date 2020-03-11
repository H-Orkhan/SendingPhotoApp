package com.sendPhoto.SendingPhotoApp.api;

import com.sendPhoto.SendingPhotoApp.models.Photo;
import com.sendPhoto.SendingPhotoApp.service.StorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

@RestController
public class PhotoUploadController {

    private final StorageService storageService;

    public PhotoUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public void uploadPhoto(@RequestParam("file") Collection<MultipartFile> files) throws IOException {
        storageService.uploadPhoto(files);
    }

    @GetMapping("/getAll")
    public Iterable<Photo> getPhoto () {
        return storageService.getPhoto();
    }

    @GetMapping("/get/{id}")
    public Photo getPhotoById(@PathVariable int id) {
        return storageService.getPhotoById(id);
    }
}
