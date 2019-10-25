package owasp.A10;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ServiceFacade;

@WebServlet(name = "CambiaPwd", urlPatterns = {"/cambiaPwd.do"})
public class CambiaPwdServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String email = request.getParameter("email");
        final String nuevoPwd = request.getParameter("password");
        final String confirmarNuevoPwd = request.getParameter("nuevoPassword");
        String sigVista = "index.jsp";
        if (nuevoPwd.equals(confirmarNuevoPwd)) {

            if ((new ServiceFacade()).cambiaPassword(email, nuevoPwd)) {
                request.getSession().setAttribute("mensaje", "Contraseña reestablecida  con éxito");
            } else {
                request.getSession().setAttribute("mensaje", "Ocurrió un error al reestablecer  la contraseña");
            }
            response.sendRedirect(sigVista);
        } else {
            request.getSession().setAttribute("mensaje", "Las contraseñas no coinciden");
            request.setAttribute("email", email);
            request.getRequestDispatcher("nuevoPwd.jsp").forward(request, response);
        }

    }

}
