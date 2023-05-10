package com.recap.carrental.core.utilities.fileHelpers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileManager implements FileService{

    @Value("${project.image-dir}")
    private String path;

    @Override
    public String upload(MultipartFile file) {
        String name = UUID.randomUUID() + "." + this.getFileExtension(file);
        String filePath = path + name;

        File imageFile = new File(path);
        if (!imageFile.exists()) {
            imageFile.mkdir();
        }

        try {
            Files.copy(file.getInputStream(), Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return filePath;
    }

    @Override
    public FileContainer download(String filename) {
        return null;
    }


    private String getFileExtension(MultipartFile file) {
        String filename = Objects.requireNonNull(file.getOriginalFilename());
        int index = filename.lastIndexOf('.');
        return filename.substring(index + 1);
    }
}
