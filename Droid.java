import java.util.*;
import java.util.ArrayList;

public class Droid {
    String welcome;
    int battery;

    Droid(String value) {
        this.welcome = value;
        this.battery = 100;
    }

    public static void main(String[] args) {
        Droid M = new Droid("Hola...! I am Droid");
        System.out.println(M.welcome);

        Scanner sc = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Tasks I can perform");

            ArrayList<String> tasks = new ArrayList<>();
            tasks.add("[1] Write a Mail and send it");
            tasks.add("[2] Get the stock updated");
            tasks.add("[3] Water the Plants");
            tasks.add("[4] Task Reminder");

            for (String i : tasks) {
                System.out.println(i);
            }

            System.out.println("Enter your task number:");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    M.sendEmail();
                    M.decreaseBattery();
                    break;
                case 2:
                    System.out.println("Performing task: Get the stock updated");
                    M.decreaseBattery();
                    break;
                case 3:
                    System.out.println("Performing task: Water the Plants");
                    String Plants = " 20 mins";
                    System.out.println("Time taken to water the Plants is" +" "+ Plants);
                    M.decreaseBattery();
                    break;
                case 4:
                    System.out.println("Performing task: Task Reminder");
                    M.decreaseBattery();
                    break;
                default:
                    System.out.println("Invalid task number");
                    break;
            }

            System.out.println("Battery percentage: " + M.battery + "%");

            System.out.println("Do you want to perform another task? (yes/no):");
            choice = sc.next();
        } while (choice.equalsIgnoreCase("yes"));

        System.out.println("Exiting...");
        sc.close();
    }

    public void sendEmail() 
    {
        // Email sending logic
        System.out.println("Performing task: Write a Mail and send it");
    }

    public void decreaseBattery() 
    {
        if (battery >= 4) 
        {
            battery -= 4;
        } else 
        {
            battery = 0;
        }
    }
}
