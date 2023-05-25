package pl.waw.great.alledrogo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.great.alledrogo.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
