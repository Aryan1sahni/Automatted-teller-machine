
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class balance {
    public void balanceshow() throws Exception {

        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection con = DriverManager.getConnection("jdbc:sqlite:C://Atm//atm.db");
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery("select * from user")) {

                int balance;

                while (rs.next())

                {

                    balance = rs.getInt("balance");

                    System.out.println(" balance = " + balance);
                    /*
                     * ResultSetMetaData metaData = rs.getMetaData();
                     * int columnCount = metaData.getColumnCount();
                     * 
                     * for (int i = 1; i <= columnCount; i++) {
                     * System.out.println("Column name: " + metaData.getColumnName(i));
                     * }
                     */
                }
                con.close();
                stm.close();
                rs.close();
            }
        } catch (ClassNotFoundException exp) {
            exp.printStackTrace();
        } catch (SQLException sq) {
            sq.printStackTrace();
        }

    }
}
