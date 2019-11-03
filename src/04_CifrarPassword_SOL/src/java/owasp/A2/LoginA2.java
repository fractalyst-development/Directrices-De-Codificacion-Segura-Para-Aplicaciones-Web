package owasp.A2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ServiceFacade;

@WebServlet(name = "loginA2", urlPatterns = {"/loginA2.do"})
public class LoginA2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = (request.getParameter("email") == null ? "" : request.getParameter("email"));
        String pwd = (request.getParameter("password") == null ? "" : request.getParameter("password"));

        String mensaje = "";
        String siguienteVista = "/index.jsp";

        if ((new ServiceFacade()).login(email, pwd)) {
            siguienteVista = "/dashboard.jsp";
            request.setAttribute("mensaje", mensaje);
            getServletContext().getRequestDispatcher(siguienteVista).forward(request, response);
        } else {
            mensaje = "Usuario y/o contraseña incorrecta";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher(siguienteVista).forward(request, response);
        }

    }
}
