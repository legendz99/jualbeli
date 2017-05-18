package koneksi;


import java.sql.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class conn {
   private static Connection KoneksiDB;
   public static Connection getKoneksi() {
       if (KoneksiDB == null) {
        try{
            KoneksiDB = DriverManager.getConnection("jdbc:ucanaccess://src/Database/DBJualBeli.accdb");
        }catch(SQLException e){
            {JOptionPane.showMessageDialog(null,"error"+e, "Failed Connect Database",JOptionPane.WARNING_MESSAGE);}
        }
       }
       return KoneksiDB;
    }
}

