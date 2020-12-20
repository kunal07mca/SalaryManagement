package com.nhpc.demo.service;


import org.springframework.web.multipart.MultipartFile;

/**
 * @author  Kunal Gupta
 */

public interface FileService {


    void store(MultipartFile file);


}
