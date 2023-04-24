package cogent.infotech.com.DoConnect.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description_question;
	private String image_src;
	private String datetime;
	private String status;
	private String topic;
	private String title;
	@OneToMany(mappedBy = "question", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Answer> answers;
	
	//@OnetoOne
	private String qcreated_by;
	
	//@OneToOne
	private String qapproved_by;
	
}
