package pl.upsanok.tablab1excercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.upsanok.tablab1excercise.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
