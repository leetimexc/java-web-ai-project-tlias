package com.example.controller;

import com.example.pojo.Result;
import com.example.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    /**
     * 本地磁盘存储的方案
     * @param file
     * @return
     */
    /* @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
        log.info("接受参数：{},{},{}", name, age, file);
        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();

        //新的文件名
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename = UUID.randomUUID().toString() + extension;

        String pathName = "/Users/li_shuai/我的代码/后端学习/Java项目实战/java-web-ai-project-tlias/tlias-web-management/images/";
        // 保存文件
        file.transferTo(new File(pathName + newFilename));
        return Result.success();
    } */

    /**
     * 阿里云 OSS 存储的方案
     * @param file
     * @return
     */
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传：{}", file.getOriginalFilename());
        // 将文件交给OSS存储管理
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("文件上传完成，返回访问地址：{}", url);


        return Result.success(url);
    }
}
