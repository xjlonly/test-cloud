package com.example.eureka;

import com.example.eureka.feign.UploadService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.http.MediaType;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public  class EurekaApplicationTests {



    @Test
    public void contextLoads() {
    }


//    @Autowired
//    private UploadService uploadService;
//    @Test
//    @SneakyThrows
//    public void  testHandleFileUpload(){
//        File file = new File("D:/upload.txt");
//        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file", MediaType.TEXT_PLAIN_VALUE,true,file.getName());
//        try(InputStream inputStream = new FileInputStream(file); OutputStream outputStream = fileItem.getOutputStream()){
//            IOUtils.copy(inputStream,outputStream);
//        }catch (Exception e){
//            throw new IllegalArgumentException("Invalid file: " + e, e);
//        }
//        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
//        log.info(uploadService.handleFileUpload(multipartFile));
//    }







}
