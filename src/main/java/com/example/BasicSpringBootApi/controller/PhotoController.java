package com.example.BasicSpringBootApi.controller;
import com.example.BasicSpringBootApi.model.Photo;
import com.example.BasicSpringBootApi.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService){
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello(){
        return "Welcome to Java file Storage Api.";
    }

    @GetMapping("/files")
    public Iterable<Photo> get(){
        return photoService.getAllPhotos(); // Returns a collection of photos
    }

    @GetMapping("/files/{id}")
    public Photo get(@PathVariable Integer id){
        Photo photo = photoService.getPhotoById(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photoService.getPhotoById(id); // Returns a single photo
    }

    @DeleteMapping("/files/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        photoService.removePhoto(id);
        return new ApiResponse(true, "File Removed");
    }

    @PostMapping("/files/create")
    public Photo create(@RequestPart("file") MultipartFile file) throws IOException {
        return photoService.savePhoto(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}

//@RequestBody: Allows spring boot to accept request data from the client

