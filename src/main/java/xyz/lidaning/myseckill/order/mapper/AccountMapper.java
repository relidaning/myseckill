package xyz.lidaning.myseckill.order.mapper;

import java.util.List;
import xyz.lidaning.myseckill.order.domain.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    public Account selectAccountById(String id);

    public List<Account> selectAccountList(Account account);

    public int insertAccount(Account account);

    public int updateAccount(Account account);

    public int deleteAccountById(String id);

    public int deleteAccountByIds(String[] ids);
}