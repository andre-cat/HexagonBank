package co.com.hexagonbank.mongo;

import co.com.hexagonbank.mongo.data.AccountEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMongoDBRepository extends MongoRepository<AccountEntity, Long> {

    @Aggregation("{ $group: { _id: null, max_account_id: { $max: '$_id' } } }")
    Long selectMaxId();
}
