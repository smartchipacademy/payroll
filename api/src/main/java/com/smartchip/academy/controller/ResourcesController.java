package com.smartchip.academy.controller;

import com.smartchip.academy.dao.Resources;
import com.smartchip.academy.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
@CrossOrigin(maxAge = 3600)

public class ResourcesController {

    @Autowired
    ResourcesService resourcesService;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping
    public List<Resources> getAllResources() {
        return resourcesService.getAllResources();
    }

    @GetMapping("/{id}")
    public Resources getResourcesById(@PathVariable Long id) {
        return resourcesService.getResourcesById(id);
    }

    @PostMapping
    public Resources createResources(@RequestBody Resources resources) {
        System.out.println("resourcesController.createResources");
        System.out.println("resources = + resources");
        return resourcesService.saveOrUpdateResources(resources);
    }

    @PutMapping("/{id}")
    public Resources updateResources(@PathVariable Long id, @RequestBody Resources resources) {

        Resources existingResources = resourcesService.getResourcesById(id);
        if (existingResources !=null) {

            existingResources.setResourcepath(resources.getResourcepath());
            existingResources.setName(resources.getName());
            resourcesService.saveOrUpdateResources(existingResources);


        } else {
            return null;
        }
        return existingResources;
    }

    @DeleteMapping("/{id}")
    public void deleteResources(@PathVariable Long id) {
        resourcesService.deleteResources(id);
    }
}
