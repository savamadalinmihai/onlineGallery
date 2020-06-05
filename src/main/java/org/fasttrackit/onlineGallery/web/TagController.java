package org.fasttrackit.onlineGallery.web;

import org.fasttrackit.onlineGallery.domain.Tag;
import org.fasttrackit.onlineGallery.service.TagService;
import org.fasttrackit.onlineGallery.transfer.tag.GetTagRequest;
import org.fasttrackit.onlineGallery.transfer.tag.SaveTagRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RequestMapping("/tag")
@RestController
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public ResponseEntity<Tag> createTag(@Valid @RequestBody SaveTagRequest request){
        Tag tag = tagService.createTag(request);
        return new ResponseEntity<>(tag, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTag(@PathVariable long id){
        Tag tag = tagService.getTag(id);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Tag>> getTags(GetTagRequest request, Pageable pageable){
        Page<Tag> tags = tagService.getTags(request, pageable);
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable long id, @Valid SaveTagRequest request){
        Tag tag = tagService.updateTag(id, request);

        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable long id){
        tagService.deleteTag(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
