package vn.iostar.services.impl;

import vn.iostar.dao.IVideoDao;
import vn.iostar.dao.impl.VideoDao;
import vn.iostar.entities.Video;
import vn.iostar.services.IVideoService;

import java.util.List;

public class VideoService implements IVideoService {

    IVideoDao vidDao = new VideoDao();

    @Override
    public int count() {
        return vidDao.count();
    }

    @Override
    public void insert(Video video) {
        vidDao.insert(video);
    }

    @Override
    public void update(Video video) {
        vidDao.update(video);
    }

    @Override
    public void delete(String videoid) throws Exception {
        vidDao.delete(videoid);
    }

    @Override
    public Video findById(String videoid) {
        return vidDao.findById(videoid);
    }

    @Override
    public List<Video> findAll(int page, int pagesize) {
        return vidDao.findAll(page, pagesize);
    }

    @Override
    public List<Video> findAllByCategoryId(int categoryid) {
        return vidDao.findAllByCategoryId(categoryid);
    }

    @Override
    public List<Video> findAll() {
        return vidDao.findAll();
    }

    @Override
    public List<Video> findByTitle(String title) {
        return vidDao.findByTitle(title);
    }
}
