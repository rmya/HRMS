package kodlamaioProject.hrms.entities.concretes;

import javax.persistence.*;

import kodlamaioProject.hrms.core.entities.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User{
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "phone")
	private String phone;

	public Employer(int id, String email, String password, String companyName, String website, String phone) {
		super(id, email, password);
		this.companyName = companyName;
		this.website = website;
		this.phone = phone;
	}
	
	
}
