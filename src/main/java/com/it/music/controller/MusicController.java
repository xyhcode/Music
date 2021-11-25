package com.it.music.controller;

import cn.hutool.core.date.DateUtil;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.music.entity.Feature;
import com.it.music.entity.PayLog;
import com.it.music.entity.SingerAll;
import com.it.music.entity.User;
import com.it.music.service.*;
import com.it.music.tools.CosFileupload;
import com.it.music.tools.JsonResult;
import com.it.music.tools.PayTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 羡羡
 */
@Controller
public class MusicController {
    @Autowired
    SongTypeService soty;

    @Autowired
    SongListService solise;

    @Autowired
    SongService songse;

    @Autowired
    SingerService sinse;

    @Autowired
    FeatureService fese;

    @Autowired
    PayLogService pase;

    @Autowired
    UserService user;

    @GetMapping({"/", "/index", "index.html"})
    public String index(ModelMap mp){
        //显示首页的歌单类型
        List insoglis=soty.sein();
        mp.put("inso",insoglis);

        //歌单
        List solis=solise.seind();
        mp.put("songli",solis);

        //新歌
        List newsong=songse.songseing();
        mp.put("newsong",newsong);

        //热门歌手
        List hotsinger=sinse.seindx();
        mp.put("hotsin",hotsinger);

        //精选视频
        List felis=fese.seindex();
        mp.put("feli",felis);
        return "fontdesk/index";
    }

    /**
     * 更多视频
     * @param map
     * @return
     */
    @GetMapping("/morvide")
    public String morvid(ModelMap map){
        PageHelper.startPage(1,20);
        List lis=fese.sefe();
        PageInfo pa=new PageInfo(lis,10);
        map.put("pavo",pa);
        return "fontdesk/morevide";
    }

    /**
     * 视频分页
     * @param map
     * @param curr
     * @return
     */
    @RequestMapping(path = "/showvide/{curr}",method = RequestMethod.GET)
    public String show(ModelMap map, @PathVariable("curr") int curr){
        if(curr==0){
            curr=1;
        }
        PageHelper.startPage(curr,20);
        List lis=fese.sefe();
        PageInfo pa=new PageInfo(lis,10);
        map.put("pavo",pa);
        return "fontdesk/morevide";
    }

    /**
     * 点击视频进入视频详情
     * @param map
     * @param vid 视频的ID
     * @return
     */
    @RequestMapping(path = "/videtail/{vid}",method = RequestMethod.GET)
    public String viconf(ModelMap map,@PathVariable("vid") int vid){
        fese.browse(vid);
        Feature fea=fese.findidvoid(vid);
        map.put("features",fea);
        return "fontdesk/grvidetails";
    }

    /**
     * 更多歌手
     * @return
     */
    @RequestMapping(path="/morsinger/{sna}/{sia}/{sity}",method = RequestMethod.GET)
    public String mosing(ModelMap map, @PathVariable("sna") String sna, @PathVariable("sia") int sia, @PathVariable("sity") int sity){
        System.out.println("歌手字母："+sna+" "+"地区："+sia+" "+"歌手类型："+sity);
        /*List ls=sinse.seallsing();*/
        /*PageHelper.startPage(1,1);*/
       /* List lis=sinse.morsinger(ls,sna,sia,sity);*/
        List lis=sinse.morsinger(sna,sia,sity);
        /*PageInfo pa=new PageInfo(lis,10);*/
        map.put("mosin",lis);
        map.put("sna",sna);
        map.put("sia",sia);
        map.put("sity",sity);
        return "fontdesk/singer";
    }

    /**
     * 歌手详情
     * @return
     */
    @RequestMapping(path = "/singerdetails/{siid}",method = RequestMethod.GET)
    public String singdta(ModelMap map,@PathVariable("siid") int siid){
        SingerAll lis=songse.singerallsong(siid);
        map.put("singde",lis);
        return "fontdesk/singerdeta";
    }

    @ResponseBody
    @RequestMapping(path = "/singersc/{siid}",method = RequestMethod.POST)
    public JsonResult singdta2(@PathVariable("siid") int siid){
        SingerAll lis=songse.singerallsong(siid);
        JsonResult jr = new JsonResult(200,"查询成功！",lis.song);
        return jr;
    }

    /**
     * 搜索
     * @param map
     * @param srval
     * @return
     */
    @RequestMapping(path = "/search/{srval}")
    public String sreach(ModelMap map,@PathVariable("srval") String srval){
       List lis=songse.searchdong(srval);
       map.put("seval",srval);
       map.put("sr",lis);
        return "fontdesk/search";
    }

    /**
     * 进入二维码界面
     * @return
     */
    @RequestMapping("/ewm")
    public String em(){
        return "fontdesk/QrCode";
    }

    String je="";

    /**
     * 生成二维码
     * @return
     */
    @RequestMapping(path = "/creatqr/{pric}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult cf(@PathVariable String pric){
        System.out.println("je:"+je+" "+pric);
        JsonResult js;
        if(je.equals(pric)){
            js=new JsonResult(500,"失败！");
        }else{
            je=pric;
            String dir=PayTools.getqrcode(pric);
            js=new JsonResult(200,"成功！",dir);
        }
        return js;
    }

    /**
     * 轮询
     * @param order
     * @param request
     * @return
     */
    @RequestMapping(path = "/lunxuan/{order}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult pollingpay(@PathVariable String order,HttpServletRequest request){
        JsonResult js = null;
        //轮询查询是否支付
        AlipayTradeQueryResponse res=PayTools.PaymentVerification(order);
        //状态码判断是否支付
        if ("10000".equals(res.getCode()) && "Success".equals(res.getMsg()) && "TRADE_SUCCESS".equals(res.getTradeStatus())){
            //获取用户session
            User us= (User) request.getSession().getAttribute("user");
            //得到用户ID
            User usen=user.seone(us.getUsid());
            //得到当前时间
            String now = DateUtil.now();
            //判断它原来是否vip
            if(usen.getIsvip()==0){
                //不是 计算充值会员后的到期时间
               String vetime=PayTools.addtime(now,res.getTotalAmount());
               //修改数据库
                User usno=new User();
                usno.setUsid(us.getUsid());
                usno.setViptime(vetime);
                usno.setIsvip(1);
                int cf=user.alter(usno);
                if(cf>0){
                    User reus=user.seone(us.getUsid());
                    //添加支付log到数据库
                    PayLog pa=new PayLog(us.usid,res.getTotalAmount(),res.getOutTradeNo(),res.getTradeNo(),now);
                    int panum=pase.paylogadd(pa);
                    if(panum>0){
                        //更新session
                        request.getSession().setAttribute("user",reus);
                        js=new JsonResult(200,"支付成功！");
                    }else{
                        System.out.println("支付成功！数据载入错误！");
                    }
                    request.getSession().setAttribute("user",reus);
                }
                je="";
                //删除cos的二维码图片
                CosFileupload.delfile("music/payimg/"+order+".jpg");
                System.out.println("order:231"+" "+order);
            }else{
                String vnoetime=PayTools.addtime(us.getViptime(),res.getTotalAmount());
                User usno=new User();
                usno.setUsid(us.getUsid());
                usno.setViptime(vnoetime);
                usno.setIsvip(1);
                int cf=user.alter(usno);
                if(cf>0){
                    User reus=user.seone(us.getUsid());
                    PayLog pa=new PayLog(us.usid,res.getTotalAmount(),res.getOutTradeNo(),res.getTradeNo(),now);
                    int panum=pase.paylogadd(pa);
                    if(panum>0){
                        js=new JsonResult(200,"支付成功！");
                    }else{
                        System.out.println("支付成功！数据载入错误！");
                    }
                    request.getSession().setAttribute("user",reus);
                }
                je="";
                CosFileupload.delfile("music/payimg/"+order+".jpg");
                System.out.println("order:250"+" "+order);
            }
        }else {
            js=new JsonResult(500,"支付失败！");
        }
        return js;
    }

    /**
     * 撤销订单
     * @param order 订单号
     * @return
     */
    @RequestMapping(path = "/reorder/{order}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult ReturnOrder(@PathVariable String order){
        System.out.println("264:"+order);
        je="";
        JsonResult js;
        //撤销超时的订单 闭环
        AlipayTradeCancelResponse res=PayTools.revokepay(order);
        //撤销成功
        if ("10000".equals(res.getCode()) && "Success".equals(res.getMsg())){
            //删除cos图片
            CosFileupload.delfile("music/payimg/"+order+".jpg");
            js=new JsonResult(200,"撤销成功！");
        }else{
            js=new JsonResult(500,"撤销失败！");
        }
        return js;
    }

    /**
     * 进入vip充值界面
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(path="/Reinface",method = RequestMethod.GET)
    public String govip(HttpServletRequest request,ModelMap map){
        User reuse= (User) request.getSession().getAttribute("user");
        map.put("us",reuse);
        return "fontdesk/vip";
    }
}
