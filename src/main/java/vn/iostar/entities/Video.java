package vn.iostar.entities;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="VIDEOS")
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable{
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="VideoId")
	private String videoId;
	
	@Column(name="Active")
	private boolean active;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Poster")
	private String poster;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Views")
	private int views;
	
	
}
