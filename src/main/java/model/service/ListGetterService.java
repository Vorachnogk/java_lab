package model.service;


import model.dao.AutoDao;
import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entity.Auto;
import model.entity.User;

import java.util.List;




public class ListGetterService {




    public List<Auto> getAutoList() {
        DaoFactory factory = DaoFactory.getInstance();
        AutoDao dao = factory.createAutoDao();
        return dao.findAll();
    }
    public List<User> getUserList() {
        DaoFactory factory = DaoFactory.getInstance();
        UserDao dao = factory.createUserDao();
        return dao.findAll();
    }

//    public List<Authoriz> getAuthorizList() {
//        DaoFactory factory = DaoFactory.getInstance();
//        AuthorizDao dao = factory.createAuthorizDao();
//        return dao.findAll();
//    }




}
