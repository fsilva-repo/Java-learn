package com.web.app.domain;
import java.util.List;
import jakarta.persistence.*;
@Entity
@Table(name="categorys")
public class Category {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="title",nullable=false,unique=true)
	private String title;
	@OneToMany(mappedBy="category")
	private List<Promotion> promotions;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Promotion> getPromotions() {
		return promotions;
	}
	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}
}
