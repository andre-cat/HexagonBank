package co.com.hexagonbank.jpa;

import co.com.hexagonbank.jpa.data.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<UserData, Long> {
}