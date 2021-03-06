package com.it.music.service.impl;

import com.it.music.dao.FeatureDao;
import com.it.music.entity.Feature;
import com.it.music.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeatureServiceimpl implements FeatureService {

    @Autowired
    FeatureDao fdao;

    @Override
    public List sefe() {
       List lis=fdao.sefe();
        return lis;
    }

    @Override
    public int inadd(Feature fe) {
        int fein=fdao.inadd(fe);
        return fein;
    }

    @Override
    public List seindex() {
        List lis=fdao.seindex();
        return lis;
    }

    @Override
    public Feature findidvoid(int feid) {
        Feature fe=fdao.findidvoid(feid);
        return fe;
    }

    @Override
    public int browse(int feid) {
        return fdao.browse(feid);
    }

    @Override
    public int fecount() {
        int fcount=fdao.fecount();
        return fcount;
    }

    @Override
    public List seall() {
        List lis=fdao.seall();
        return lis;
    }

    @Override
    public int defeid(int feid) {
       int vid= fdao.defeid(feid);
        return vid;
    }
}
