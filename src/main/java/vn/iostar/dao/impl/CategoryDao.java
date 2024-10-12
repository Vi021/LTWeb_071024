package vn.iostar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.iostar.configs.JPAConfig;
import vn.iostar.dao.ICategoryDao;
import vn.iostar.entities.Category;
import vn.iostar.entities.Video;

public class CategoryDao implements ICategoryDao{
	
	@Override
	public int count() {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT CỌUNT(c) FROM Category c";
        Query query = enma.createQuery(jpql);

        return ((Long) query.getSingleResult()).intValue();
    }
	
	@Override
	public void insert(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		
		try {
			trans.begin();
			
			enma.persist(category);
			
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
	public void update(Category category) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        
        try {
            trans.begin();
            
            enma.merge(category);
            
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
	public void delete(int categoryid) throws Exception {
//        EntityManager enma = JPAConfig.getEntityManager();
//        EntityTransaction trans = enma.getTransaction();
//
//        try {
//            trans.begin();
//
//            Category category = enma.find(Category.class, categoryid);
//            if (category != null) {
//                enma.remove(category);
//            } else {
//                throw new Exception("No matching category..");
//            }
//
//            trans.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            trans.rollback();
//
//            throw e;
//        } finally {
//            enma.close();
//        }

        deleteOnCascade(categoryid);
    }
	
	@Override
	public Category findById(int categoryid) {
        EntityManager enma = JPAConfig.getEntityManager();
        Category category = enma.find(Category.class, categoryid);
        
        return category;
    }
	
	@Override
	public List<Category> findAll(int page, int pagesize) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
        
        query.setFirstResult(page * pagesize);
        query.setMaxResults(pagesize);

        return query.getResultList();
    }
	
	@Override
	public List<Category> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
        
        return query.getResultList();
    }
	
	@Override
	public List<Category> findByCategoryname(String categoryname) {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT c FROM Category c WHERE c.categoryname like :catname";
        TypedQuery<Category> query = enma.createQuery(jpql, Category.class);
        
        query.setParameter("catname", "%" + categoryname + "%");

        return query.getResultList();
    }
	
	// delete all videos of that category before deleting the category itself
	public void deleteOnCascade(int categoryId) throws Exception {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        
        try {
            trans.begin();
            
            Category category = enma.find(Category.class, categoryId);
            if (category != null) {
                List<Video> videos = category.getVideos();
                if (videos != null && !videos.isEmpty()) {
                    for (Video video : videos) {
                        enma.remove(video);
                    }
                }
                enma.remove(category);
            } else {
                throw new Exception("No matching category..");
            }
            
            trans.commit();
        }catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            
            throw e;
        } finally {
            enma.close();
        }
    }
	
}
