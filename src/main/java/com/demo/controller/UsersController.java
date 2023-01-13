package com.demo.controller;

import com.demo.domain.Users;
import com.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping
    public Result insert(@RequestBody Users users) {
        boolean flag = usersService.insert(users);
        System.out.println("添加");
        return new Result(flag ? Code.SAVE_SUCCESS : Code.SAVE_ERROR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Users users) {
        boolean flag = usersService.update(users);
        System.out.println("修改");
        return new Result(flag ? Code.UPDATE_SUCCESS : Code.UPDATE_ERROR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        boolean flag = usersService.delete(id);
        System.out.println("删除");
        return new Result(flag ? Code.DELETE_SUCCESS : Code.DELETE_ERROR, flag);
    }

    @PostMapping("/deletes")
    public Result deletes(String[] loginIds) {
        boolean flag = usersService.deletes(loginIds);
        System.out.println("批量删除");
        return new Result(flag ? Code.DELETE_SUCCESS : Code.DELETE_ERROR, flag);
    }

    @GetMapping
    public Result selectAll() {
        List<Users> usersList = usersService.selectAll();
        Integer code = usersList != null ? Code.SELECT_SUCCESS : Code.SELECT_ERROR;
        String msg = usersList != null ? "" : "数据查询失败，请重试！";
        System.out.println("查询所有");
        return new Result(code, usersList, msg);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable String id) {
        Users users = usersService.selectById(id);
        Integer code = users != null ? Code.SELECT_SUCCESS : Code.SELECT_ERROR;
        String msg = users != null ? "" : "数据查询失败，请重试！";
        System.out.println("查询单条");
        return new Result(code, users, msg);
    }

    @GetMapping("/{start}/{pageSize}")
    public Result selectByPage(@PathVariable int start, @PathVariable int pageSize) {
        List<Users> usersPageList = usersService.selectByPage(start, pageSize);
        Integer code = usersPageList != null ? Code.SELECT_SUCCESS : Code.SELECT_ERROR;
        String msg = usersPageList != null ? "" : "数据查询失败，请重试！";
        System.out.println("分页查询");
        return new Result(code, usersPageList, msg);
    }

    @PostMapping("/like")
    public Result selectByPage(String nickName) {
        nickName = "%" + nickName + "%";
        List<Users> usersPageList = usersService.selectByNickName(nickName);
        Integer code = usersPageList != null ? Code.SELECT_SUCCESS : Code.SELECT_ERROR;
        String msg = usersPageList != null ? "" : "数据查询失败，请重试！";
        System.out.println("模糊查询");
        return new Result(code, usersPageList, msg);
    }

    @PostMapping("/likeandpage")
    public Result selectByIdAndNickNameAndPage(String loginId,String nickName,int start,int pageSize) {
        loginId = "%" + loginId + "%";
        nickName = "%" + nickName + "%";
        List<Users> usersLikePageList = usersService.selectByIdAndNickNameAndPage(loginId, nickName, start, pageSize);
        Integer code = usersLikePageList != null ? Code.SELECT_SUCCESS : Code.SELECT_ERROR;
        String msg = usersLikePageList != null ? "" : "数据查询失败，请重试！";
        System.out.println("分页模糊查询");
        return new Result(code, usersLikePageList, msg);
    }

    @PostMapping("/count")
    public Result getCount(String loginId,String nickName) {
        loginId = "%" + loginId + "%";
        nickName = "%" + nickName + "%";
        int num = usersService.getCount(loginId, nickName);
        Integer code = num != -1 ? Code.SELECT_SUCCESS : Code.SELECT_ERROR;
        String msg = num != -1 ? "" : "数据查询失败，请重试！";
        System.out.println("分页模糊查询");
        return new Result(code, num, msg);
    }
}
