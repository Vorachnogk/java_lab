package controller.commands;

import model.entity.User;
import model.service.AuthorizationService;
import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;



public class RegistrationCommand implements Command {
    private static final Logger log = Logger.getLogger(RegistrationCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        AuthorizationService service = new AuthorizationService();

        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String pass2 = request.getParameter("confirm");

        if (!pass.equals(pass2)) {
            log.info("passwords are not equals");
            return "redirect: /toregistr";
        }
//        if(service.isExist(login)) {
//            log.info("user with such login already exists");
//            return "redirect: /toregistr";
//        }



        User user = new User.Builder()
                .setName(name)
                .setLogin(login)
                .setPassword(pass)
                .setRole("USER")
                .build();

        service.registration(user);
        return "redirect: /index";
    }
}
