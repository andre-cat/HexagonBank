package co.com.hexagonbank.mongo;

import co.com.hexagonbank.mongo.data.TransactionEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionMongoDBRepository extends MongoRepository<TransactionEntity, Long> {

    @Aggregation(pipeline = {"{ $match: { 'accountId': ?0 } }"})
    Iterable<TransactionEntity> selectAllByAccountId(long accountId);

    @Aggregation("{ $group: { _id: null, max_transaction_id: { $max: '$_id' } } }")
    Long selectMaxId();
}
