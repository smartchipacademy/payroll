package com.smartchip.academy.service;


import com.smartchip.academy.dao.Videos;
import com.smartchip.academy.repository.VideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VideosService {

    @Autowired
    VideosRepository videosRepository;

    public List<Videos> getAllVideos() {
        return videosRepository.findAll();
    }

    public Videos getVideosById(long id) {
        return videosRepository.findById(id).orElse(null);
    }

    public Videos saveOrUpdateVideos(Videos videos) {
        return videosRepository.save(videos);
    }

    public void deleteVideos(Long id) {
        videosRepository.deleteById(id);
    }
}
