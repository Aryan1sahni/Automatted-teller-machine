import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aryan
 */
public class Creditcard {
    public void card()throws Exception{
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = sc.next();
        System.out.println("Welcome ,"+name);
        
        
        Random rand = new Random();
        int cr = rand.nextInt(1000);
        
        System.out.println("Your cresit card no is "+cr);

        Connection con = DriverManager.getConnection("jdbc:sqlite:C://Atm//atm.db");
        Statement stm = con.createStatement(); 
        PreparedStatement pstm = con.prepareStatement("insert into credit values(?)");

        pstm.setInt(1, cr);
        pstm.executeUpdate();

        
    }
    
}
