package co.com.hexagonbank.jpa;

import co.com.hexagonbank.jpa.helper.UserMapper;
import co.com.hexagonbank.model.user.User;
import co.com.hexagonbank.model.user.gateways.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserJPARepositoryAdapter implements UserRepository {

    private final UserJPARepository userJPARepository;

    @Override
    public User selectById(long id) {
        return UserMapper.mapToUser(userJPARepository.findById(id));
    }

    @Override
    public void insert(User user) {
        userJPARepository.save(UserMapper.mapToUserEntity(user));
    }
}
