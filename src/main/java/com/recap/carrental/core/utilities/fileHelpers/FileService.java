package com.recap.carrental.core.utilities.fileHelpers;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String upload(MultipartFile file);
    FileContainer download(String filename);
}
