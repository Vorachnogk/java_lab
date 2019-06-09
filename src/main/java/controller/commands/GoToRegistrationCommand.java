package controller.commands;

import javax.servlet.http.HttpServletRequest;


public class GoToRegistrationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/registration.jsp";
    }
}
