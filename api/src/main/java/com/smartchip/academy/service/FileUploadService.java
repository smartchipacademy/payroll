package com.smartchip.academy.service;

import com.smartchip.academy.dao.Fileupload;
import com.smartchip.academy.repository.FileuploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FileUploadService {

    @Autowired
    FileuploadRepository fileuploadRepository;

    public List<Fileupload> getAllFileupload() {
        return fileuploadRepository.findAll();
    }

    public Fileupload getFileuploadById(long id) {
        return fileuploadRepository.findById(id).orElse(null);
    }

    public Fileupload saveOrUpdataFileupload(Fileupload users) {
        return fileuploadRepository.save(users);
    }

    public void deleteFileupload(Long id) {
        fileuploadRepository.deleteById(id);
    }
}
