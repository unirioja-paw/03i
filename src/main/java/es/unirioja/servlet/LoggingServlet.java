package es.unirioja.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "LoggingServlet", urlPatterns = {"/logging"})
@MultipartConfig
public class LoggingServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Mensaje generado con println");

        request.getServletContext().log("Mensaje generado con ServletContext");

        logger.info("Mensaje de informacion generado con SLF4j");
        logger.warn("Mensaje de advertencia generado con SLF4j");
        logger.error("Mensaje de error generado con SLF4j");
        logger.trace("Mensaje de traza generado con SLF4j"); // este mensaje aparece en log???

        // por mostrar algo en el navegador
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Pagina de prueba de registro de actividad del usuario");
    }

}
