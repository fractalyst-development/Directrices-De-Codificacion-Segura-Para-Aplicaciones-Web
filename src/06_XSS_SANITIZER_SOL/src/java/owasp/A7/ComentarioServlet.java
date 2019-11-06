package owasp.A7;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.encoder.Encode;


@WebServlet(name = "ComentarioServlet", urlPatterns = {"/comentario.do"})
public class ComentarioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String comentario = request.getParameter("comentario");
        email = email.replaceAll("<", "&lt;").replaceAll(">", "&gt;");


        String comentarioSanitizado = new HTMLSanitizer().sanitizaComentario(comentario);

        request.setAttribute("nombre", nombre);
        request.setAttribute("email", email);
        request.setAttribute("comentario", comentarioSanitizado);
        request.getRequestDispatcher("comentario.jsp").forward(request, response);
    }

}
