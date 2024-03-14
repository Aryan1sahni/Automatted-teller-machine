
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
public class Withdraw {

    int bal;
    int amt;

    public void showwith() throws Exception{
           
    
            Class.forName("org.sqlite.JDBC");
            try (Connection con = DriverManager.getConnection("jdbc:sqlite:C://Atm//atm.db");
                    Statement stm = con.createStatement()) {
                ResultSet rs = stm.executeQuery("select * from user");

                @SuppressWarnings("resource")
                Scanner sc = new Scanner(System.in);

                while (rs.next()) {
                    bal = rs.getInt("balance");
                    System.out.println("Enter the amount you want to withdraw");
                    amt = sc.nextInt();
                    if (amt <= bal) {
                        bal = bal - amt;

                        System.out.println("The remaining balance is : " + bal);

                    } else {
                        System.out.println("Insufficient funds. Withdrawal not allowed.");
                    }
                }

                String query = "update user set balance=? where custid=1";

                try (PreparedStatement pstmt = con.prepareStatement(query)) {

                    pstmt.setInt(1, bal);

                    pstmt.executeUpdate();
                    
                }

                

            } catch (SQLException exp) {
                exp.printStackTrace();
            }
            
        

    }

}
