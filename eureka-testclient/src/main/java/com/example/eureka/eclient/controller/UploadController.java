package com.example.eureka.eclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@RestController
public class UploadController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping(value = "/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file")MultipartFile file){
        logger.info("upload service is requested : {}",file.getName());
        return file.getName();
    }
}
