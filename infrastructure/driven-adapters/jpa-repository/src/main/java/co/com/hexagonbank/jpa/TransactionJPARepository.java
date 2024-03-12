package co.com.hexagonbank.jpa;

import co.com.hexagonbank.jpa.data.TransactionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionJPARepository extends JpaRepository<TransactionData, Long> {

    @Query(value = "SELECT t FROM TransactionEntity t WHERE t.accountId = :accountid", nativeQuery = false)
    Iterable<TransactionData> selectAllByAccountId(@Param("accountid") long accountId);

}
