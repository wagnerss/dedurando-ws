package br.com.dedurando.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="DDR_POST_REVIEW")
//@SequenceGenerator(name="SEQ_GEN_REVIEW", sequenceName="SEQ_GEN_REVIEW", allocationSize=1)
public class Review implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue//(generator="SEQ_GEN_REVIEW", strategy=GenerationType.SEQUENCE)
	@Column(name="REVIEW_ID")
	private Long reviewId;
	
	@NotNull(message= "Review Reason cannot be null.")
	@ManyToOne
	@JoinColumn(name="REVIEW_REASON_ID")
	private ReviewReason reviewReason;
		
	@Column(name="STATUS")
	private char status;
	
	@NotNull(message= "Post cannot be null.")
	@ManyToOne
	@JoinColumn(name="POST_ID")
	private Post post;

	@NotNull(message= "User cannot be null.")
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
		
	@NotNull(message= "Created At cannot be null.")
	@Column(name="CREATED_AT")
	private Calendar createdAt;

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public ReviewReason getReviewReason() {
		return reviewReason;
	}

	public void setReviewReason(ReviewReason reviewReason) {
		this.reviewReason = reviewReason;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}
	
}
