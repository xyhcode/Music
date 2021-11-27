package com.it.music.dao;

import com.it.music.entity.Feature;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 羡羡
 */
@Mapper
public interface FeatureDao {
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
     * 视频的总数
     * @return
     */
    public int fecount();

    /**
     * 浏览+1
     * @param feid
     * @return
     */
    public int browse(int feid);


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
