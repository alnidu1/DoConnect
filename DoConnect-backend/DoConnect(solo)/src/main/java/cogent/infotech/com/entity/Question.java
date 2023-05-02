package cogent.infotech.com.entity;

import java.util.List;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name ="question")
@Data
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description_question;
	@Column(length = 10000)
	private String image_src;
	private String datetime;
	private String status;
	private String topic;
	private String title;
	
	@OneToMany(cascade= {CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "question")
	@JsonIgnore
	private List<Answer> answers = new ArrayList<>();
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="qcreated_id" , referencedColumnName="id")
	private User qcreated_by;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="qapproved_by" , referencedColumnName="id")
	private User qapproved_by;
	
	
	
	
}
