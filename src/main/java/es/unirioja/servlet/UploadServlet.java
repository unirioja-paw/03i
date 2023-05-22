package es.unirioja.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "UploadServlet", urlPatterns = {"/upload"})
@MultipartConfig
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Parámetro normal
        String nombre = request.getParameter("nombre");
        System.out.println("Nombre: " + nombre);

        // Parámetro file
        Part part = request.getPart("fich");
        String mime = part.getContentType();
        System.out.println("Mime: " + mime);
        long ocupa = part.getSize();
        System.out.println("Mime: " + ocupa);
        String fName = part.getSubmittedFileName();
        System.out.println("fName: " + fName);
        String targetPath = buildTargetPath();
//        String targetPath = buildTargetPath(request.getServletContext());

        System.out.println("Saving file as " + targetPath);
        part.write(String.format("%s/%s", targetPath, fName));
        part.delete();
    }

    private boolean isWindows() {
        String property = System.getProperty("os.name");
        if (property != null && property.toLowerCase().contains("win")) {
            return true;
        }
        return false;
    }

    private String buildTargetPath() {
        if (isWindows()) {
            return "d:/var/paw/tmp/upload/";
        }
        return "/var/paw/tmp/upload/";
    }

    private String buildTargetPath(ServletContext servletContext) {
        File dir = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        return dir.getAbsolutePath();
    }

}
