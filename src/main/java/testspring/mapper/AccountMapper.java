package testspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import testspring.domain.Account;

/**
 * アカウントマッピングクラス
 */
@Mapper
public interface AccountMapper {

    /**
     * アカウントを全件取得する
     */
    List<Account> findAll();

    /**
     * 検索条件で、アカウントリストを取得する
     */
    List<Account> findByCriteria(AccountCriteria criteria);

    /**
     * アカウントを1件取得する
     */
    Account getOne(String accountId);

    /**
     * アカウントを作成する
     */
    int create(Account account);

    /**
     * アカウントを更新する
     */
    int update(Account account);

    /**
     * アカウントを1件削除する
     */
    int delete(String accountId);
}
