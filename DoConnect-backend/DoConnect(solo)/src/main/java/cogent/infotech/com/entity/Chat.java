package cogent.infotech.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="chat")
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fromuser;
	private String touser;
	private String message;
	private String datetime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromuser() {
		return fromuser;
	}
	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
}
