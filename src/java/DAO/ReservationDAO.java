/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Reservation;
import java.sql.Statement;

/**
 *
 * @author zGuindouOS
 */
public class ReservationDAO {
    
    public static void addReservation(Reservation r) {
        try {
            Statement st = Factory.ConnectionFactory.getConnection().createStatement();
            st.executeUpdate(Requests.newReservation(r));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
