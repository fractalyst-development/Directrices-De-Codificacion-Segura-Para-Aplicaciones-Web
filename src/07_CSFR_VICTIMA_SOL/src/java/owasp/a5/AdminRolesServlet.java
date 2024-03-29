package owasp.a5;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ServiceFacade;
import model.data.Usuario;

/**
 *
 * @author cazucito
 */
@WebServlet(name = "AdminRolesServlet", urlPatterns = {"/adminRoles.do"})
public class AdminRolesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idUsuario = (request.getParameter("idUsuario") == null ? 0 : Integer.parseInt(request.getParameter("idUsuario")));
        boolean w = request.getParameter("write") != null;
        boolean e = request.getParameter("execute") != null;
        boolean r = request.getParameter("read") != null;
        Usuario uNuevosPermisos = new Usuario(idUsuario, "", "", w, r, e);
        ServiceFacade svc = new ServiceFacade();
        final List<Usuario> usuariosDB = (List<Usuario>) request.getServletContext().getAttribute("usuariosDB");
        boolean exito = svc.actualizaPermisos(uNuevosPermisos, usuariosDB);
        String mensaje = "";
        String accion = "";
        String sigVista = "index.jsp";
        if (exito) {
            sigVista = "ListadoPermisos.jsp";
        }
        request.getRequestDispatcher(sigVista).forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
