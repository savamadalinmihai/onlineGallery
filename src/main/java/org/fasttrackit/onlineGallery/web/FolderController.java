package org.fasttrackit.onlineGallery.web;


import org.fasttrackit.onlineGallery.domain.Folder;
import org.fasttrackit.onlineGallery.service.FolderService;
import org.fasttrackit.onlineGallery.transfer.folder.GetFolderRequest;
import org.fasttrackit.onlineGallery.transfer.folder.SaveFolderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RequestMapping("/folders")
@RestController
public class FolderController {

    private final FolderService folderService;

    @Autowired
    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @PostMapping
    public ResponseEntity<Folder> createFolder(@Valid @RequestBody SaveFolderRequest request){
        Folder folder = folderService.createFolder(request);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Folder> getFolder(@PathVariable long id){
        Folder folder = folderService.getFolder(id);
        return new ResponseEntity<>(folder, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Folder>> getFolders(GetFolderRequest request, Pageable pageable){
        Page<Folder> folders = folderService.getFolders(request, pageable);

        return new ResponseEntity<>(folders, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Folder> updateFolder(@PathVariable long id, @Valid SaveFolderRequest request){
        Folder folder = folderService.updateFolder(id, request);

        return new ResponseEntity<>(folder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFolder(@PathVariable long id){
      folderService.deleteFolder(id);

      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
