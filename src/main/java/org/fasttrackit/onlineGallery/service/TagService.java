package org.fasttrackit.onlineGallery.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.onlineGallery.domain.Tag;
import org.fasttrackit.onlineGallery.exception.ResourceNotFoundException;
import org.fasttrackit.onlineGallery.persistance.PhotoRepository;
import org.fasttrackit.onlineGallery.persistance.TagRepository;
import org.fasttrackit.onlineGallery.transfer.tag.GetTagRequest;
import org.fasttrackit.onlineGallery.transfer.tag.SaveTagRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Tag> getTags(GetTagRequest request, Pageable pageable) {
        LOGGER.info("Searching for tags {}", request);

        if (request != null) {
            if (request.getPartialName() != null) {
                return tagRepository.findByNameContaining(request.getPartialName(), pageable);
            }
        }
        return tagRepository.findAll(pageable);
    }

    public Tag updateTag(long id, SaveTagRequest request){
        LOGGER.info("Updating tag {}: {}", id, request);

        Tag tag  = getTag(id);

        BeanUtils.copyProperties(request, tag);

        return tagRepository.save(tag);
    }

    public void deleteTag(long id) {
        LOGGER.info("Deleting tag {}", id);

        tagRepository.deleteById(id);
    }

}
