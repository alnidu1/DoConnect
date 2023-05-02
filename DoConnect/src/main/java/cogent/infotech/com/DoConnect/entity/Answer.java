package cogent.infotech.com.DoConnect.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Answers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Answers")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description_answer;
	private String img_src;
	private String status;
	private String datetime;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	@OneToOne
	private Admin approved_by;
	
	@OneToOne
	private User created_by;
}
