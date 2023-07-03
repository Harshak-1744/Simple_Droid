import java.util.*;
import java.util.ArrayList;

public class Droid
{
    String welcome;
    Droid(String value)
    {
        this.welcome = value;
    }

    public static void main(String [] args)
    {
        Droid M = new Droid("Hola...! I am Droid");
        System.out.println(M.welcome);

        System.out.println("Tasks i can perform");


        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("[1] Write a Mail and send it");
        tasks.add("[2] Get the stock updated");
        tasks.add("[3] Water the Plants");
        tasks.add("[4] Task Remainder");

        for(String i: tasks)
        {
            System.out.println(i);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your task number:-");
        int n = sc.nextInt();
        
        
        switch(n)
        {
            case 1:
                System.out.println("why bro");
            break;
        
        }
    
    

    sc.close();    
    }

}