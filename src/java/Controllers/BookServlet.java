package Controllers;

import Beans.*;
import DAO.BookDAO;
import com.google.gson.Gson;

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

  

    
    public String toTable( ArrayList<Book> li ) 
    {
        
             String str=  "<table class=\"table table-striped table-bordered table-hover\" id=\"dataTables-example\"><thead><tr><th class=\"center\"></th><th class=\"center\">Titre du livre</th><th class=\"center\">Auteur du livre</th><th class=\"center\">Genre du livre</th><th class=\"center\">Date d'apparution</th><th class=\"center\">Nombre de copies disponibles</th><th colspan=\"2\"><center>Gestion</center></th></tr></thead><div id=\"corpTab\"><tbody>";                               
             for ( Book bk : li )  
                str +=  "<tr><td><i class=\"glyphicon glyphicon-book icon_in_button\"></i></td><td>"+bk.getTitreBook()+"</td><td>"+bk.getAuteurBook()+"</td><td>"+bk.getCategorieBook()+"</td><td>"+bk.getDateParution()+"</td><td>"+bk.getNombreCopieBook()+"</td><td><center><a href=\"books?process=modifier&id_book="+bk.getIdBook()+"\" ><input type=\"button\" class=\"modification  btn btn-success\" id=\""+bk.getIdBook()+"\" value=\"Modifier\"></center></td><td></a><center><input type=\"button\" class=\"suppression  btn btn-success\" id=\""+bk.getIdBook()+"\" value=\"Supprimer\"></center></td></tr>"; 
               
             str += "</tbody></div></table>";
             return str;                                         
                                                        
                                                        
                                                  
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

            ArrayList<Book> Books = BookDAO.getAll();
            request.setAttribute("model", Books);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
         String process = request.getParameter("process");
         System.out.println("Appel servlet"+process);
         if (process.equalsIgnoreCase("delete"))
         {
         
            BookDAO.removeBook(Long.parseLong(request.getParameter("id_book")));
            ArrayList<Book> liste = BookDAO.getAll();
            PrintWriter pr = response.getWriter();
            pr.print(toTable(liste));
            
         }  
         if (process.equalsIgnoreCase("insert"))
         {
             System.out.println(request.getParameter("date"));
             

            BookDAO.addBook(new Book(request.getParameter("codeBook"),request.getParameter("titreBook"),request.getParameter("categorieBook"), request.getParameter("auteurBook"),Integer.parseInt(request.getParameter("nombreCopieBook")) , request.getParameter("date") ));
            response.sendRedirect("bookList.jsp");
         }
         // Demande de récupérer les info
         if (process.equalsIgnoreCase("modifier"))
         {
             int id_book = Integer.parseInt(request.getParameter("id_book"));
             Book b = DAO.BookDAO.getBook(id_book);
             request.setAttribute("book", b);
             request.getRequestDispatcher("bookEdit.jsp").forward(request, response);
         }
         
         if (process.equalsIgnoreCase("update"))
         {
             long id_book = Long.parseLong(request.getParameter("id_book"));
             Book b = new Book(request.getParameter("codeBook"),request.getParameter("titreBook"),request.getParameter("categorieBook"), request.getParameter("auteurBook"),Integer.parseInt(request.getParameter("nombreCopieBook")) , request.getParameter("date") );
             b.setIdBook(id_book);
             DAO.BookDAO.updateBook(b);
             response.sendRedirect("bookList.jsp");
         }
        

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        doPost(request, response);

    }
}
