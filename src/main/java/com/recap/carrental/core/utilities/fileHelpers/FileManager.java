package com.recap.carrental.core.utilities.fileHelpers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileManager implements FileService{

    @Value("${files.upload-dir}")
    private Path path;

    @Override
    public String upload(MultipartFile file) {
        String filename = UUID.randomUUID() + "." + this.getFileExtension(file);
        String filePath = System.getProperty("user.dir") + this.path + File.separator + filename;

        Path targetLocation = this.path.resolve(filePath);

        this.uploadToDestination(file, targetLocation);

        return filename;
    }

    @Override
    public byte[] download(String filename) {
        String filePath = System.getProperty("user.dir") + this.path + File.separator + filename;

        return this.getBytes(Path.of(filePath));
    }

    private void uploadToDestination(MultipartFile file, Path targetLocation) {
        try {
            if (!Files.isDirectory(targetLocation))
                Files.createDirectories(targetLocation);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] getBytes(Path fileUploadPath) {
        try {
            return new UrlResource(fileUploadPath.toUri()).getInputStream().readAllBytes();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String[] getFiles() {
        String folderPath = System.getProperty("user.dir") +"/Uploads";
        File directory = new File(folderPath);
        return directory.list();
    }

    private String getFileExtension(MultipartFile file) {
        String filename = Objects.requireNonNull(file.getOriginalFilename());
        int index = filename.lastIndexOf('.');
        return filename.substring(index + 1);
    }
}
