package vn.iostar.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Video.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Video_ {

	public static final String QUERY_VIDEO_FIND_ALL = "Video.findAll";
	public static final String ACTIVE = "active";
	public static final String DESCRIPTION = "description";
	public static final String VIDEOID = "videoid";
	public static final String TITLE = "title";
	public static final String CATEGORY = "category";
	public static final String POSTER = "poster";
	public static final String VIEWS = "views";

	
	/**
	 * @see vn.iostar.entities.Video#active
	 **/
	public static volatile SingularAttribute<Video, Boolean> active;
	
	/**
	 * @see vn.iostar.entities.Video#description
	 **/
	public static volatile SingularAttribute<Video, String> description;
	
	/**
	 * @see vn.iostar.entities.Video#videoid
	 **/
	public static volatile SingularAttribute<Video, String> videoid;
	
	/**
	 * @see vn.iostar.entities.Video#title
	 **/
	public static volatile SingularAttribute<Video, String> title;
	
	/**
	 * @see vn.iostar.entities.Video#category
	 **/
	public static volatile SingularAttribute<Video, Category> category;
	
	/**
	 * @see vn.iostar.entities.Video
	 **/
	public static volatile EntityType<Video> class_;
	
	/**
	 * @see vn.iostar.entities.Video#poster
	 **/
	public static volatile SingularAttribute<Video, String> poster;
	
	/**
	 * @see vn.iostar.entities.Video#views
	 **/
	public static volatile SingularAttribute<Video, Integer> views;

}

