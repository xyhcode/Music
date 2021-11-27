package com.it.music.controller.backstage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.music.entity.Feature;
import com.it.music.entity.Singer;
import com.it.music.entity.Song;
import com.it.music.entity.SongType;
import com.it.music.service.*;
import com.it.music.tools.CosFileupload;
import com.it.music.tools.CosfileDel;
import com.it.music.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    UserService use;

    @Autowired
    SongTypeService songTypeService;

    @Autowired
    FeatureService fese;

    /**首页页面*/
    @RequestMapping({"/admin","/admin/index"})
    public String index(){
        System.out.println("admin index");
        return "/backstage/index";
    }



    /**用户添加页面*/
    @RequestMapping("/admin/adduser")
    public String adduser(){
        System.out.println("admin adduser");
        return "/backstage/adduser";
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


    /**歌曲管理页面*/
    @RequestMapping("/admin/song")
    public String song(ModelMap map){
        PageHelper.startPage(1,5);
        List list=songService.seall();
        System.out.println(list);
        PageInfo pa=new PageInfo(list,10);
        map.put("song",pa);
        return "/backstage/song";
    }

    /**
     * 歌曲分页
     * @param map
     * @param curr
     * @return
     */
    @RequestMapping(path = "/songma/{curr}",method = RequestMethod.GET)
    public String sonpa(ModelMap map, @PathVariable int curr){
        PageHelper.startPage(curr,5);
        List list=songService.seall();
        PageInfo pa=new PageInfo(list,10);
        map.put("song",pa);
        return "/backstage/song";
    }

    /**
     * 歌曲删除
     * @param soid
     * @return
     */
    @RequestMapping(path = "/songma/songdel/{soid}")
    @ResponseBody
    public JsonResult songdel(@PathVariable int soid){
        System.out.println(soid);
        JsonResult js;
        Song so=songService.getSong(soid);
        int cf=songService.del(soid);
        if(cf>0){
            if(so.getSoimg()!=null){
                CosfileDel.returndeurl(so.getSoimg());
            }
            if(so.getLyrics()!=null){
                CosfileDel.returndeurl(so.getLyrics());
            }
            if(so.getSolink()!=null){
                CosfileDel.returndeurl(so.getSolink());
            }
            js=new JsonResult(200,"删除成功！");
        }else{
            js=new JsonResult(500,"删除失败！");
        }
       return js;
    }

    /**
     * 用户管理
     * @param map
     * @return
     */
    @RequestMapping("/admin/user")
    public String usman(ModelMap map){
        PageHelper.startPage(1,4);
        List lis=use.sauseall();
        PageInfo pa=new PageInfo(lis,10);
        map.put("um",pa);
        return "/backstage/user";
    }

    /**
     * 用户分页
     * @param map
     * @param curr
     * @return
     */
    @RequestMapping("/userma/{curr}")
    public String userpa(ModelMap map, @PathVariable int curr){
        PageHelper.startPage(curr,4);
        List lis=use.sauseall();
        PageInfo pa=new PageInfo(lis,10);
        map.put("um",pa);
        return "/backstage/user";
    }

    /**
     * 视频管理
     * @param map
     * @return
     */
    @RequestMapping("/admin/video")
    public String videall(ModelMap map){
        PageHelper.startPage(1,3);
        List lis=fese.seall();
        PageInfo pa=new PageInfo(lis,10);
        map.put("vide",pa);
        return "/backstage/vide";
    }

    /**
     * 视频管理分页
     * @param mp
     * @param curr
     * @return
     */
    @RequestMapping("/video/{curr}")
    public String vipa(ModelMap mp, @PathVariable int curr){
        PageHelper.startPage(curr,3);
        List lis=fese.seall();
        PageInfo pa=new PageInfo(lis,10);
        mp.put("vide",pa);
        return "/backstage/vide";
    }

    /**
     * 视频管理删除
     * @param feid
     * @return
     */
    @RequestMapping("/admin/vide/{feid}")
    @ResponseBody
    public JsonResult devid(@PathVariable int feid){
        System.out.println("feid："+feid);
        JsonResult js;
        Feature fe=fese.findidvoid(feid);
        int desu=fese.defeid(feid);
        if(desu>0){
            if(fe.getFeurl()!=null){
                CosfileDel.returndeurl(fe.getFeurl());
            }
            if(fe.getCover()!=null){
                CosfileDel.returndeurl(fe.getCover());
            }
            js=new JsonResult(200,"删除成功！");
        }else{
            js=new JsonResult(500,"删除失败！");
        }
        System.out.println(js);
        return  js;
    }

    /**
     * 视频添加
     * @param fetitle
     * @param multipart
     * @return
     * @throws IOException
     */
    @RequestMapping("/voide/add")
    public ModelAndView vad(String fetitle,MultipartFile[] multipart) throws IOException {
        ModelAndView mv=new ModelAndView();
        String mpurl = null;
        String imurl = null;
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

            if(file.getOriginalFilename().endsWith(".mp4")){
                CosFileupload.upfile(file.getInputStream(),"music/voide/"+pna);
                mpurl="https://sls-study-cloud-1301165591.cos.ap-guangzhou.myqcloud.com/music/voide/"+pna;
            }else {
                CosFileupload.upfile(file.getInputStream(),"music/img/"+pna);
                imurl="https://sls-study-cloud-1301165591.cos.ap-guangzhou.myqcloud.com/music/img/"+pna;
            }
        }
        Feature fe=new Feature(fetitle,mpurl,0,imurl);
        System.out.println("Fe:"+fe);
        int fesu=fese.inadd(fe);
        if(fesu>0){
            mv.setViewName("redirect:/admin/video");
        }else{
            System.out.println("视频添加错误！");
        }
        return mv;
    }

    /******************************************************************************************/

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
    public String file(ModelMap mm,int siid, String siname, String siintro,int siarea,int sitype,MultipartFile[] multipart) throws IOException {
        String siimg = "";
        Singer si = new Singer();
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
            mm.put("addis",n);
            return "redirect:/admin/singer/1";

    }

    /**歌手删除管理
     * @return*/
    @ResponseBody
    @RequestMapping("/admin/singer/del/{siid}")
    public JsonResult singerdel(@PathVariable("siid") int siid) {
        System.out.println(siid);
        JsonResult js = null;
        List solist = songService.issinger(siid);
        if(solist.size()!=0){
            return new JsonResult(501,"删除失败！，该歌手还有歌曲没删除！");
        }
        Singer sig = singerService.getSinger(siid);
        int i=singerService.singerdel(siid);
        if(i>0){
            String del = sig.getSiimg().substring(sig.getSiimg().indexOf("music/img/"), sig.getSiimg().length());
            //删除图片
            CosFileupload.delfile(del);
            js=new JsonResult(200,"删除成功！");
        }else{
            js=new JsonResult(500,"删除失败！");
        }
        return js;
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

    /**
     * 歌曲增加界面跳转
     * @return
     */
    @RequestMapping("/admin/add")
    public String add(ModelMap mm){
        System.out.println("admin index");
        List siall = singerService.seall();
        mm.put("siall",siall);
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
        return "redirect:/admin/song";
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
    @ResponseBody
    @RequestMapping("/admin/class/del/{sotid}")
    public JsonResult delclass(@PathVariable("sotid") int sotid) {
        System.out.println(sotid);
        JsonResult js = null;
        int i=songTypeService.delclass(sotid);
        if(i>0){
            js=new JsonResult(200,"删除成功！");
        }else{
            js=new JsonResult(500,"删除失败！");
        }
        return js;
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