package util;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import model.data.Administrador;
import model.data.Usuario;

/**
 * Web application lifecycle listener.
 *
 */
public class CargadorInicialListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("INICIALIZANDO");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Administrador(1, "admin", "pwd", true, true, true));
        usuarios.add(new Usuario(2, "user", "pwd", false, false, false));
//        usuarios.add(new Administrador(1, "Juan", true, true, true));
        sce.getServletContext().setAttribute("usuariosDB", usuarios);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("bye");
    }
}
