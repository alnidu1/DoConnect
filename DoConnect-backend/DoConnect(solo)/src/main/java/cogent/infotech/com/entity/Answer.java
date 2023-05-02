package cogent.infotech.com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name ="answer")
@Data
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description_answer;
	@Column(length = 10000)
	private String img_src;
	private String status;
	private String datetime;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="question_id" , nullable=false)
	private Question question;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="aapproved_id" , referencedColumnName="id")
	private User aapproved_by;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="acreated_id" , referencedColumnName="id")
	private User acreated_by;
	
}
