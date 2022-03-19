package xyz.lidaning.myseckill.order.service.impl;

import java.util.List;
import xyz.lidaning.myseckill.order.domain.Account;
import xyz.lidaning.myseckill.order.mapper.AccountMapper;
import xyz.lidaning.myseckill.order.service.IAccountService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements IAccountService{
    @Resource
    private AccountMapper accountMapper;

    @Override
    public Account selectAccountById(String id){
        return accountMapper.selectAccountById(id);
    }

    @Override
    public List<Account> selectAccountList(Account account){
        return accountMapper.selectAccountList(account);
    }

    @Override
    public int insertAccount(Account account){
        return accountMapper.insertAccount(account);
    }

    @Override
    public int updateAccount(Account account){
        return accountMapper.updateAccount(account);
    }

    @Override
    public int deleteAccountByIds(String[] ids){
        return accountMapper.deleteAccountByIds(ids);
    }

    @Override
    public int deleteAccountById(String id){
        return accountMapper.deleteAccountById(id);
    }
}