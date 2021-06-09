package kodlamaioProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaioProject.hrms.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
