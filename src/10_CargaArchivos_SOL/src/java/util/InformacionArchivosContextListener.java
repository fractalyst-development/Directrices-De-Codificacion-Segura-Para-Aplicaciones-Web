package util;

import java.io.File;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 */
public class InformacionArchivosContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String rootPath = sce.getServletContext().getRealPath("/");
        System.out.println("rootPath:"+rootPath);
        ServletContext ctx = sce.getServletContext();
        String relativePath = ctx.getInitParameter("tempfile.dir");
        String ruta = rootPath + File.separator + relativePath;
        File file = new File(ruta);
        
        if (!file.exists()) {
            file.mkdirs();
        }
        System.out.println("File Directory created to be used for storing files" + file.getAbsolutePath());
        ctx.setAttribute("FILES_DIR_FILE", file);
        ctx.setAttribute("FILES_DIR", ruta);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
