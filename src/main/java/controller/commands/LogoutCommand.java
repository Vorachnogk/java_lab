package controller.commands;

import controller.AuthUtility;

import javax.servlet.http.HttpServletRequest;



public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String login = (String) request.getSession().getAttribute("login");
        AuthUtility.logout(request, login);
        return "redirect: /index";
    }
}
