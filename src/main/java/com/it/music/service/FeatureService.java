package com.it.music.service;

import com.it.music.entity.Feature;

import java.util.List;

/**
 * @author 羡羡
 */
public interface FeatureService {
    /**
     * 查询所有视频
     * @return
     */
    public List sefe();

    /**
     * 添加视频
     * @param fe
     * @return
     */
    public int inadd(Feature fe);

    /**
     * 随机查询视频
     */
    public List seindex();
}
