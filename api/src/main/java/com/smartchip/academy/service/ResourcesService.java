package com.smartchip.academy.service;

import com.smartchip.academy.dao.Resources;
import com.smartchip.academy.repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ResourcesService {

    @Autowired
    ResourcesRepository resourcesRepository;

    public List<Resources> getAllResources() {

        return resourcesRepository.findAll();
    }

    public  Resources getResourcesById(long id) {

        return resourcesRepository.findById(id).orElse(null);
    }

    public  Resources saveOrUpdateResources(Resources resources) {

        return resourcesRepository.save(resources);
    }

    public void deleteResources(Long id) {
        resourcesRepository.deleteById(id);

    }
}
