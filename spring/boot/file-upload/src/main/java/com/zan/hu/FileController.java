package com.zan.hu;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-17 15:54
 * @Description todo
 **/
@RestController
public class FileController {

    @PostMapping("/file")
    public void fileUpload(@RequestParam("commonsMultipartFiles") MultipartFile[] commonsMultipartFiles, String username) {
        System.out.println(commonsMultipartFiles.length + username);
    }
}
