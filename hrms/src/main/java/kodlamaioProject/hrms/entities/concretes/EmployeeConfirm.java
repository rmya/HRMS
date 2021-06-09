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
@EqualsAndHashCode
@Entity
@Table(name ="employee_confirm")
@Inheritance(strategy = InheritanceType.JOINED)
public class EmployeeConfirm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "employee_id")
	private int employee_id;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	@Column(name = "confirm_date")
	private LocalDate confirmDate;
	
	@Column(name = "create-date")
	private LocalDateTime createDate;
	
	@Column(name = "active")
	private boolean active = true;

	public EmployeeConfirm(int id, int employee_id, boolean isConfirmed, LocalDate confirmDate,
			LocalDateTime createDate, boolean active) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.isConfirmed = isConfirmed;
		this.confirmDate = confirmDate;
		this.createDate = createDate;
		this.active = active;
	}

	

	
}
