package com.demo.service;

import com.demo.config.SpringConfig;
import com.demo.domain.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UsersServiceTest {
    @Autowired
    private UsersService usersService;

    @Test
    public void testSelectById() {
        Users users = usersService.selectById("zhangsan");
        System.out.println(users);
    }

    @Test
    public void testSelectAll() {
        List<Users> users = usersService.selectAll();
        System.out.println(users);
    }
}
