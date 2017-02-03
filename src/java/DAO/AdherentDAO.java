package DAO;

/**
 * Created by zGuindouOS, l.IsSaM.l on 27/12/2016.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Beans.Adherent;
import DAO.Requests;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class AdherentDAO {

    public static LinkedList<Adherent> Adherentliste() {
        LinkedList<Adherent> li_Adh = null;
        try {
            li_Adh = new LinkedList<Adherent>();
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            ResultSet res = st.executeQuery(Requests.Adhenrent_all());
            while (res.next()) {

                li_Adh.add(new Adherent(res.getInt(1),res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7)));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return li_Adh;
            
        }
    }

    public static Adherent Adh_CIN(String CIN) {
        Adherent Adh = new Adherent();
        try {
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            ResultSet res = st.executeQuery(Requests.Adh_CIN(CIN));
            res.next();

            Adh = new Adherent(res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return Adh;
        }
    }
    
      public static Adherent Adh_Id(int Id) {
        Adherent Adh = new Adherent();
        try {
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            ResultSet res = st.executeQuery(Requests.Adh_ID(Id));
            res.next();

            Adh = new Adherent(res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return Adh;
        }
    }

    public static Adherent Adh_CODE(String CODE) {
        Adherent Adh = new Adherent();
        try {
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            ResultSet res = st.executeQuery(Requests.Adh_CODE(CODE));
            res.next();

            Adh = new Adherent(res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return Adh;
        }
    }

    public static LinkedList<Adherent> Search_By__like_Nom(String Nom) {
        LinkedList<Adherent> li_Adh = null;
        try {
            li_Adh = new LinkedList<Adherent>();
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            ResultSet res = st.executeQuery(Requests.Adh_like_Nom(Nom));
            while (res.next()) {

                li_Adh.add(new Adherent(res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return li_Adh;
        }
    }

    public static boolean Adh_Add(Adherent Adh) {
        try {
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            st.executeUpdate(Requests.Adh_Add(Adh));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean Adh_delete_CIN(String CIN) {
        try {
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            st.executeUpdate(Requests.Adh_del_CIN(CIN));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean Adh_delete_CODE(String CODE) {
        try {
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            st.executeUpdate(Requests.Adh_del_CODE(CODE));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean Update_CIN(Adherent Adh) {
        try {
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            st.executeUpdate(Requests.Adh_Update_By_CIN(Adh));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static void AfficherAdherent(LinkedList<Adherent> li) {

        for (int i = 0; i < li.size(); i++) {
            System.out.println(li.get(i));
        }
    }

    public static void main(String[] arg) {

        for (int i = 0; i <= 500; i++) {
            Adh_Add(new Adherent(new Integer(i).toString(), new Integer(i).toString(), new Integer(i).toString(), new Integer(i).toString(), new Integer(i).toString()));
        }

    }

}
