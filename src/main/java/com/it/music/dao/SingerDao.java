package com.it.music.dao;

import com.it.music.entity.Singer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 羡羡
 */
@Mapper
public interface SingerDao {
    /**
     * 查询所有歌手
     * @return
     */
    public List seall();

    /**
     * 歌手添加
     * @param sin
     * @return
     */
    public int singadd(Singer sin);

    /**
     * 查询所有显示首页随机
     * @return
     */
    public List seindx();

    /**
     * 根据歌手ID查询歌手
     * @param siid
     * @return
     */
    public Singer getSinger(int siid);

    public List seallsing();

    public List sedq(int siarea);

    public List sety(int sitype);

    public List sedqty(Singer se);

    public int singerupdate(Singer s);

    public int update(Singer s);

    public int singerdel(int siid);
}
