package org.fasttrackit.onlineGallery.web;

import org.fasttrackit.onlineGallery.domain.Photo;
import org.fasttrackit.onlineGallery.service.PhotoService;
import org.fasttrackit.onlineGallery.transfer.photo.GetPhotosRequest;
import org.fasttrackit.onlineGallery.transfer.photo.SavePhotoRequest;
import org.fasttrackit.onlineGallery.transfer.tag.GetTagRequest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
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

//        try {
//            String imgUrl = request.getImageData();
//            String newImgUrl = imgUrl.substring(28);
//            String imgPath = "src/main/resources/images/";
//            imgPath = imgPath + newImgUrl;
//            saveImage(imgUrl, imgPath);
//            request.setImageData(imgPath);
            Photo photo = photoService.createPhoto(request);
            return new ResponseEntity<>(photo, HttpStatus.CREATED);

//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }


    }

    private void saveImage(String imgUrl,String imgPath) throws IOException {

        String urlForFile = imgUrl;

        URL url = new URL(urlForFile);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(imgPath);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();

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

