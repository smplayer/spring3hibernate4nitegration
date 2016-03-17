package com.sm.user.service.impl;

import com.sm.common.query.PageHandler;
import com.sm.common.query.hibernate.Conditions;
import com.sm.common.query.hibernate.Query;
import com.sm.user.entity.User;
import com.sm.user.service.UserService;
import org.hibernate.criterion.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by Newbody on 2016/3/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:defaultDispatcher-servlet.xml", "classpath:applicationContext.xml"})
//@TransactionConfiguration(defaultRollback = false)
@Transactional
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    private String userId = null;

    private Integer index = 1;

    @Before
    public void testSave(){
        for(int i = 0; i < 30; i++) {
            User user = new User();
            user.setUsername("newbody");
            user.setPassword("newbody2");
            userService.save(user);
            this.userId = user.getId();
        }
    }

    @Test
    public void testGet(){
        User user = userService.getById(userId);
        assertEquals(user.getUsername(), "newbody");
    }

    @Test
    public void testPage(){
        PageHandler page = userService.getPage(
                new Query().setPageIndex(1L)
                .setPageSize(10)
                .setConditions(
                        Conditions.newInstance()
                        .eq("username", "newbody")
                )
                .addOrder(Order.desc("username"))
        );
        assertEquals(((User)page.getDataList().get(0)).getUsername(), "newbody");
    }

}