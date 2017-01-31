package Controllers;

import Beans.*;
import DAO.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by zGuindouOS on 12/12/2016.
 */

public class BookServlet extends HttpServlet {

    private BookDAO bd;

    @Override
    public void init() throws ServletException {
        bd = new BookDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Book</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Book " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            ArrayList<Book> Books = bd.getAll();
            request.setAttribute("model", Books);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*System.out.println("\n\n\n\n\nCode "+request.getParameter("CodeBook"));
        System.out.println("Titre "+request.getParameter("TitreBook"));
        System.out.println("Auteur "+request.getParameter("AuteurBook"));
        System.out.println("Catego "+request.getParameter("CategorieBook"));
        System.out.println("Nbr Copies "+Integer.parseInt(request.getParameter("CopierNumberBook")));
        System.out.println("\n\n\n\n\n\n");*/


        if(request.getParameter("Delete") != null) {
            bd.removeBook(Long.parseLong(request.getParameter("idBook")));
        }
        else if(request.getParameter("Update") != null) {
            Book book = new Book(request.getParameter("CodeBook"),
                    request.getParameter("TitreBook"),
                    request.getParameter("AuteurBook"),
                    request.getParameter("CategorieBook"),
                    Integer.parseInt(request.getParameter("NombreCopieBook")),
                    true);
            bd.updateBook(book);
        }
        else {

            Book book = new Book(request.getParameter("CodeBook"),
                    request.getParameter("TitreBook"),
                    request.getParameter("AuteurBook"),
                    request.getParameter("CategorieBook"),
                    Integer.parseInt(request.getParameter("NombreCopieBook")),
                    true);

            //System.out.println(book.toString());

            bd.addBook(book);
        }

        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
