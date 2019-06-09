package controller.commands;

import javax.servlet.http.HttpServletRequest;



public class GoToAccessDeniedCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "accessdenied.jsp";
    }
}
