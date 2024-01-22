package Mybatis.Mapper;

import Mybatis.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();
    List<User> selectByUsername(String username);
    int insertUser(User user);
}
