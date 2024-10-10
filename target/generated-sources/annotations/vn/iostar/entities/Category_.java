package vn.iostar.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Category.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Category_ {

	public static final String IMAGE = "image";
	public static final String QUERY_CATEGORY_FIND_ALL = "Category.findAll";
	public static final String CATEGORYNAME = "categoryname";
	public static final String VIDEOS = "videos";
	public static final String CATEGORYID = "categoryid";
	public static final String STATUS = "status";

	
	/**
	 * @see vn.iostar.entities.Category#image
	 **/
	public static volatile SingularAttribute<Category, String> image;
	
	/**
	 * @see vn.iostar.entities.Category#categoryname
	 **/
	public static volatile SingularAttribute<Category, String> categoryname;
	
	/**
	 * @see vn.iostar.entities.Category#videos
	 **/
	public static volatile ListAttribute<Category, Video> videos;
	
	/**
	 * @see vn.iostar.entities.Category
	 **/
	public static volatile EntityType<Category> class_;
	
	/**
	 * @see vn.iostar.entities.Category#categoryid
	 **/
	public static volatile SingularAttribute<Category, Integer> categoryid;
	
	/**
	 * @see vn.iostar.entities.Category#status
	 **/
	public static volatile SingularAttribute<Category, Boolean> status;

}

