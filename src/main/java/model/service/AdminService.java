package model.service;


import model.dao.AutoDao;
import model.dao.DaoFactory;
import model.entity.Auto;


public class AdminService {

    public int newAuto(Auto auto) {
        try{
            DaoFactory factory = DaoFactory.getInstance();
            AutoDao dao = factory.createAutoDao();
            dao.create(auto);
        } catch (Exception e) {

            return 0;
        }
        return 1;
    }



}
