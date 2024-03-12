package co.com.hexagonbank.jpa.helper;

import co.com.hexagonbank.jpa.data.UserData;
import co.com.hexagonbank.model.user.User;

import java.util.Optional;

public class UserMapper {

    public static User mapToUser(Optional<UserData> optionalUserEntity) {
        if (optionalUserEntity.isPresent()) {
            UserData userData = optionalUserEntity.get();
            return new User(
                    userData.getId(),
                    userData.getUsername(),
                    userData.getPassword(),
                    userData.getName(),
                    userData.getLastName(),
                    userData.getPhone(),
                    userData.getEmail()
            );
        } else {
            return null;
        }
    }

    public static UserData mapToUserEntity(User user) {
        UserData userData = new UserData();
        userData.setId(user.getId());
        userData.setUsername(user.getUsername());
        userData.setPassword(user.getPassword());
        userData.setName(user.getName());
        userData.setLastName(user.getLastName());
        userData.setPhone(user.getPhone());
        userData.setEmail(user.getEmail());
        return userData;
    }
}
