package com.smartchip.academy.controller;


import com.smartchip.academy.dao.Videos;
import com.smartchip.academy.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
@CrossOrigin(maxAge =3600)

public class VideosController {

    @Autowired
    VideosService videosService;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping
    public List<Videos> getAllVideos() {
        return videosService.getAllVideos();
    }

    @GetMapping("/{id}")
    public Videos getVideosById(@PathVariable Long id) {
        return videosService.getVideosById(id);
    }

    @PostMapping
    public Videos createVideos(@RequestBody Videos videos) {
        System.out.println("videosController.createVideos");
        System.out.println("videos = " + videos);
        return videosService.saveOrUpdateVideos(videos);

    }

    @PutMapping("/{id}")
    public Videos updateVideos(@PathVariable Long id, @RequestBody Videos videos) {

        Videos existingVideos = videosService.getVideosById(id);
        if (existingVideos !=null) {

            existingVideos.setVideopath(videos.getVideopath());
            existingVideos.setExtension(videos.getExtension());
            existingVideos.setName(videos.getName());
            videosService.saveOrUpdateVideos(existingVideos);

        } else {
            return null;
        }
        return existingVideos;
    }

    @DeleteMapping("/{id}")
    public void deleteVideos(@PathVariable Long id) {
        videosService.deleteVideos(id);
    }

}
