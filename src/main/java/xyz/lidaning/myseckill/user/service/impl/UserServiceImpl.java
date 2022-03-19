package xyz.lidaning.myseckill.user.service.impl;

import java.util.List;
import xyz.lidaning.myseckill.user.domain.User;
import xyz.lidaning.myseckill.user.mapper.UserMapper;
import xyz.lidaning.myseckill.user.service.IUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService{
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectUserById(String id){
        return userMapper.selectUserById(id);
    }

    @Override
    public List<User> selectUserList(User user){
        return userMapper.selectUserList(user);
    }

    @Override
    public int insertUser(User user){
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUserByIds(String[] ids){
        return userMapper.deleteUserByIds(ids);
    }

    @Override
    public int deleteUserById(String id){
        return userMapper.deleteUserById(id);
    }
}