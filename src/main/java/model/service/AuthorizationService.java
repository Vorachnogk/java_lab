package model.service;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entity.User;
import org.apache.log4j.Logger;




public class AuthorizationService {
    private static final Logger log = Logger.getLogger(AuthorizationService.class);

    public User getUserByLogin(String login) {
        User user = null;
        try{
            DaoFactory factory = DaoFactory.getInstance();
            UserDao dao = factory.createUserDao();
            user = dao.findByLogin(login);
        } catch (Exception e) {
            log.error("exception: " + e.getMessage());
        }
        return user;
    }

    public boolean isExist(String login) {
        User user = null;
        try{
            DaoFactory factory = DaoFactory.getInstance();
            UserDao dao = factory.createUserDao();
            user = dao.findByLogin(login);
        } catch (Exception e) {
            log.error("exception: " + e.getMessage());
        }

        return user.getLogin().equals(login);
    }

    public void registration(User user) {
        try{

            DaoFactory factory = DaoFactory.getInstance();

            UserDao dao = factory.createUserDao();

            dao.create(user);
        } catch (Exception e) {
            log.error("exception: " + e.getStackTrace().toString());
        }
    }

}
