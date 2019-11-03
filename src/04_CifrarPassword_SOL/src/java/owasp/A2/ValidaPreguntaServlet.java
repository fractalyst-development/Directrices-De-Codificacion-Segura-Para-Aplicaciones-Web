package owasp.A2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ServiceFacade;

@WebServlet(name = "CambioPasswordViewServlet", urlPatterns = {"/validaPregunta.do"})
public class ValidaPreguntaServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        final String email = request.getParameter("email");
        final String respuesta = request.getParameter("respuesta");
        String sigVista = "index.jsp";
        if ((new ServiceFacade()).existeUsuario(email)) {
            
            if ((new ServiceFacade()).esLaRespuesta(email, respuesta)) {
                request.setAttribute("email", email);
                sigVista = "nuevoPwd.jsp";
            } else {
                request.setAttribute("mensaje", "Respuesta incorrecta");
            }
            request.getRequestDispatcher(sigVista).forward(request, response);
        } else {
            request.getSession().setAttribute("mensaje", "El usuario no existe");
            response.sendRedirect(sigVista);
        }

    }

}
