package com.sm.user.service.impl;

import com.sm.common.dao.GenericDao;
import com.sm.common.service.impl.GenericServiceImpl;
import com.sm.user.dao.UserDao;
import com.sm.user.entity.User;
import com.sm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Newbody on 2016/3/2.
 */

@Transactional
@Service("userService")
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    protected GenericDao<User, String> getDao() {
        return userDao;
    }
}
