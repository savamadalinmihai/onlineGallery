package org.fasttrackit.onlineGallery.web;

import org.fasttrackit.onlineGallery.domain.Photo;
import org.fasttrackit.onlineGallery.service.PhotoService;
import org.fasttrackit.onlineGallery.transfer.photo.GetPhotosRequest;
import org.fasttrackit.onlineGallery.transfer.photo.SavePhotoRequest;
import org.fasttrackit.onlineGallery.transfer.tag.GetTagRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RequestMapping("/photo")
@RestController
public class PhotoController {

    private final PhotoService photoService;


    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping
    public ResponseEntity<Photo> createPhoto(@Valid @RequestBody SavePhotoRequest request){
        Photo photo = photoService.createPhoto(request);
        return new ResponseEntity<>(photo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Photo> getPhoto(@PathVariable long id){
        Photo photo = photoService.getPhoto(id);
        return new ResponseEntity<>(photo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Photo>> getPhotos(GetPhotosRequest request, GetTagRequest tagRequest, Pageable pageable){
        Page<Photo> photos = photoService.getPhotos(request, tagRequest, pageable);
        return new ResponseEntity<>(photos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Photo> updatePhotos(@PathVariable long id, @Valid SavePhotoRequest request){
        Photo photo = photoService.updatePhoto(id, request);

        return new ResponseEntity<>(photo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoto(@PathVariable long id){
        photoService.deletePhoto(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

