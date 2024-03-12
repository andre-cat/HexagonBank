package co.com.hexagonbank.usecase.userservice.seeuser;

import co.com.hexagonbank.model.user.User;
import co.com.hexagonbank.model.user.exceptions.UserNotFoundException;
import co.com.hexagonbank.model.user.gateways.UserRepository;

public class SeeUserUseCase implements ISeeUser {

    private final UserRepository userRepository;

    public SeeUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User see(long id) {
        User user = userRepository.selectById(id);
        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException();
        }
    }
}
