package com.ybzbcq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class UploadContoller {

    // logback
    private final static Logger logger = LoggerFactory.getLogger(UploadContoller.class);

    /**
     * 初始化文件上传界面， 跳转到 upload.jsp 界面
     * @return 文件上传路径
     */
    @RequestMapping(value = "/uploadView", method = RequestMethod.GET)
    public String uploadView(){
        return "upload";
    }

    /**
     * 文件上传方法实现
     * @param request 请求对象
     * @param file 前台文件上传的对象
     * @return 上传结果
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(HttpServletRequest request, MultipartFile file){

        try {

            String uploadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";
            File dir = new File(uploadDir);

            if(!dir.exists()){
                dir.mkdir();
            }
            executeUpload(file, uploadDir);

        } catch (IOException e) {
            e.printStackTrace();
            return "upload failure.";
        }

        return "upload success.";
    }

    private void executeUpload(MultipartFile file, String uploadDir) throws IOException {
        String originalFilename = file.getOriginalFilename();
        if(StringUtils.isEmpty(originalFilename)){
            return;
        }
        System.out.println("File name: " + originalFilename);
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filename = UUID.randomUUID()+suffix;

        File uploadFile = new File(uploadDir+filename);

        file.transferTo(uploadFile);
    }

    @RequestMapping(value = "/uploads", method = RequestMethod.POST)
    @ResponseBody
    public String uploads(HttpServletRequest request, MultipartFile[] file){

        try {

            String uploadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";
            File dir = new File(uploadDir);

            if(!dir.exists()){
                dir.mkdir();
            }
            /*String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String filename = UUID.randomUUID()+suffix;
            File uploadFile = new File(uploadDir+filename);
            file.transferTo(uploadFile);*/
            for (int i =0; i < file.length; i++){
                MultipartFile fileTemp = file[i];
                if(fileTemp != null){
                    executeUpload(fileTemp, uploadDir);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "uploads failure.";
        }

        return "uploads success.";
    }
}
