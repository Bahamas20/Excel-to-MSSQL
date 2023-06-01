package excel.Apache;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

	 boolean existsByName(String name);
	
}
