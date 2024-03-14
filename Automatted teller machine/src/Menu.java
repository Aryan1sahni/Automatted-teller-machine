/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aryan
 */
import java.util.*;

class Menu {

  public void display(Scanner Scanner) throws Exception {

    System.out.println("1. View Balance ");
    System.out.println("2. Withdraw amount");
    System.out.println("3. Deposit Amount");
    System.out.println("4. Apply credit card");
    System.out.println("5. Change PIN");
    System.out.println("6. Exit");

    System.out.println("Select choice you want to select ");
    int choice = Scanner.nextInt();

    System.out.println();
    switch (choice) {
      case 1:
        System.out.println("The balance for your account");
        balance b = new balance();
        b.balanceshow();
        break;

      case 2:
        System.out.println("Write the amount you want to withdraw");
        Withdraw w = new Withdraw();
        w.showwith();

        break;

      case 3:
        System.out.println("Write the amount you want to deposit");
        Deposit d = new Deposit();
        d.showdep();
        break;

      case 4:
        System.out.println("Apply for Credit Card");
        Creditcard c = new Creditcard();
        c.card();
        break;

      case 5:
        System.out.println("change pin");
        ChangePin cp = new ChangePin();
        cp.showpin();
        break;

      case 6:
        System.out.println("Exit");
        Exit e = new Exit();
        e.makeexit();
        break;

      default:
        System.out.println("Invalid choice");

    }

  }

}
