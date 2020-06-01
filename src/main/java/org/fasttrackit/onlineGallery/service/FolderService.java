package org.fasttrackit.onlineGallery.service;

import org.fasttrackit.onlineGallery.domain.Folder;
import org.fasttrackit.onlineGallery.exception.ResourceNotFoundException;
import org.fasttrackit.onlineGallery.persistance.FolderRepository;
import org.fasttrackit.onlineGallery.transfer.folder.GetFolderRequest;
import org.fasttrackit.onlineGallery.transfer.folder.SaveFolderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FolderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FolderService.class);

    private final FolderRepository folderRepository;

    @Autowired
    public FolderService(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public Folder createFolder(SaveFolderRequest request) {
        LOGGER.info("Creating folder {}", request);

        Folder folder = new Folder();
        folder.setName(request.getName());
        folder.setUrl(request.getUrl());
        folder.setCreatedDate(request.getCreatedDate());

        return folderRepository.save(folder);
    }

    public Page<Folder> getFolders(GetFolderRequest request, Pageable pageable) {
        LOGGER.info("Retrieving folders {}", request);

        if (request != null) {
            if (request.getPartialName() != null) {
                return folderRepository.findByNameContaining(request.getPartialName(), pageable);
            }
        }
        return folderRepository.findAll(pageable);
    }

    public Folder getFolder(long id){
        LOGGER.info("Retrieving folder {}", id);

        return folderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Folder " + id + " not found."));
    }

    public Folder updateFolder(long id, SaveFolderRequest request){
        LOGGER.info("Updating folder {}: {}", id, request);

        Folder folder  = getFolder(id);

        BeanUtils.copyProperties(request, folder);

        return folderRepository.save(folder);
    }

    public void deleteFolder(long id) {
        LOGGER.info("Deleting folder {}", id);

        folderRepository.deleteById(id);
    }
}
