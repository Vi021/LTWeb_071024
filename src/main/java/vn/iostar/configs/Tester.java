package vn.iostar.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.iostar.entities.Category;
import vn.iostar.entities.Video;

public class Tester {
    public static void main(String[] args) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();

        
        
        Category cat = new Category();
        cat.setCategoryname("Iphone");
        cat.setImage("abc.jpg");
        cat.setStatus(true);

        Video vid = new Video();
        vid.setVideoid("v001");
        vid.setTitle("The Test");
        vid.setCategory(cat);

        try {
            trans.begin();
//            enma.persist(cat);
//            enma.persist(vid);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            enma.close();
        }
    }
}
