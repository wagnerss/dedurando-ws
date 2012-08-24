package br.com.dedurando.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DDR_REVIEW_REASON")
//@SequenceGenerator(name="SEQ_GEN_REVIEW_REASON", sequenceName="SEQ_GEN_REVIEW_REASON", allocationSize=1)
public class ReviewReason implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue//(generator="SEQ_GEN_REVIEW_REASON", strategy=GenerationType.SEQUENCE)
	@Column(name="REVIEW_REASON_ID")
	private long reviewReasonId;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="STATUS")
	private int status;
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(StatusType status) {
		this.status = status.getStatus();
	}
	
	public long getReviewReasonId() {
		return reviewReasonId;
	}
	public void setReviewReasonId(long reviewReasonId) {
		this.reviewReasonId = reviewReasonId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
