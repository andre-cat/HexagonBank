package co.com.hexagonbank.mongo.helper;

import co.com.hexagonbank.model.user.User;
import co.com.hexagonbank.mongo.data.UserEntity;

import java.util.Optional;

public class UserMapper {

    public static User mapToUser(Optional<UserEntity> optionalUserEntity) {
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            return new User(
                    userEntity.getId(),
                    userEntity.getUsername(),
                    userEntity.getPassword(),
                    userEntity.getName(),
                    userEntity.getLastName(),
                    userEntity.getPhone(),
                    userEntity.getEmail()
            );
        } else {
            return null;
        }
    }

    public static User mapToUser(UserEntity userEntity) {
        if (userEntity != null) {
            return new User(
                    userEntity.getId(),
                    userEntity.getUsername(),
                    userEntity.getPassword(),
                    userEntity.getName(),
                    userEntity.getLastName(),
                    userEntity.getPhone(),
                    userEntity.getEmail()
            );
        } else {
            return null;
        }
    }

    public static UserEntity mapToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setName(user.getName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPhone(user.getPhone());
        userEntity.setEmail(user.getEmail());
        return userEntity;
    }
}
