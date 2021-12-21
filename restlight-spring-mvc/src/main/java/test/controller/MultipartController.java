package test.controller;

import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestMapping;
import io.esastack.restlight.ext.multipart.annotation.FormParam;
import io.esastack.restlight.ext.multipart.annotation.UploadFile;
import io.esastack.restlight.ext.multipart.core.MultipartFile;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/multipart")
public class MultipartController {

    // 上传单个文件
    @RequestMapping("/upload")
    public String fileUpload(@UploadFile("multipartFile") MultipartFile multipartFile) throws IOException {
        File temp = new File("D:\\" + multipartFile.originalFilename() + "aaa");
        multipartFile.transferTo(temp);
        return "SUCCESS";
    }

    // 上传一组文件
    @RequestMapping("/uploads")
    public String fileUploads(@UploadFile("files") List<MultipartFile> files) throws IOException {
        for (MultipartFile file : files) {
            File temp = new File("D:\\" + file.originalFilename() + "bbb");
            file.transferTo(temp);
        }
        return "SUCCESS";
    }

    @RequestMapping("/attr")
    public String attr(@FormParam("attr") Integer attr) throws IOException {
        return attr.toString();
    }


}
