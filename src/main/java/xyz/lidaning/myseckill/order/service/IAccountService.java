package xyz.lidaning.myseckill.order.service;

import xyz.lidaning.myseckill.order.domain.Account;

import java.util.List;

public interface IAccountService{

    public Account selectAccountById(String id);

    public List<Account> selectAccountList(Account account);

    public int insertAccount(Account account);

    public int updateAccount(Account account);

    public int deleteAccountByIds(String[] ids);

    public int deleteAccountById(String id);
}
