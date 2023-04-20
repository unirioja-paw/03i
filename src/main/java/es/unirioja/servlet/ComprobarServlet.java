package es.unirioja.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nl.captcha.Captcha;

public class ComprobarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Captcha captcha = (Captcha) sesion.getAttribute(Captcha.NAME);
        // Recogemos lo que haya tecleado el usuario
        String txtCaptcha = request.getParameter("txtCaptcha");
        // Comprobamos
        if (captcha.isCorrect(txtCaptcha)) {
            System.out.println("Comprobacion Captcha: OK");
            request.setAttribute("result", "OK");
        } else {
            System.out.println("Comprobacion Captcha: KO");
            request.setAttribute("result", "KO");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/simplecaptcha_response.jsp");
        rd.forward(request, response);
    }

}
