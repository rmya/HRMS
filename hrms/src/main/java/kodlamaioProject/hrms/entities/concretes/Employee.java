package kodlamaioProject.hrms.entities.concretes;

import kodlamaioProject.hrms.core.entities.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "employess")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employee extends User{

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	public Employee(int id, String email, String password, String firstName, String lastName) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
}
