package vn.iostar.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="CATEGORIES")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")	//#?
public class Category implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//tang tu dong?
	@Column(name = "CategoryId")
	private int categoryId;

	@Column(name = "CategoryName", columnDefinition = "NVARCHAR(200) NOT NULL")
	@NotEmpty(message = "Must not be empty")
	private String categoryname;

	@Column(name = "Image", columnDefinition = "NVARCHAR(MAX)")
	private String image;

	@Column(name = "Status")
	private int status;

	@OneToMany(mappedBy = "category")
	private List<Video> videos;
	
	
	public Category() {
		// so empty..
	}
	
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}


	public Video addVideo(Video video) {
		getVideos().add(video);
		video.setCategory(this);

		return video;
	}

	public Video removeVideo(Video video) {
		getVideos().remove(video);
		video.setCategory(null);

		return video;
	}
}
