package com.recap.carrental.core.utilities.fileHelpers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/files")
public class FileController {

    private final FileService filesService;

    @PostMapping(value = "/upload")
    public String uploadFile(@RequestParam("image") MultipartFile file) {
        return this.filesService.upload(file);
    }

    @GetMapping(value = "/download/{path:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable("path") String filename) {
        FileContainer container = this.filesService.download(filename);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(container.contentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, container.headerValue())
                .body(container.resource());
    }
}
