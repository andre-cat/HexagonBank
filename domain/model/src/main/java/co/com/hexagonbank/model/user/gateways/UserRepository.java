package co.com.hexagonbank.model.user.gateways;

import co.com.hexagonbank.model.user.User;

public interface UserRepository {
    User selectById(long id);

    void insert(User user);
}
