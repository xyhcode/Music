package com.it.music.tools;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.io.InputStream;
/**
 * 腾讯 COS 云储存
 * @author 羡羡
 */
public class CosFileupload {
    /**
     * SecretId 腾讯授权 ID
     */
    public static String SECRET_ID="xxxxxxx";
    /**
     * SECRET_KEY 腾讯授权秘钥
     */
    public static String SECRET_KEY="xxxxxxxx";
    /**
     * BUCKETNAME 储存库的名字
     */
    public static String BUCKETNAME="xxxxxxxx";
    /**
     * REGIONID 储存库的区域编号  ap-guangzhou：地区广州储存库
     */
    public static String REGIONID="xxxxxxxxxxxx";
    /**
     * 初始化配置信息
     * @return
     */
    public static COSClient Initialize(){
        /**
         * 初始化用户身份信息(secretId, secretKey)
         */
        COSCredentials cred = new BasicCOSCredentials(SECRET_ID, SECRET_KEY);
        /**
         * 设置 bucket 的区域 http 方式
         */
        ClientConfig clientConfig = new ClientConfig(new Region(REGIONID));
        /**
         * 生成 cos 客户端
         */
        COSClient cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }
    /**
     *文件上传
     * @param Inputstream  传文件流
     * @param key  为文件名 需要唯一
     */
    public static void upfile(InputStream Inputstream, String key){
        /**
         * 得到初始化的对象
         */
        COSClient cosin=CosFileupload.Initialize();
        ObjectMetadata metadata=new ObjectMetadata();
        PutObjectRequest request=new PutObjectRequest(BUCKETNAME,key,Inputstream,metadata);
        cosin.putObject(request);
        cosin.shutdown();
    }

    /**
     * 普通文件上传
     * @param filepath
     * @param filename
     */
    public static void ptfile(File filepath,String filename){
        COSClient cosin=CosFileupload.Initialize();
        PutObjectRequest request=new PutObjectRequest(BUCKETNAME, filename, filepath);
        cosin.putObject(request);
        cosin.shutdown();
    }


    /***
     * 下载文件
     * @param file 下载的路径
     * @param key  文件名
     */
    public static void downloadfile(File file,String key){
        /**
         * 指定下载的路径 + 文件名称
         */
        File dowfile=new File(file+"\\"+key);
        GetObjectRequest getobjrequest=new GetObjectRequest(BUCKETNAME,key);
        COSClient cosdowfile=CosFileupload.Initialize();
        cosdowfile.getObject(getobjrequest,dowfile);
        cosdowfile.shutdown();
    }
    /**
     * 删除文件
     * @param key 文件名
     */
    public static void delfile(String key){
        COSClient cosdelfile=CosFileupload.Initialize();
        cosdelfile.deleteObject(BUCKETNAME,key);
        cosdelfile.shutdown();
    }
}
