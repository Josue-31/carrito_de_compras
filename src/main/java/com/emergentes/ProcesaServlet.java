package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //obtener acceso al objeto session
        HttpSession ses = request.getSession();
        //elimina la sesion
        ses.invalidate();

        //redirecciona al index
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera el producto enviado desde formulario
        String producto = request.getParameter("producto");

        //es importante obtener el acceso a la sesion 
        HttpSession ses = request.getSession();
        //se obtiene la lista que esta comoa tributo del objeto session
        ArrayList<String> lista = (ArrayList<String>) ses.getAttribute("lista");
        //a la coleccion adiciona el elemento producto
        lista.add(producto);
        //se redireccion al index.jsp 
        response.sendRedirect("index.jsp");
    }
}
