package com.demo.service.impl;

import com.demo.dao.UsersDao;
import com.demo.domain.Users;
import com.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServlceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;

    public boolean insert(Users users) {
        usersDao.insert(users);
        return true;
    }

    public boolean update(Users users) {
        usersDao.update(users);
        return true;
    }

    public boolean delete(String id) {
        usersDao.delete(id);
        return true;
    }

    public boolean deletes(String[] loginIds) {
        usersDao.deletes(loginIds);
        return true;
    }

    public List<Users> selectAll() {
        return usersDao.selectAll();
    }

    public Users selectById(String id) {
        return usersDao.selectById(id);
    }

    public List<Users> selectByPage(int start, int pageSize) {
        return usersDao.selectByPage(start,pageSize);
    }

    public List<Users> selectByNickName(String nickName) {
        return usersDao.selectByNickName(nickName);
    }

    public List<Users> selectByIdAndNickNameAndPage(String loginId,String nickName,int start,int pageSize) {
        return usersDao.selectByIdAndNickNameAndPage(loginId,nickName,start,pageSize);
    }

    public int getCount(String loginId,String nickName) {
        return usersDao.getCount(loginId,nickName);
    }
}
