package DAO;

import Beans.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zGuindouOS, l.IsSaM.l on 26/12/2016.
 */
public class Requests {

    
     // LES REQUETES DE   BOOK 
    
    public static String Book_All() {
        return "select * from Book;";
    }

    public static String Book_CodeBook(String Code) {
        return "select * from Book where CodeBook = '" + Code + "';";
    }
    
     public static String Book_IdBook(long idBook) {
        return "select * from Book where idBook = '" + idBook + "';";
    }

    public static String Book_Disponible_All() {
        return "select * from Book where image = true;";
    }

    public static String Book_No_Disponible_All() {
        return "select * from Book where image = false;";
    }

    public static String Book_Categorie_All(String Categ) {
        return "select * from Book where CategorieBook = '" + Categ + "';";
    }

    public static String Book_Update(Book b) {
        return "update Book set CodeBook = '"  + b.getCodeBook()
                + "',titreBook = '"  + b.getTitreBook()
                + "',auteurBook = '"  + b.getAuteurBook()
                + "',CategorieBook = '"  + b.getNombreCopieBook()
                + "',NombreCopieBook = '"  + b.getNombreCopieBook()
                + "',dateparution = '"  + b.getDateParution()
                + "' where idBook = '" + b.getIdBook() + "';";
                
               
    }

    // LES REQUETES DES ADHERENTS
    public static String Adhenrent_all() {
        return " select * from adherent where etatAdherent !=0  ;";  
    }

    public static String Adh_CIN(String CIN) {
        return " select * from adherent where CIN ='" + CIN + "';";
    }

    public static String Adh_CODE(String CODE) {
        return " select * from adherent where CodeAdherent ='" + CODE + "';";
    }
    
     public static String Adh_ID(int id) {
        return " select * from adherent where IdAdherent ='" + id + "';";
    }

    public static String Adh_like_Nom(String Nom) {
        return "select * from adherent where NomAdherent like '%" + Nom + "%';";
    }

    public static String Adh_Add(Adherent Adh) {
        return "INSERT INTO `adherent`(`CodeAdherent`, `CIN`, `NomAdherent`, `PrenomAdherent`, `ProfessionAdherent`) VALUES ('" + Adh.getCodeAdherent() + "','" + Adh.getCIN() + "','" + Adh.getNomAdherent() + "','" + Adh.getPrenomAdherent() + "','" + Adh.getProfessionAdherent() + "');";
    }

    public static String Adh_del_CIN(String CIN) {
        return "delete from adherent where CIN ='" + CIN + "';";
    }

    public static String Adh_del_CODE(String CODE) {
        return "delete from adherent where CodeAdherent ='" + CODE + "';";
    }

    public static String Adh_Update_By_CIN(Adherent Adh) {
        return "UPDATE Adherent SET CodeAdherent='" + Adh.getCodeAdherent() + "',NomAdherent='" + Adh.getNomAdherent() + "',PrenomAdherent='" + Adh.getPrenomAdherent() + "',ProfessionAdherent='" + Adh.getProfessionAdherent() + "' WHERE CIN ='" + Adh.getCIN() + "';";
    }

    public static String Adh_profil(String CIN, String CODE) {
        return "select * from adherent where CIN='" + CIN + "' and CodeAdherent='" + CODE + "';";
    }
    
    // LES REQUETES DE L'ADMIN
    
    public static String AdminExist(String name , String passwd) {
        return "select * from admin where login='" + name + "' and passwd='" + passwd + "';";
    }
    
    public static String Admin_getAdmin(String name , String passwd)
    {
       return "select * from admin where login='" + name + "' and passwd='" + passwd + "';"; 
    }
    
        // LES REQUETES DE L'EMPRUNT 
    
    public static String Emprunt_En_cours_By_Adh(int id_adherent)
    {
        
        return  "select B.idBook , B.titreBook, E.DateSortie, E.DateMax from emprunt E , Book B where E.IdAdherent = '" + id_adherent + "' AND DateRetour is null AND E.idBook = B.idBook ;";
    }
    
    public static String Emprunt_Remis_By_Adh(int id_adherent)
    {

        return  "select B.idBook , B.titreBook, E.DateSortie, E.DateMax from emprunt E , Book B where E.IdAdherent = '" + id_adherent + "' AND DateRetour is not null AND E.idBook = B.idBook ;";
    }
    
    public static String Emprunt_Book_Remis(int id_adherent, int id_book)
    {
        return  "update emprunt set DateRetour='" + new SimpleDateFormat("YYYY-MM-dd").format(new Date()) + "' where IdAdherent = '" + id_adherent + "' AND DateRetour is null AND idBook = '" + id_book + "' ;";
    }
    
}
