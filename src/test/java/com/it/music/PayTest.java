package com.it.music;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.it.music.tools.PayTools;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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
        PayTools.PaymentVerification("20211123193634");
    }

    @Test
    public void test5(){
        PayTools.revokepay("20211123193608");
    }



    @Test
    public void testcre(){
        String cf= PayTools.getqrcode("10");
        System.out.println(cf);
    }


    @Test
    public void tes1(){
        String now = DateUtil.now();
        Date date = DateUtil.parse(now);
        DateTime newDate2 = DateUtil.offsetDay(date, 30);
        String formatDateTime = DateUtil.formatDateTime(newDate2);
        System.out.println(formatDateTime);
    }
}
