package com.it.music.tools;

import java.io.*;
import java.net.URL;

public class JsonUtil {

    public static String getjson(String lrc) throws IOException {
        URL url = new URL(lrc);
        InputStream ins=url.openStream();
        InputStreamReader inputStream=new InputStreamReader(ins,"UTF-8");
        BufferedReader br = new BufferedReader(inputStream);
        LineNumberReader lnr = new LineNumberReader(br);
        String str;
        int rowNum = 0;

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
        return json1;
    }
}
