package testspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import testspring.domain.User;

/**
 * ユーザマッピングクラス
 */
@Mapper
public interface UserMapper {

    /**
     * ユーザを全件取得する
     */
    List<User> findAll();

    /**
     * 検索条件で、ユーザリストを取得する
     */
    List<User> findByCriteria(UserCriteria criteria);

    /**
     * ユーザを1件取得する
     */
    User getOne(String userId);
}
