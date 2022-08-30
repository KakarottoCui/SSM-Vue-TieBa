package com.basketboy.talking.service.impl;

import com.basketboy.talking.config.Config;
import com.basketboy.talking.pojo.ImageBean;
import com.basketboy.talking.service.ImageService;
import com.basketboy.talking.utils.FtpClientUtils;
import com.basketboy.talking.utils.IDUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public ImageBean upfileByUser(MultipartFile file, String userId) throws Exception {
        ImageBean imageBean = null;

        String filename = file.getOriginalFilename(); // 获得原始的文件名
        String newName = IDUtils.RandomId() + filename.substring(filename.lastIndexOf("."));

        InputStream input = file.getInputStream();
        FtpClientUtils a = new FtpClientUtils();
        FTPClient ftp = a.getConnectionFTP(Config.FTP_IP, 21, "ftpuser", "@@22xiao");
        boolean success = a.uploadFile(ftp, Config.FTP_IMAGE_PATH, newName, input);

        if (success) {
            String imgUrl = Config.FTP_HOST_PATH + newName;
            imageBean = new ImageBean();
            imageBean.setImgId(IDUtils.RandomId());
            imageBean.setImgUrl(imgUrl);
            imageBean.setUserId(userId);
            imageBean.setPageViews("0");
            imageBean.setUpTime(new Date());

            System.out.println(imgUrl);
        }

        a.closeFTP(ftp);

        return imageBean;
    }
}
