package controller.commands;

import javax.servlet.http.HttpServletRequest;

public class GoToNewAutoCommand  implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/view/admin/newauto.jsp";
    }

}
