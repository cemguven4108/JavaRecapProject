package com.recap.carrental.core.utilities.fileHelpers;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

@Service
public class FileManager implements FileService{

    @Override
    public String upload(MultipartFile file) {
        String filePath = System.getProperty("user.dir") + "/Uploads" + File.separator + file.getOriginalFilename();
        String fileUploadStatus;

        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            outputStream.write(file.getBytes());

            outputStream.close();
            fileUploadStatus = "File uploaded Successfully";
        }
        catch (Exception exception) {
            exception.printStackTrace();
            fileUploadStatus = "Error in uploading file: " + exception;
        }
        return fileUploadStatus;
    }

    @Override
    public FileContainer download(String filename) {
        checkIfFileExists(filename);

        String fileUploadPath = System.getProperty("user.dir") + "/Uploads";

        String filePath = fileUploadPath + File.separator + filename;
        File file = new File(filePath);

        InputStreamResource resource = this.getResource(file);
        String contentType = "application/octet-stream";
        String headerValue = "attachment: filename=\"" + resource.getFilename() + "\"";

        return new FileContainer(
                contentType,
                headerValue,
                resource
        );
    }

    private String[] getFiles() {
        String folderPath = System.getProperty("user.dir") + "/Uploads";
        File directory = new File(folderPath);
        return directory.list();
    }

    private void checkIfFileExists(String filename) {
        String[] filenames = this.getFiles();
        if (!Arrays.asList(filenames).contains(filename)) {
            throw new RuntimeException("File Not Found");
        }
    }

    private InputStreamResource getResource(File file) {
        try {
            return new InputStreamResource(new FileInputStream(file));
        }
        catch (FileNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }
}
