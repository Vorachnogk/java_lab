package controller.commands;

import model.entity.Auto;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;

public class NewAutoCommand implements Command {


    @Override
    public String execute(HttpServletRequest request) {
        String nameAuto = request.getParameter("autoname");
        String number = request.getParameter("autonumber");

        Auto auto = new Auto.Builder()

                .setNumberAuto(number)
                .setNameAuto(nameAuto)
                .build();
        AdminService service = new AdminService();
        service.newAuto(auto);

        return "redirect: /admin";
    }
}

