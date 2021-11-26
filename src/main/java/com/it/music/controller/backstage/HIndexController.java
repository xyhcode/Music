package com.it.music.controller.backstage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.music.dao.SingerDao;
import com.it.music.entity.Singer;
import com.it.music.entity.Song;
import com.it.music.service.SingerService;
import com.it.music.service.impl.SingerServiceimpl;
import com.it.music.tools.CosFileupload;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.music.service.PayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.print.attribute.standard.Sides;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
    @RequestMapping("/admin/song")
    public String song(){
        System.out.println("admin song");
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

