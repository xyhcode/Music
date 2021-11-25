package com.it.music.service.impl;

import com.it.music.dao.UserDao;
import com.it.music.entity.User;
import com.it.music.service.UserService;
import com.it.music.tools.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author 羡羡
 */
@Service
public class UserServiceimpl implements UserService {

    @Autowired
    UserDao usdao;

    @Override
    public User seone(int id) {
        User li=usdao.seone(id);
        return li;
    }

    @Override
    public User login(User user) {
        return usdao.login(user);
    }

    @Override
    public int alter(User user) {
        return usdao.alter(user);
    }

    @Override
    public int uscou() {
        int yh=usdao.uscount();
        return yh;
    }

    /**
     * 发送验证码
     * @param iphone 电话
     * @return
     */
    @Override
    public int vercode(String iphone) {
        int code;
        String Uid="xxxx";
        String Key="xxxxx";
        String smsMob = iphone;
        Random rd = new Random();
        int numbercode = rd.nextInt(999999 - 100000 + 1) + 100000;
        String smsText="您的验证码是："+numbercode+"，有效时间为1分钟，请尽快验证。该验证码仅用于身份验证，请勿泄漏给他人使用。";
        HttpClientUtil client=HttpClientUtil.getInstance();
        int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
        if(result>0){
            code=numbercode;
        }else{
            code=0;
        }
        return code;
    }

    @Override
    public int Userreg(User us) {
        int usnum=usdao.Userreg(us);
        return usnum;
    }

    @Override
    public User seiphone(String iphone) {
        User us=usdao.seiphone(iphone);
        return us;
    }


}
