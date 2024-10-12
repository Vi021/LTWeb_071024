package vn.iostar.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.iostar.configs.JPAConfig;
import vn.iostar.dao.IVideoDao;
import vn.iostar.entities.Video;

import java.util.List;

public class VideoDao implements IVideoDao {

    @Override
    public int count() {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT CỌUNT(v) FROM Video v";
        Query query = enma.createQuery(jpql);

        return ((Long) query.getSingleResult()).intValue();
    }

    @Override
    public void insert(Video video) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();

        try {
            trans.begin();

            enma.persist(video);

            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();

            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void update(Video video) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();

        try {
            trans.begin();

            enma.merge(video);

            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();

            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void delete(String videoid) throws Exception {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();

        try {
            trans.begin();

            Video video = enma.find(Video.class, videoid);
            if (video != null) {
                enma.remove(video);
            } else {
                throw new Exception("No matching video..");
            }

            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();

            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public Video findById(String videoid) {
        EntityManager enma = JPAConfig.getEntityManager();
        Video video = enma.find(Video.class, videoid);

        return video;
    }

    @Override
    public List<Video> findAll(int page, int pagesize) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Video> query = enma.createNamedQuery("Video.findAll", Video.class);

        query.setFirstResult(page * pagesize);
        query.setMaxResults(pagesize);

        return query.getResultList();
    }

    @Override
    public List<Video> findAllByCategoryId(int categoryid) {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT v FROM Video v WHERE v.category.categoryid = :catId";
        TypedQuery<Video> query = enma.createQuery(jpql, Video.class);

        query.setParameter("catId", "%" + categoryid + "%");

        return query.getResultList();
    }

    @Override
    public List<Video> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Video> query = enma.createNamedQuery("Video.findAll", Video.class);

        return query.getResultList();
    }

    @Override
    public List<Video> findByTitle(String title) {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT v FROM Video v WHERE v.title like :title";
        TypedQuery<Video> query = enma.createQuery(jpql, Video.class);

        query.setParameter("title", "%" + title + "%");

        return query.getResultList();
    }
}
