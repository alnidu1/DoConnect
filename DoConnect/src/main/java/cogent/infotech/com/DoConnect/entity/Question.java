package cogent.infotech.com.DoConnect.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
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
	
	//@OnetoOne
	private String qcreated_by;
	
	//@OneToOne
	private String qapproved_by;
	
}
