package co.com.hexagonbank.usecase.userservice.createuser;

import co.com.hexagonbank.model.user.User;
import co.com.hexagonbank.model.user.exceptions.UserExistsException;
import co.com.hexagonbank.model.user.gateways.UserRepository;

public class CreateUserUseCase implements ICreateUser {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        if (!isUserCreated(user.getId())) {
            userRepository.insert(user);
            return user;
        } else {
            throw new UserExistsException();
        }
    }

    private boolean isUserCreated(long userId) {
        User user = userRepository.selectById(userId);
        return user != null;
    }
}
