package liverpool.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import liverpool.project.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where LOWER(u.email)=:email")
	User findUserByEmail(@Param("email") String email);

	@Query("select u from User u where LOWER(u.login)=:login")
	User findUserByLogin(@Param("login") String login);
}
