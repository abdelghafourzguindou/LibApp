/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Adherent;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zGuindouOS
 */
@WebServlet(name = "AdherentProcess", urlPatterns = {"/AdherentProcess"})
public class AdherentProcess extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void sign_up(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DAO.AdherentDAO.Adh_Add(new Adherent(
                request.getParameter("CodeAdh"),
                request.getParameter("CINAdh"),
                request.getParameter("NomAdh"),
                request.getParameter("PrenomAdh"),
                request.getParameter("ProfessionAdh"),
                0,
                request.getParameter("LoginAdh"),
                request.getParameter("PasswordAdh")
        ));
        response.sendRedirect("indexAdherent.jsp");
    }

    private void sign_in(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        Adherent adh = null;

        if (DAO.AdherentDAO.isExist(userName, password)) {
            adh = DAO.AdherentDAO.getAdherent(userName, password);
            //response.sendRedirect("EspaceAdherent.jsp");
            request.setAttribute("CurrentAdherent", adh);
            request.getRequestDispatcher("EspaceAdherent.jsp").forward(request, response);
            
        } else {
            response.sendRedirect("indexAdherent.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_adherent = Integer.parseInt(request.getParameter("id_adherent"));
        PrintWriter pr = response.getWriter();
        DAO.AdherentDAO.AccepterAdherent(id_adherent);
        LinkedList<Adherent> adhList = DAO.AdherentDAO.AdherentlisteAttente();
        Gson J = new Gson();
        pr.print(J.toJson(adhList));
        //pr.print(adhList);
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

        if (request.getParameter("sign_up") != null) {
            sign_up(request, response);
        } else if (request.getParameter("sign_in") != null) {
            sign_in(request, response);
        } else {
            doGet(request, response);
        }
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
