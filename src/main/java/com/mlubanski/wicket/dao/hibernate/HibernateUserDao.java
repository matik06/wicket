/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlubanski.wicket.dao.hibernate;

import com.mlubanski.wicket.dao.UserDao;
import com.mlubanski.wicket.model.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mateusz Lubański <mlubanskii@gmail.com>
 */
@Repository
public class HibernateUserDao extends HibernateDao<User, Integer> implements UserDao {
    
    public HibernateUserDao() {
        super(User.class);
    }
}