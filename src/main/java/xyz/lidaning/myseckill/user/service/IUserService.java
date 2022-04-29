package xyz.lidaning.myseckill.user.service;

import xyz.lidaning.myseckill.user.domain.User;

import java.util.List;

public interface IUserService{

    public User selectUserById(String id);

    public List<User> selectUserList(User user);

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUserByIds(String[] ids);

    public int deleteUserById(String id);
}
