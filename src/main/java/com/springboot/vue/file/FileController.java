package com.springboot.vue.file;

import com.springboot.util.ReturnData;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author MingTie
 * CreateDate：2017/8/20
 * Description：文件操作
 */
@SuppressWarnings("unchecked")
@RequestMapping("/Vue")
@RestController
public class FileController {

    @RequestMapping("/FileUpload")
    public Map fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        if (!multipartFile.isEmpty()) {
            try {
                this.saveFiles(multipartFile);
            } catch (Exception e) {
                e.printStackTrace();
                return ReturnData.setMessage(e.getMessage()).GetReturnMap();
            }
        } else {
            return ReturnData.setMessage("上传失败，因为文件是空的！").GetReturnMap();
        }
        return ReturnData.OkResult();
    }

    @RequestMapping("/Batch/FileUpload")
    public Map batchFileUpload(HttpRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        try {
            this.saveFiles(files);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnData.setMessage(e.getMessage()).GetReturnMap();
        }
        return ReturnData.OkResult();
    }
    
    private void saveFiles(Object object) throws IOException, ClassNotFoundException {
        BufferedOutputStream bufferedOutputStream = null;
        MultipartFile file;
        if (object instanceof List){
            List<MultipartFile> files = (List<MultipartFile>) object;
            for (int i = 0; i < files.size(); i++) {
                file = files.get(i);
                bufferedOutputStream = new BufferedOutputStream(
                        new FileOutputStream("uploadFile/" + file.getOriginalFilename()));
                bufferedOutputStream.write(file.getBytes());
            }
        } else if (object instanceof MultipartFile){
            file = (MultipartFile)object;
            bufferedOutputStream = new BufferedOutputStream(
                    new FileOutputStream("uploadFiles/" + file.getOriginalFilename()));
            bufferedOutputStream.write(file.getBytes());
        } else {
            throw new ClassNotFoundException();
        }
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }
    }
}
