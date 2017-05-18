package com.dao;

/**
 * Created by tree on 2017/5/2.
 */

import com.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;



//@MapperScan
@Repository
public interface UserDao {
    List<User> listUser();
}
