package kodlamaioProject.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name = "verification_codes")
public class VerificationCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "activation_code")
	private String activationCode;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@Column(name = "expiration_date")
	private LocalDateTime expirationDate;
	
	@Column(name = "activation_date")
	private LocalDateTime activationDate;

	public VerificationCode(int id, String userId, String activationCode, String email, boolean active,
			LocalDateTime createDate, LocalDateTime expirationDate, LocalDateTime activationDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.activationCode = activationCode;
		this.email = email;
		this.active = active;
		this.createDate = createDate;
		this.expirationDate = expirationDate;
		this.activationDate = activationDate;
	}
	
	
}

