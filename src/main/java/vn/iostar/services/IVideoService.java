package vn.iostar.services;

import vn.iostar.entities.Video;

import java.util.List;

public interface IVideoService {
    int count();

    void insert(Video video);

    void update(Video video);

    void delete(String videoid) throws Exception;

    Video findById(String videoid);

    List<Video> findAll(int page, int pagesize);

    List<Video> findAllByCategoryId(int categoryid);

    List<Video> findAll();

    List<Video> findByTitle(String title);
}
