package com.recap.carrental.core.webApi.controllers;

import com.recap.carrental.core.business.abstracts.FileService;
import com.recap.carrental.core.utilities.fileHelpers.FileContainer;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "File")
@Hidden
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/core/files")
public class FileController {

    private final FileService filesService;

    @PostMapping(value = "/upload")
    public String uploadFile(@RequestParam("image") MultipartFile file) {
        return this.filesService.upload(file);
    }

    @DeleteMapping(value = "/delete/{path:.+}")
    public void delete(@PathVariable("path") String filename) {
        this.filesService.delete(filename);
    }

    @GetMapping(value = "/download/{path:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable("path") String filename) {
        FileContainer container = this.filesService.download(filename);
        return ResponseEntity.ok()
                .contentType(container.contentType())
                .body(container.imageData());
    }
}
