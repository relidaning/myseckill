package xyz.lidaning.myseckill.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.lidaning.api.common.JsonResult;
import xyz.lidaning.myseckill.user.domain.User;
import xyz.lidaning.myseckill.user.service.IUserService;

import java.util.List;


@RestController
@RequestMapping("/user/user")
public class UserController{
    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public JsonResult list(User user){
        List<User> list = userService.selectUserList(user);
        return JsonResult.success(list);
    }

    @GetMapping(value = "/{id}")
    public JsonResult getInfo(@PathVariable("id") String id){
        return JsonResult.success(userService.selectUserById(id));
    }

    @PostMapping
    public JsonResult add(@RequestBody User user){
        return JsonResult.success(userService.insertUser(user));
    }

    @PutMapping
    public JsonResult edit(@RequestBody User user){
        return JsonResult.success(userService.updateUser(user));
    }

    @DeleteMapping
    public JsonResult remove(@PathVariable String[] ids){
        return JsonResult.success(userService.deleteUserByIds(ids));
    }
}
