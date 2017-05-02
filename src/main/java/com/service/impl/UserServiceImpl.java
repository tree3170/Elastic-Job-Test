package com.service.impl;

import com.dao.UserDao;
import com.dto.User;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * Created by tree on 2017/5/2.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao dao;

    @Override
    public List<User> listUser() {
        List<User>  users = dao.listUser();
        System.out.println(users);
        return users;
    }
}
