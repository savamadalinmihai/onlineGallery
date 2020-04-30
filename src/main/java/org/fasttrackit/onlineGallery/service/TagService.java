package org.fasttrackit.onlineGallery.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.onlineGallery.domain.Tag;
import org.fasttrackit.onlineGallery.exception.ResourceNotFoundException;
import org.fasttrackit.onlineGallery.persistance.PhotoRepository;
import org.fasttrackit.onlineGallery.persistance.TagRepository;
import org.fasttrackit.onlineGallery.transfer.tag.SaveTagRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TagService.class);

    private final TagRepository tagRepository;
    private final PhotoRepository photoRepository;
    private final ObjectMapper objectMapper;

    public TagService(TagRepository tagRepository, PhotoRepository photoRepository, ObjectMapper objectMapper) {
        this.tagRepository = tagRepository;
        this.photoRepository = photoRepository;
        this.objectMapper = objectMapper;
    }

    public Tag createTag(SaveTagRequest request){

        LOGGER.info("Creating tag {}", request);

        Tag tag = objectMapper.convertValue(request, Tag.class);

        return tagRepository.save(tag);
    }

    public Tag getTag(long id){
        LOGGER.info("Retreiving tag {}", id);

        return tagRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Customer " + id + " not found"));
    }
}
