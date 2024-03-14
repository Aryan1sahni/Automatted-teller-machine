import java.sql.*;
import java.util.Scanner;

public class ChangePin {
    public void showpin()throws Exception{
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:C://Atm//atm.db");
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from login");

        int pin;
        int Pinno=0;
        Scanner sc = new Scanner(System.in);
        while(rs.next()){
            pin=rs.getInt("pin");
            

            System.out.println("Enter the pin you want to insert");
            Pinno= sc.nextInt(); 

        }
        PreparedStatement pstm = con.prepareStatement("update login set pin=?");
        pstm.setInt(1, Pinno);
        pstm.executeUpdate();

        
    }
}
