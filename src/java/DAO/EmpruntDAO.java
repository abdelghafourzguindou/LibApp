/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Adherent;
import Beans.Book;
import Beans.EmpruntP;
import Beans.Reservation;
import Beans.ReservationP;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author l.IsSaM.l
 */
public class EmpruntDAO {
    
    
    public static ArrayList<EmpruntP> get_All_En_Cours(int id_adherent)
    {
       ArrayList<EmpruntP> li_Emp = null;
        try {
            li_Emp = new ArrayList<EmpruntP>();
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            ResultSet res = st.executeQuery(Requests.Emprunt_En_cours_By_Adh(id_adherent));
            while (res.next()) {

                li_Emp.add(new EmpruntP(res.getInt(1),res.getString(2), res.getString(3), res.getString(4)));
                   
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return li_Emp;
            
        }  
        
    }
    
       
    public static ArrayList<EmpruntP> get_All_Remis(int id_adherent)
    {
       ArrayList<EmpruntP> li_Emp = null;
        try {
            li_Emp = new ArrayList<EmpruntP>();
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            ResultSet res = st.executeQuery(Requests.Emprunt_Remis_By_Adh(id_adherent));
            while (res.next()) {

                li_Emp.add(new EmpruntP(res.getInt(1),res.getString(2), res.getString(3), res.getString(4)));
                   
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return li_Emp;
            
        }  
        
    }
    
    public static void Book_Remis(int id_adherent , int id_book)
    {
         try {
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            st.executeUpdate(Requests.Emprunt_Book_Remis(id_adherent, id_book));
            st.executeUpdate(Requests.Reservation_Incrementation(id_book));
            
            } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
    }
    
    
    
    public static void addEmprunt(EmpruntP E) {
        try {
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            st.executeUpdate(Requests.Emprunt_ADD(E));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public static LinkedList<EmpruntP> get_All_En_Cours()
    {
       LinkedList<EmpruntP> li_Emp = null;
        try {
            li_Emp = new LinkedList<EmpruntP>();
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            ResultSet res = st.executeQuery(Requests.Emprunt_En_cours());
            while (res.next()) {

                li_Emp.add(new EmpruntP(res.getInt(1),res.getInt(2), res.getString(3), res.getString(4) , res.getString(5)));
                   
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return li_Emp;
            
        }  
    }
    
    public static int SelectCountEmprunt() {
        int c = 0;
        try {
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            ResultSet res = st.executeQuery(Requests.SelectCountEmprunt());
            res.next();
            c = res.getInt(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
    
    public static LinkedList<Book> getLivreAujourdui(int id_adherent)
    {
            LinkedList<Book> li = new LinkedList<Book>();
        try {
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            ResultSet res = st.executeQuery(Requests.Emprunt_getLivre_Aujourdui(id_adherent));
            while(res.next())
            {
             li.add( DAO.BookDAO.getBook(res.getInt(1)));
                
            }
        } catch (Exception e) {
            System.out.println("----"+e.getMessage());
            return li;
        }
          return li;
    }
    
      public static ArrayList<ReservationP> getLivreAujourdui()
    {
           int id_adherent , id_book;
           Adherent A ;
           ArrayList<ReservationP> li = new ArrayList<ReservationP>();
       try {
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            ResultSet res = st.executeQuery(Requests.Emprunt_getLivre_Aujourdui());
            while(res.next())
            {
               id_book = res.getInt(1);
               id_adherent = res.getInt(2);
               A = DAO.AdherentDAO.Adh_Id(id_adherent);
               li.add( new ReservationP(id_book, BookDAO.getBook(id_book).getTitreBook(), id_adherent,  new String(A.getCIN()) , new String(A.getNomAdherent()) , new String(A.getPrenomAdherent()) ));
                
            }
        } catch (Exception e) {
            System.out.println("----"+e.getMessage());
            return null;
        }
          return li;
    }
    

    public static void main(String[] str)
{
for (ReservationP b : getLivreAujourdui())
        System.out.println(b);
}
    
    
}

