package co.com.hexagonbank.mongo;

import co.com.hexagonbank.mongo.data.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoDBRepository extends MongoRepository<UserEntity, Long> {
}
