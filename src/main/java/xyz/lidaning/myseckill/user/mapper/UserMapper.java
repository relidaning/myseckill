package xyz.lidaning.myseckill.user.mapper;

import java.util.List;
import xyz.lidaning.myseckill.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public User selectUserById(String id);

    public List<User> selectUserList(User user);

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUserById(String id);

    public int deleteUserByIds(String[] ids);
}