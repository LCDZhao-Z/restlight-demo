package demo.controller;


import esa.httpserver.core.AsyncRequest;
import esa.restlight.ext.multipart.annotation.FormParam;
import esa.restlight.ext.multipart.annotation.UploadFile;
import esa.restlight.ext.multipart.core.MultipartFile;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * FileUploadController
 *
 * @author duanwei
 * @date 2020/5/13 17:24
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @RequestMapping("/upload")
    public String fileUpload(@UploadFile MultipartFile file,
                             @FormParam String name,
                             @FormParam String address,
                             AsyncRequest request) throws IOException {
        System.out.println(file.file());
        System.out.println("Begin to upload...");
        file.transferTo(new File("D:\\abc\\" + file.originalFilename()));
        System.out.println("Upload successfully...");
        System.out.println(file.file());

        System.err.println(name);
        System.err.println(address);

        return file.originalFilename();
    }


}
