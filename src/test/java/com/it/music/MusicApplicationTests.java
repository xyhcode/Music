package com.it.music;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest
class MusicApplicationTests {
    /**
     * 测试远程读取cos文件
     * @throws IOException
     */
    @Test
    void contextLoads() throws IOException {
        String urlpath="https://sls-study-cloud-1301165591.cos.ap-guangzhou.myqcloud.com/music/lrc/ces.lrc";
        URL url = new URL(urlpath);
        InputStream ins=url.openStream();
        InputStreamReader inputStream=new InputStreamReader(ins,"UTF-8");
        BufferedReader br = new BufferedReader(inputStream);
        LineNumberReader lnr = new LineNumberReader(br);
        String str;
        String t;//时间
        String c;//歌词
        String jsons="{";

        while ((str = lnr.readLine())!=null){
            t=str.substring(0,10);
            c=str.substring(10);
            jsons+="\""+t+"\":"+"\""+c+"\",";
        }
        String json1=jsons.substring(0,jsons.length()-1)+"}";
        System.out.println(json1);
    }

}
