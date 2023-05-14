package com.recap.carrental.core.utilities.fileHelpers;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String upload(MultipartFile file);
    void delete(String filename);
    FileContainer download(String filename);
}
