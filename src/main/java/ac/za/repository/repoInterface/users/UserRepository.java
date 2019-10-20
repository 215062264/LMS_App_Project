package ac.za.repository.repoInterface.users;

import ac.za.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUserName(String username);
}
