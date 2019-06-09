package controller.commands;

import controller.AuthUtility;
import model.entity.User;
import model.service.AuthorizationService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


public class LoginCommand implements Command {
    private static final Logger log = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        log.info("in login command");
        AuthorizationService service = new AuthorizationService();
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");


        if(login == null || login.equals("") || pass == null || pass.equals("")) {
            log.info("empty login or password");
            request.setAttribute("error", "Empty login or password");
            return "/index.jsp";
        }

        User user = service.getUserByLogin(login);

        if(AuthUtility.isLogged(request, login)) {
            log.info("user " + user.getLogin() + " already logged");
            request.setAttribute("error", "User already logged");
            return "/index.jsp";
        }


        if(!Objects.isNull(user) && user.getPass().equals(pass)) {
            String redirectPath = AuthUtility.login(request, user).toLowerCase();
            return "redirect: /" + redirectPath;
        }
        else {
            log.info("wrong pass/login");
            request.setAttribute("error", "Wrong login/password");
            return "/index.jsp";
        }
    }
}
