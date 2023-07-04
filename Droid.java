import java.util.ArrayList;
import java.util.Scanner;

class Task 
{
    private String name;
    private String description;

    public Task(String name, String description) 
    {
        this.name = name;
        this.description = description;
    }

    public String getName() 
    {
        return name;
    }

    public String getDescription() 
    {
        return description;
    }
}

public class Droid 
{
    String welcome;
    int battery;
    ArrayList<Task> tasks;

    public Droid(String value) 
    {
        this.welcome = value;
        this.battery = 100;
        this.tasks = new ArrayList<>();
    }

    public static void main(String[] args) 
    {
        Droid M = new Droid("Hola...! I am Droid");
        System.out.println(M.welcome);

        Scanner sc = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Tasks I can perform");

            ArrayList<String> taskOptions = new ArrayList<>();
            taskOptions.add("[1] Write a Mail and send it");
            taskOptions.add("[2] Get the stock updated");
            taskOptions.add("[3] Water the Plants");
            taskOptions.add("[4] Add/View/Remove Task");

            for (String option : taskOptions) 
            {
                System.out.println(option);
            }

            System.out.println("Enter your task number:");
            int n = sc.nextInt();
            sc.nextLine(); 

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
                    String Plants = "20 mins";
                    System.out.println("Time taken to water the Plants is " + Plants);
                    M.decreaseBattery();
                    break;
                case 4:
                    System.out.println("Task Manager");
                    System.out.println("1. Add a task");
                    System.out.println("2. View tasks");
                    System.out.println("3. Remove a task");
                    System.out.print("Enter your choice: ");
                    int choiceNum = sc.nextInt();
                    sc.nextLine(); 
                    switch (choiceNum) 
                    {
                        case 1:
                            System.out.print("Enter task name: ");
                            String taskName = sc.nextLine();
                            System.out.print("Enter task description: ");
                            String taskDescription = sc.nextLine();
                            M.addTask(taskName, taskDescription);
                            break;
                        case 2:
                            M.viewTasks();
                            break;
                        case 3:
                            M.viewTasks();
                            if (!M.tasks.isEmpty()) 
                            {
                                System.out.print("Enter the task number to remove: ");
                                int removeNum = sc.nextInt();
                                sc.nextLine(); 
                                M.removeTask(removeNum);
                            }
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid task number");
                    break;
            }
            if (M.battery < 20) 
            {
                System.out.println("Warning: Battery level is low!");
            }
            System.out.println("Battery percentage: " + M.battery + "%");

            System.out.println("Do you want to perform another task? (yes/no):");
            choice = sc.nextLine();
        } while (choice.equalsIgnoreCase("yes"));

        System.out.println("Exiting...");
        sc.close();
    }

    public void sendEmail() 
    {    
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

    public void addTask(String name, String description) 
    {
        Task newTask = new Task(name, description);
        tasks.add(newTask);
        System.out.println("Task added successfully!");
        decreaseBattery();
    }

    public void viewTasks() 
    {
        if (tasks.isEmpty()) 
        {
            System.out.println("No tasks found.");
        } 
        else 
        {
            for (int i = 0; i < tasks.size(); i++) 
            {
                Task task = tasks.get(i);
                System.out.println("Task " + (i + 1) + ":");
                System.out.println("Name: " + task.getName());
                System.out.println("Description: " + task.getDescription());
                System.out.println();
                decreaseBattery();
            }
        }
    }

    public void removeTask(int index) 
    {
        if (index >= 1 && index <= tasks.size()) 
        {
            Task removedTask = tasks.remove(index - 1);
            System.out.println("Removed task:");
            System.out.println("Name: " + removedTask.getName());
            System.out.println("Description: " + removedTask.getDescription());
            System.out.println("Task removed successfully!");
            decreaseBattery();
        } 
        else 
        {
            System.out.println("Invalid task number.");
        }
    }
}
