
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aryan
 */
public class Deposit {
    public void showdep() throws Exception {
        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection con = DriverManager.getConnection("jdbc:sqlite:C://Atm//atm.db");

                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery("select * from user")) {

                int bal = 0;
                int amt;
                @SuppressWarnings("resource")
                Scanner sc = new Scanner(System.in);
                // int newbal;

                while (rs.next()) {
                    bal = rs.getInt("balance");
                    System.out.println("Enter the amount you want to deposit");
                    amt = sc.nextInt();
                    bal = bal + amt;
                    System.out.println("The changed balance amount is " + bal);

                }

                String query = "update user set balance=? where custid=1";

                try (PreparedStatement pstm = con.prepareStatement(query)) {
                    pstm.setInt(1, bal);

                    pstm.executeUpdate();
                    pstm.close();
                }

                con.close();
                stm.close();
                rs.close();
            }
        } catch (SQLException exp) {
            exp.printStackTrace();
        } catch (ClassNotFoundException exp) {
            exp.printStackTrace();
            System.out.println("Failed to load driver");

        }

    }
}
