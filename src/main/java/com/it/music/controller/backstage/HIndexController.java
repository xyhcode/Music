package com.it.music.controller.backstage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.music.entity.Singer;
import com.it.music.entity.Song;
import com.it.music.entity.SongType;
import com.it.music.service.PayLogService;
import com.it.music.service.SingerService;
import com.it.music.service.SongService;
import com.it.music.service.SongTypeService;
import com.it.music.tools.CosFileupload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author lingjing
 *
 */
@Controller
public class HIndexController {
    @Autowired
    SingerService singerService;
    @Autowired
    PayLogService pase;

@Autowired
SongService songService;
@Autowired
SongTypeService songTypeService;
    /**首页页面*/
    @RequestMapping({"/admin","/admin/index"})
    public String index(){
        System.out.println("admin index");
        return "/backstage/index";
    }

    /**用户管理页面*/
    @RequestMapping("/admin/user")
    public String user(){
        System.out.println("admin user");
        return "/backstage/user";
    }

    /**用户添加页面*/
    @RequestMapping("/admin/adduser")
    public String adduser(){
        System.out.println("admin adduser");
        return "/backstage/adduser";
    }






    /**歌曲管理页面*/
    @RequestMapping("/admin/song/{page}")
    public String song(ModelMap map, @PathVariable("page") int page){
        System.out.println("admin song");
        // 页码，每页多少条
        PageHelper.startPage(page,10);
        PageInfo info;
        List list=songService.seall();
        info = new PageInfo(list);
        System.out.println("总条数"+info.getTotal());
        System.out.println("总页数"+info.getPages());
        System.out.println("当前页"+info.getPageNum());
        int sz[]=info.getNavigatepageNums(); //得到导航页页码
        System.out.println("导航"+ Arrays.toString(sz));
        map.put("song",info);
        return "/backstage/song";
    }





    /**歌手管理页面*/
    @RequestMapping("/admin/singer/{page}")
    public String singer(ModelMap m,@PathVariable("page") String page){
        System.out.println("admin singer");
        int page1=0;
        if(page==null)
        {
            page1=1;
        }else
        {
            page1= Integer.parseInt(page);
        }
        PageHelper.startPage(page1,10);
        PageInfo info;
        List list = singerService.seall();
        info = new PageInfo(list);
        int sz[]=info.getNavigatepageNums(); //得到导航页页码
        //System.out.println(list);
        m.put("singer",info);

        return "/backstage/singer";
    }

    /**歌手修改页面*/
    @RequestMapping("/admin/updatesinger/{siid}")
    public String updatesinger(@PathVariable("siid") int siid,ModelMap m){
        Singer singer = singerService.getSinger(siid);
        m.put("singer",singer);
        System.out.println(singer);
        System.out.println("admin updatesinger");
        return "/backstage/updatesinger";
    }

    @RequestMapping("/admin/update/singer")
    public String file(int siid, String siname, String siintro,int siarea,int sitype,MultipartFile[] multipart) throws IOException {
        String siimg = "";
        Singer si = new Singer();
        ModelAndView mv = new ModelAndView();
            for (MultipartFile file : multipart) {
                //文件name
                String fname = file.getOriginalFilename();
                //得到时间戳
                Long time = System.currentTimeMillis();
                //找到.
                int wz = fname.lastIndexOf(".");
                //后缀名
                String filna = fname.substring(wz + 1);
                //System.out.println("后缀名：" + filna);
                //图片名字设置时间戳
                String pna = time + "." + filna;
                // System.out.println("图片名：" + pna);
                    CosFileupload.upfile(file.getInputStream(), "music/img/" + pna);
                    siimg = "https://sls-study-cloud-1301165591.cos.ap-guangzhou.myqcloud.com/music/img/" + pna;

            }
            si.setSiname(siname);
            si.setSiintro(siintro);
            si.setSiimg(siimg);
            si.setSiarea(siarea);
            si.setSitype(sitype);
            si.setSiid(siid);
            int n = singerService.singerupdate(si);
            return "redirect:/admin/singer/1";

    }

    /**歌手删除管理
     * @return*/
    @RequestMapping("/admin/singer/del/{siid}")
    public ModelAndView singerdel(@PathVariable("siid") int siid) {
        System.out.println(siid);
        int i=singerService.singerdel(siid);
        ModelAndView mv=new ModelAndView();
        if(i>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        mv.setViewName("redirect:/admin/singer/1");
        return mv;
    }

    /**歌手添加页面
     * @return*/
    @RequestMapping("/admin/findaddsinger")
    public String findaddsinger() {
        return "/backstage/addsinger";
    }
    /**歌手添加管理
     * @return*/
    @RequestMapping("/admin/addsinger")
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
        int siad=singerService.singadd(sin);
        if(siad>0){
            mv.setViewName("redirect:/admin/singer/1");
        }else{
            System.out.println("歌手数据库存入错误！");
        }
        return mv;
    }

    /**
     * 交易日志
     * @param map
     * @return
     */
    @RequestMapping("/admin/paylog")
    public String pay(ModelMap map){
        PageHelper.startPage(1,11);
        List lis=pase.sepaylog();
        PageInfo pa=new PageInfo(lis,10);
        map.put("payli",pa);
        return "backstage/paylog";
    }

    /**
     * 交易日志分页
     * @param map
     * @param curr
     * @return
     */
    @RequestMapping(path = "/paylog/{curr}",method = RequestMethod.GET)
    public String paypage(ModelMap map, @PathVariable("curr") int curr){
        PageHelper.startPage(curr,11);
        List lis=pase.sepaylog();
        PageInfo pa=new PageInfo(lis,10);
        map.put("payli",pa);
        return "backstage/paylog";
    }



    /**
     * 歌曲修改界面跳转
     * */
    @RequestMapping("/admin/update/song/{soid}")
    public String songupdate(@PathVariable("soid") int soid,ModelMap map){
        System.out.println("admin "+soid);
        Song song=songService.find(soid);
        map.put("song",song);
        return "/backstage/updatesong";
    }

    /**
     * 歌曲修改
     * */
    @RequestMapping("/admin/update/songupdate")
    public String file(int soid,int siid, String soname, String sotime, String publish,int sovip,MultipartFile[] multipart) throws IOException {
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
            System.out.println("我的file"+file);
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
        Song so=new Song(soid,siid,soname,mpadd,lryadd,simg,sotime,publish,sovip);
        int n=songService.update(so);
        if(n>0){
            System.out.println("修改成功");
        }else{
            System.out.println("歌曲数据库存入错误！");
        }
        return "redirect:/admin/song/1";

    }


    /**歌曲管理删除歌曲
     * @return*/
    @RequestMapping("/admin/song/del/{soid}")
    public String songdel(@PathVariable("soid") int id) {
        System.out.println(id);
        int i=songService.del(id);
        ModelAndView mv=new ModelAndView();
        if(i>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }

        return "redirect:/admin/song/1";
    }

    /**
     * 歌曲增加界面跳转
     * @return
     */
    @RequestMapping("/admin/add")
    public String add(){
        System.out.println("admin index");
        return "/backstage/addsong";
    }

    /**
     * 歌曲增加
     * @return
     */
    @RequestMapping("/admin/add/song")
    public String  songadd(int siid, String soname, String sotime, String publish,int sovip,MultipartFile[] multipart) throws IOException {
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

        Song so=new Song(siid,soname,mpadd,lryadd,simg,sotime,publish,sovip);
        int n=songService.songadd(so);
        if(n>0){
            System.out.println("成功");
        }else{
            System.out.println("歌曲数据库存入错误！");
        }
        return "redirect:/admin/song/1";
    }


    /**分类管理*/
    @RequestMapping("/admin/class/{page}")
    public String Classification(ModelMap map,@PathVariable("page") int page){

        // 页码，每页多少条
        PageHelper.startPage(page,10);
        PageInfo info;
        List list=songTypeService.sein();
        info = new PageInfo(list);
        System.out.println("总条数"+info.getTotal());
        System.out.println("总页数"+info.getPages());
        System.out.println("当前页"+info.getPageNum());
        int sz[]=info.getNavigatepageNums(); //得到导航页页码
        System.out.println("导航"+ Arrays.toString(sz));
        map.put("song",info);
        return "/backstage/Classification";
    }

    /**
     * 分类管理增加界面跳转
     */
    @RequestMapping("/admin/class/add")
    public String Classification() {
        return "/backstage/addsongclass";
    }
    /**
     * 分类管理增加
     */
    @RequestMapping("/admin/add/addclass")
    public String  addclass(String sotname,int sottype) throws IOException {
        System.out.println("分类增加");
        SongType stype=new SongType(sotname,sottype);
        int i=songTypeService.addclass(stype);
        if(i>0){
            System.out.println("插入成功");
        }else{
            System.out.println("失败");
        }
        return "redirect:/admin/class/1";
    }


    /**
     * 分类管理删除
     * */
    @RequestMapping("/admin/class/del/{sotid}")
    public String delclass(@PathVariable("sotid") int sotid) {
        System.out.println(sotid);
        int i=songTypeService.delclass(sotid);
        ModelAndView mv=new ModelAndView();
        if(i>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }

        return "redirect:/admin/class/1";
    }
    /**
     * 分类管理修改
     * */
    @RequestMapping("/admin/update/class/{sotid}")
    public String updatefind(@PathVariable("sotid") int sotid,ModelMap map){
        System.out.println("admin "+sotid);
        SongType stype=songTypeService.getSongType(sotid);
        System.out.println(stype);
        map.put("song",stype);
        return "/backstage/updatesongclass";
    }

    /**
     * 歌单修改
     * */
    @RequestMapping("/admin/update/updatesong")
    public String  updateclass(int sotid,String sotname,int sottype){
        SongType stype=new SongType(sotid,sotname,sottype);
        int i=songTypeService.updateclass(stype);
        if(i>0){
            System.out.println("修改成功");
        }else{
            System.out.println("失败");
        }
        return "redirect:/admin/class/1";
    }


}