package DAO;

import Beans.*;

/**
 * Created by zGuindouOS, l.IsSaM.l on 26/12/2016.
 */
public class Requests {

    public static String Book_All() {
        return "select * from Book;";
    }

    public static String Book_CodeBook(String Code) {
        return "select * from Book where CodeBook = '" + Code + "';";
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
        return "update Book set CodeBook = " + b.getCodeBook()
                + ",titreBook = " + b.getTitreBook()
                + ",auteurBook = " + b.getAuteurBook()
                + ",CategorieBook = " + b.getNombreCopieBook()
                + ",NombreCopieBook = " + b.getNombreCopieBook()
                + ",image = " + b.getimage();
    }

    // LES REQUETES DES ADHERENTS
    public static String Adhenrent_all() {
        return " select * from adherent;";
    }

    public static String Adh_CIN(String CIN) {
        return " select * from adherent where CIN ='" + CIN + "';";
    }

    public static String Adh_CODE(String CODE) {
        return " select * from adherent where CodeAdherent ='" + CODE + "';";
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
}
