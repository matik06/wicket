/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlubanski.wicket.service.impl;

import com.mlubanski.wicket.dao.UserDao;
import com.mlubanski.wicket.model.User;
import com.mlubanski.wicket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


/**
 *
 * @author Mateusz Lubański <mlubanskii@gmail.com>
 */
@Service("UserService")
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS)
public class UserServiceImpl extends GenericServiceImpl<User, Integer, UserDao> implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDao getDao() {
        return this.userDao;
    }

//    @Override
//    @Transactional(readOnly=true)
//    public User getByLogin(String login) {
//        Criterion c = Restrictions.eq("login", login);
//        return super.findByRestrictions(c);
//    }
}
