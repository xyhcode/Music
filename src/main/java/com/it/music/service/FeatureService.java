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

    /**
     * 通过ID查询下指定的视频
     * @param feid
     * @return
     */
    public Feature findidvoid(int feid);

    /**
     * 浏览+1
     * @param feid
     * @return
     */
    public int browse(int feid);

    /**
     * 视频的总数
     * @return
     */
    public int fecount();

    /**
     * 查询所有视频
     * @return
     */
    public List seall();

    /**
     * 删除视频
     * @param feid
     * @return
     */
    public int defeid(int feid);
}
