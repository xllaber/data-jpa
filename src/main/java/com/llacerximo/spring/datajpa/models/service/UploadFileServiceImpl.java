package com.llacerximo.spring.datajpa.models.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements UploadFileService{

    private Logger log = LoggerFactory.getLogger(getClass());
    private final String UPLOADS = "uploads";

    @Override
    public Resource load(String filename) throws MalformedURLException {
        Path pathImg = getPath(filename);
        log.info("IMG PATH: " + pathImg);
        Resource resource = new UrlResource(pathImg.toUri());
        if (!resource.exists() || !resource.isReadable()) {
            throw new RuntimeException("Cannot read file: " + pathImg);
        }
        return resource;
    }

    @Override
    public String copy(MultipartFile file) throws IOException {
        String uniqueFilename = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path rootAbsolutePath = getPath(uniqueFilename);
        log.info("path: " + rootAbsolutePath);
        Files.copy(file.getInputStream(), rootAbsolutePath);
        return uniqueFilename;
    }

    @Override
    public boolean delete(String filename) {
        Path rootPath = getPath(filename);
        File file = rootPath.toFile();
        if (file.exists() && file.canRead()){
            file.delete();
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(Paths.get(UPLOADS).toFile());
    }

    @Override
    public void init() throws IOException {
        Files.createDirectory(Paths.get(UPLOADS));
    }

    public Path getPath(String filename) {
        return Paths.get(UPLOADS).resolve(filename).toAbsolutePath();
    }
}
