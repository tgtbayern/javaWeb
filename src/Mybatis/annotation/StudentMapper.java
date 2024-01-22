package Mybatis.annotation;

import Mybatis.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * MyBatis Mapper interface for handling User-related database operations.
 */
public interface StudentMapper {

    /**
     * Retrieves a list of all users from the 'accounting_ledger.user' table.
     *
     * @return List of User objects.
     */
    @Select("SELECT * FROM accounting_ledger.user")
    List<User> selectUser();

    /**
     * Retrieves a list of users with a specific username from the 'accounting_ledger.user' table.
     *
     * @param username The username to search for.
     * @return List of User objects matching the specified username.
     */
    @Select("SELECT * FROM accounting_ledger.user WHERE username=#{username}")
    List<User> selectUserByName(String username);

    /**
     * Retrieves a list of all users from the 'accounting_ledger.user' table,
     * reversing the mapping of username and password.
     *
     * @return List of User objects with reversed username and password.
     */
    @Results({
            @Result(column = "username", property = "password"),
            @Result(column = "password", property = "username")
    })
    @Select("SELECT * FROM accounting_ledger.user")
    List<User> selectUserReverse();
}
