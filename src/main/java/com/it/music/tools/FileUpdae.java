package com.it.music.tools;

import com.it.music.entity.Feature;
import com.it.music.entity.Singer;
import com.it.music.entity.Song;
import com.it.music.service.FeatureService;
import com.it.music.service.SingerService;
import com.it.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * @author 羡羡
 */
@Controller
public class FileUpdae {

    @Autowired
    SongService soser;

    @Autowired
    SingerService singer;

    @Autowired
    FeatureService fese;

    @RequestMapping("/fjq")
    public String fi(){
        return "fontdesk/fileupda";
    }

    /**
     * 存歌曲
     * @param siid
     * @param soname
     * @param sotime
     * @param publish
     * @param multipart
     * @return
     * @throws IOException
     */
    @RequestMapping("/ftest")
    public ModelAndView file(int siid, String soname, String sotime, String publish,int sovip,MultipartFile[] multipart) throws IOException {
        String mpadd="";
        String lryadd="";
        String simg="";
        for(MultipartFile file : multipart){
            //文件name
            String fname=file.getOriginalFilename();
            //得到时间戳
            Long time=System.currentTimeMillis();
            //找到.
            int wz=fname.lastIndexOf(".");
            //后缀名
            String filna=fname.substring(wz+1);
            System.out.println("后缀名："+filna);
            //图片名字设置时间戳
            String pna=time+"."+filna;
            System.out.println("图片名："+pna);

            //存音频
            if(file.getOriginalFilename().endsWith(".mp3") || file.getOriginalFilename().endsWith(".flac")){
                try{
                    CosFileupload.upfile(file.getInputStream(),"music/mp3/"+pna);
                    mpadd="https://sls-study-cloud-1301165591.cos.ap-guangzhou.myqcloud.com/music/mp3/"+pna;
                }catch(Exception ex){
                    System.out.println("音乐存入失败！"+ex.getMessage());
                }

                //保存歌词
            }else if(file.getOriginalFilename().endsWith(".lrc")){
                try {
                    CosFileupload.upfile(file.getInputStream(),"music/lrc/"+pna);
                    lryadd="https://sls-study-cloud-1301165591.cos.ap-guangzhou.myqcloud.com/music/lrc/"+pna;
                }catch (Exception ex){
                    System.out.println("歌词存入失败！"+ex.getMessage());
                }
            }else{
                //图片
                CosFileupload.upfile(file.getInputStream(),"music/img/"+pna);
                simg="https://sls-study-cloud-1301165591.cos.ap-guangzhou.myqcloud.com/music/img/"+pna;
            }
        }
        ModelAndView mv=new ModelAndView();
        Song so=new Song(siid,soname,mpadd,lryadd,simg,sotime,publish,sovip);
        int n=soser.songadd(so);
        if(n>0){
            mv.setViewName("redirect:fjq");
        }else{
            System.out.println("歌曲数据库存入错误！");
        }
        return mv;
    }

    /**
     * 上传歌手
     * @param siname
     * @param siintro
     * @param siarea
     * @param sitype
     * @param multipart
     * @return
     * @throws IOException
     */
    @RequestMapping("/singer")
    public ModelAndView Singeradd(String siname,String siintro,int siarea,int sitype,MultipartFile[] multipart) throws IOException {
        String siimg="";
        ModelAndView mv=new ModelAndView();
        for(MultipartFile file : multipart){
            //文件name
            String fname=file.getOriginalFilename();
            //得到时间戳
            Long time=System.currentTimeMillis();
            //找到.
            int wz=fname.lastIndexOf(".");
            //后缀名
            String filna=fname.substring(wz+1);
            System.out.println("后缀名："+filna);
            //图片名字设置时间戳
            String pna=time+"."+filna;
            System.out.println("图片名："+pna);
            CosFileupload.upfile(file.getInputStream(),"music/img/"+pna);
            siimg="https://sls-study-cloud-1301165591.cos.ap-guangzhou.myqcloud.com/music/img/"+pna;
        }
        Singer sin=new Singer(siname,siintro,siimg,siarea,sitype);
        int siad=singer.singadd(sin);
        if(siad>0){
            mv.setViewName("redirect:fjq");
        }else{
            System.out.println("歌手数据库存入错误！");
        }
        return mv;
    }

    /**
     * 上传视频
     * @param fetitle
     * @param feplays
     * @param multipart
     * @return
     */
    @RequestMapping("/video")
    public ModelAndView vo(String fetitle,int feplays,MultipartFile[] multipart) throws IOException {
        ModelAndView mv=new ModelAndView();
        String feurl="";
        for(MultipartFile file : multipart) {
            //文件name
            String fname = file.getOriginalFilename();
            //得到时间戳
            Long time = System.currentTimeMillis();
            //找到.
            int wz = fname.lastIndexOf(".");
            //后缀名
            String filna = fname.substring(wz + 1);
            System.out.println("后缀名：" + filna);
            //图片名字设置时间戳
            String pna = time + "." + filna;
            System.out.println("图片名：" + pna);
            CosFileupload.upfile(file.getInputStream(),"music/voide/"+pna);
            feurl="https://sls-study-cloud-1301165591.cos.ap-guangzhou.myqcloud.com/music/voide/"+pna;
        }
        Feature fe=new Feature(fetitle,feurl,feplays,"");
        int ff=fese.inadd(fe);
        if(ff>0){
            mv.setViewName("redirect:fjq");
        }else{
            System.out.println("视频上传错误！");
        }
        return mv;
    }
}
