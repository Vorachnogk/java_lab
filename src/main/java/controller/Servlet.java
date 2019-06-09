package controller;

import controller.commands.*;
import model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;




public class Servlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(Servlet.class);
    private Map<String, Command> commandMap = new HashMap<>();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // Locale.setDefault(new Locale("UK", "UA", "strings.properties"));
        User user = new User.Builder()
                .setRole(User.ROLE.UNKNOWN.toString())
                .build();
        servletConfig.getServletContext().setAttribute("loggedUsers", new HashSet<String>());


        commandMap.put("/toregistr", new GoToRegistrationCommand());
        commandMap.put("/registration", new RegistrationCommand());

        commandMap.put("/index", new GoToIndexCommand());
        commandMap.put("/user", new GoToUserCommand());
        commandMap.put("/admin", new GoToAdminCommand());
        commandMap.put("/login", new LoginCommand());
        commandMap.put("/logout", new LogoutCommand());


//        commandMap.put("/newvladelec", new NewvladelecCommand());
//        commandMap.put("/gotonewvladelec", new GoToNewvladelecCommand());
//
        commandMap.put("/gotonewauto", new GoToNewAutoCommand());
        commandMap.put("/newauto", new NewAutoCommand());
//
//        commandMap.put("/gotonewauth", new GoToNewAutoCommand());
//        commandMap.put("/newauth", new NewAutoCommand());
//
//        commandMap.put("/gotoselect", new GoToSelectAutoCommand());
//        commandMap.put("/update", new UpdateCommand());
//
//
//
//        commandMap.put("/gotomyauto", new GoToMyTickets());
//        commandMap.put("/topage", new PageUpdaterCommand());
//
        commandMap.put("/denied", new GoToAccessDeniedCommand());

    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        processRequest(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        processRequest(httpServletRequest, httpServletResponse);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getRequestURI().toLowerCase();
        path = path.replaceAll("/servlet", "");
        log.info(path);
        Command command = commandMap.getOrDefault(path, (r) -> "/index.jsp");
        String page = command.execute(request);
        log.info(page);
        if(page.contains("redirect: ")) {
            page = page.replaceAll("redirect: ", "");
            String redirect = request.getContextPath() + "/servlet" + page;
            response.sendRedirect(redirect);

        }
        else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
