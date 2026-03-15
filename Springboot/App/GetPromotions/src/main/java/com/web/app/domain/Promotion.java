package com.web.app.domain;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.format.annotation.NumberFormat;
import java.math.BigDecimal;
import jakarta.persistence.*;
@Entity
@Table(name="promotion")
public class Promotion {
  public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLinkPromotion() {
		return linkPromotion;
	}
	public void setLinkPromotion(String linkPromotion) {
		this.linkPromotion = linkPromotion;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLinkImage() {
		return linkImage;
	}
	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
  @Column(name="title",nullable=false)
  private String title;
  @Column(name="link_promotion",nullable=false)
  private String linkPromotion;
  @Column(name="site_promotion",nullable=false)
  private String site;
  @Column(name="description")
  private String description;
  @Column(name="link_image",nullable=false)
  private String linkImage;
  @NumberFormat(style = Style.CURRENCY,pattern="#,##0.00")
  @Column(name="price_promotion",nullable=false)
  private BigDecimal price;
  @Column(name="total_likes")
  private String likes;
  @Column(name="registration_date",nullable=false)
  private String registrationDate;
  @ManyToOne
  @JoinColumn(name="category_fk")
  private Category category;
}















