/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owasp.a5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ServiceFacade;
import model.data.Administrador;
import model.data.Usuario;

/**
 *
 * @author cazucito
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login.do"}, loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

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
        String nombre = (request.getParameter("nombre") == null ? "" : request.getParameter("nombre"));
        String pwd = (request.getParameter("password") == null ? "" : request.getParameter("password"));
        ServiceFacade svc = new ServiceFacade();
        final List<Usuario> usuariosDB = (List<Usuario>) request.getServletContext().getAttribute("usuariosDB");
        String mensaje = "";
        String siguienteVista = "/index.jsp";
        
        if (svc.login(nombre, pwd, usuariosDB)) {
            siguienteVista = "/ListadoPermisos.jsp";
            request.getSession().setAttribute("usuarios", svc.obtenSusUsuarios(nombre, usuariosDB));
            request.getSession().setAttribute("usuario", svc.obtenUsuario(nombre, pwd, usuariosDB));
            request.getSession().setAttribute("esAdmin", svc.esAdmin(nombre, usuariosDB));
            // token sincronizador
            creaToken(request.getSession());
            getServletContext().getRequestDispatcher(siguienteVista).forward(request, response);
        } else {
            mensaje = "Usuario y/o contraseña incorrecta";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher(siguienteVista).forward(request, response);
        }
        
    }

    public void creaToken(HttpSession session) {
        // Generate new token for user -> SessionID + timestamp
        String token = session.getId() + System.currentTimeMillis();
        // Store sessionID in SessionStore
        session.setAttribute("tokenSincronizador", token);
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
