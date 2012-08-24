package br.com.dedurando.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DDR_CATEGORY")
//@SequenceGenerator(name="SEG_GEN_CATEGORY", sequenceName="SEG_GEN_CATEGORY", allocationSize=1)
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CATEGORY_ID")
	@GeneratedValue//(generator="SEG_GEN_CATEGORY", strategy=GenerationType.SEQUENCE)
	private Long categoryId;
	
	/*@OneToMany
	@IndexColumn(name="CATEGORY_ID")
    @JoinColumn(name="CATEGORY_ID")
    private Category[] categories;
	
	public Category[] getCategories() {
		return categories;
	}

	public void setCategories(Category[] categories) {
		this.categories = categories;
	}*/

	@Column(name="NAME",length=30)
	private String name;
	
	@Column(name="STATUS")
	private int status;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status.getStatus();
	}

}
