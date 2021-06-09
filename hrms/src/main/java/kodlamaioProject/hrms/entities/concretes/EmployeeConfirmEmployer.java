package kodlamaioProject.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "employee_confirm_employers")
@PrimaryKeyJoinColumn(name = "employee_confirm_id")
public class EmployeeConfirmEmployer extends EmployeeConfirm {
	
	@Column(name = "employer_id")
	private int employerId;

	public EmployeeConfirmEmployer(int id, int employee_id, boolean isConfirmed, LocalDate confirmDate,
			LocalDateTime createDate, boolean active, int employerId) {
		super(id, employee_id, isConfirmed, confirmDate, createDate, active);
		this.employerId = employerId;
	}
	
	

}
