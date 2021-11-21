package com.it.music;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.it.music.tools.PayTools;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PayTest {

    @Test
    public void test(){
        // 生成指定url对应的二维码到文件，宽和高都是300像素
        QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file("d:/qrcode.jpg"));
    }



    @Test
    public void test1(){
        long time=System.currentTimeMillis();
        System.out.println(String.valueOf(time));
    }


    @Test
    public void test2(){
        String path=System.getProperty("user.dir");
        System.out.println(path);
    }


    @Test
    public void test4(){
        PayTools.PaymentVerification("20211121144346");
    }
}
