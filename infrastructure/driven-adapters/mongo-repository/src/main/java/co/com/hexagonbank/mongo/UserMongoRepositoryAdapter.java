package co.com.hexagonbank.mongo;

import co.com.hexagonbank.model.user.User;
import co.com.hexagonbank.model.user.gateways.UserRepository;
import co.com.hexagonbank.mongo.helper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserMongoRepositoryAdapter implements UserRepository {

    private final UserMongoDBRepository userMongoDBRepository;

    @Override
    public User selectById(long id) {
        return UserMapper.mapToUser(userMongoDBRepository.findById(id));
    }

    @Override
    public void insert(User user) {
        userMongoDBRepository.save(UserMapper.mapToUserEntity(user));
    }
}
