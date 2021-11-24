package com.it.music.service.impl;

import com.it.music.dao.PlayListDao;
import com.it.music.entity.Song;
import com.it.music.entity.SongSing;
import com.it.music.entity.UserSong;
import com.it.music.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayListServiceimpl implements PlayListService {

    @Autowired
    PlayListDao playListDao;

    /**
     * 查播放表所有歌曲
     * @param uid
     * @return
     */
    @Override
    public List getSongList(int uid) {
        return playListDao.getSongList(uid);
    }

    @Override
    public SongSing getSong(int sid) {
        return playListDao.getSong(sid);
    }

    @Override
    public List getSongs() {
        return playListDao.getSongs();
    }

    @Override
    public int addSong(UserSong us) {
        return playListDao.addSong(us);
    }

    @Override
    public UserSong selectSong(UserSong us) {
        return playListDao.selectSong(us);
    }

    @Override
    public int insertSongs(int uid,String[] str) {
        int n=0;
        List list=new ArrayList();
        for (int i=0;i<str.length;i++){
            int soid=Integer.parseInt(str[i]);
            UserSong us=playListDao.selectSong(new UserSong(uid,soid));
            if (us==null){
                n=playListDao.addSong(new UserSong(uid,soid));
            }
        }
        return n;
    }

    @Override
    public String[] getSingerSoid(int siid) {
        List list=playListDao.findSingerSong(siid);
        String[] str=new String[list.size()];
        for (int i=0;i< list.size();i++){
            Song z=(Song) list.get(i);
            str[i]=""+z.soid;
        }
        return str;
    }
}
