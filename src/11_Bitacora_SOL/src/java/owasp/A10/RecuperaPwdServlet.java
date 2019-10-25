package owasp.A10;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ServiceFacade;

@WebServlet(name = "RecuperaPwd", urlPatterns = {"/recuperaPwd.do"})
public class RecuperaPwdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        final String email = request.getParameter("email");
        String mensaje = "";
        String sigVista = "index.jsp";

        if ((new ServiceFacade()).existeUsuario(email)) {
            String pregunta = (new ServiceFacade()).obtenPregunta(email);
            request.setAttribute("pregunta", pregunta);
            request.setAttribute("email", email);
            request.setAttribute("mensaje", mensaje);
            sigVista = "pregunta.jsp";
            request.getRequestDispatcher(sigVista).forward(request, response);
        } else {
            request.getSession().setAttribute("mensaje", "El usuario no existe");
            response.sendRedirect(sigVista);
        }

    }
}
