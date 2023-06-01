package excel.Apache;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Id
	private Long id;
	private String name;
	private String email;
	private float expenditure;
	
//	public User(Long id,String name,String email,float expenditure) {
//		this.id = id;
//		this.name = name;
//		this.email=email;
//		this.expenditure = expenditure;
//	}
	
	public User() {
		this.id =  (long) 0;
		this.name = "NIL";
		this.email="NIL";
		this.expenditure = 0;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public float getExpenditure() {
		return expenditure;
	}
	public void setExpenditure(float expenditure) {
		this.expenditure = expenditure;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", expenditure=" + expenditure + "]";
	}

	

}

