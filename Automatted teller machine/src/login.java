/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aryan
 */
import java.sql.*;
import java.util.*;

public class login {
    public static void main(String args[]) throws Exception {

        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("Welcome user to the ATM");

        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection con = DriverManager.getConnection("jdbc:sqlite:C://Atm//atm.db");
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery("select * from login")) {
                int pin;
                String pass;
                while (rs.next()) {
                    pin = rs.getInt("pin");
                    pass = rs.getString("password");

                    // System.out.println(pin+" "+pass);

                    @SuppressWarnings("resource")
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter the PIN");
                    int p = sc.nextInt();
                    System.out.println("Enter the password");
                    String pas = sc.next();
                    stm.close();
                    rs.close();

                    if (p == pin) {
                        if (pas.matches(pass)) {
                            System.out.println("Welcome user");
                            Menu m = new Menu();
                            m.display(sc);

                            return;
                        }
                    } else {
                        System.out.println("Invalid user id < Enter Again");
                    }
                }

            }
        } catch (ClassNotFoundException exp) {
            exp.printStackTrace(); // Log the exception or handle it appropriately
        } catch (SQLException sq) {
            sq.printStackTrace();
        }

    }
}
