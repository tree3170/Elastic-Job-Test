package com.service.impl;

import com.dao.UserDao;
import com.entity.User;
import com.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        return users;
    }
}
