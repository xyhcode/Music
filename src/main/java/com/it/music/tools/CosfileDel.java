package com.it.music.tools;

/**
 * @Author: 羡羡
 * @Date: 2021/11/27/16:00
 */
public class CosfileDel {

    /**
     * 截取删除
     * @param attrs
     * @return
     */
    public static void returndeurl(String attrs){
       String cf=attrs.substring(attrs.indexOf("music"),attrs.length());
       CosFileupload.delfile(cf);
    }
}
