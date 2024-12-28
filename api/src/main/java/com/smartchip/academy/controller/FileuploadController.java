package com.smartchip.academy.controller;

import com.smartchip.academy.dao.Fileupload;
import com.smartchip.academy.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/fileupload")
@CrossOrigin(maxAge = 3600)
public class FileuploadController {

    @Autowired
    FileUploadService fileUploadService;

    @Value("{filePath}")
    private static String basePath = "D:\\upload\\";


    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        try {
            // Ensure base directory exists
            File baseDir = new File(basePath);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }

            // Get original filename
            String originalFilename = multipartFile.getOriginalFilename();
            if (originalFilename == null || originalFilename.isEmpty()) {
                return "INVALID_FILE_NAME";
            }

            // Build full path
            Path path = Path.of(basePath, originalFilename);
            System.out.println("Saving file to: " + path);

            // Save file
            Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File uploaded successfully to: " + path.toString());
            System.out.println("File size: " + multipartFile.getSize() + " bytes");

            return "CREATED";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "FAILED";
        }
    }
}