package com.basketboy.talking.service;

import com.basketboy.talking.pojo.ImageBean;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    ImageBean upfileByUser(MultipartFile file, String userId) throws Exception;
}
