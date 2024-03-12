package co.com.hexagonbank.jpa;

import co.com.hexagonbank.jpa.data.AccountData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJPARepository extends CrudRepository<AccountData, Long>, QueryByExampleExecutor<AccountData> {

    @Query(value = "SELECT MAX(a.id) FROM AccountEntity a", nativeQuery = false)
    Long selectMaxId();

    @Query(value = "SELECT a FROM AccountEntity a WHERE a.userId = :userid", nativeQuery = false)
    AccountData selectByUserId(@Param("userid") long userId);
}
