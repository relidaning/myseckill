package xyz.lidaning.myseckill.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.lidaning.api.common.JsonResult;
import xyz.lidaning.myseckill.order.domain.Account;
import xyz.lidaning.myseckill.order.service.IAccountService;

import java.util.List;


@RestController
@RequestMapping("/order/account")
public class AccountController{
    @Autowired
    private IAccountService accountService;

    @GetMapping("/list")
    public JsonResult list(Account account){
        List<Account> list = accountService.selectAccountList(account);
        return JsonResult.success(list);
    }

    @GetMapping(value = "/{id}")
    public JsonResult getInfo(@PathVariable("id") String id){
        return JsonResult.success(accountService.selectAccountById(id));
    }

    @PostMapping
    public JsonResult add(@RequestBody Account account){
        return JsonResult.success(accountService.insertAccount(account));
    }

    @PutMapping
    public JsonResult edit(@RequestBody Account account){
        return JsonResult.success(accountService.updateAccount(account));
    }

    @DeleteMapping
    public JsonResult remove(@PathVariable String[] ids){
        return JsonResult.success(accountService.deleteAccountByIds(ids));
    }
}
