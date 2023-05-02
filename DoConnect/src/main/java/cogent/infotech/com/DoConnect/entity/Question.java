package cogent.infotech.com.DoConnect.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Questions")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description_question;
	private String img_src;
	private String datetime;
	private String status;
	private String topic;
	@OneToMany(mappedBy = "question", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Answer> answers;
	
	public Question(String title, String description_question, String img_src, String datetime, String status, String topic){
		this.title=title;
		this.description_question=description_question;
		this.img_src=img_src;
		this.datetime=status;
		this.topic=topic;
	}
	
	@OneToOne
	private User qcreated_by;
	
	@OneToOne
	private Admin qapproved_by;
	
}
