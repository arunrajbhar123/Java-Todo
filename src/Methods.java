import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Methods {
    private final ArrayList<Task> taskArrayList;
    private final Scanner scanner;

    public Methods() {
        taskArrayList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addTask(String task) {
        taskArrayList.add(new Task(task));
    }

    public void setCompletedTask(int index) {
        if (index >= 0 && index < taskArrayList.size()) {
            taskArrayList.get(index).setCompleted();

        } else {
            System.out.println("Please Enter Valid Id");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < taskArrayList.size()) {
            taskArrayList.remove(index);

        } else {
            System.out.println("Please Enter Valid Id");
        }

    }

    public void updateTask(int index, String task) {
        taskArrayList.get(index).setTask(task);
    }

    public void displayTask() {
        int size = taskArrayList.size();
        System.out.println("********** TASKS START ************");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + taskArrayList.get(i));
        }
        System.out.println("********** TASKS END ************");
    }

    public boolean validateEmpty() {
        boolean empty = taskArrayList.isEmpty();
        if (empty) {
            System.out.println("Please First Enter Some Tasks.");
        }
        return empty;


    }


    public void run() {
        while (true) {
            System.out.println("\n MENU:");
            System.out.println("1. Add Task.");
            System.out.println("2. Mark as completed.");
            System.out.println("3. Display the tasks.");
            System.out.println("4. Delete Task.");
            System.out.println("5. Update Task.");
            System.out.println("6. Exist.");
            System.out.println("Choose option:");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter New Task: ");
                    String task = scanner.nextLine();
                    while (Objects.equals(task, "")) {
                        System.out.println("Please Enter Valid New Task: ");
                        task = scanner.nextLine();
                    }
                    addTask(task);
                    break;
                case 2:
                    if (validateEmpty()) break;
                    System.out.println("Enter Id To Set IsCompleted:");
                    int index = scanner.nextInt() - 1;
                    setCompletedTask(index);
                    break;
                case 3:
                    if (validateEmpty()) break;
                    displayTask();
                    break;
                case 4:
                    if (validateEmpty()) break;
                    System.out.println("Enter Id For Delete:");
                    int i = scanner.nextInt() - 1;
                    deleteTask(i);
                    break;
                case 5:
                    if (validateEmpty()) break;
                    System.out.println("Enter Id For Update:");
                    int updateIndex = scanner.nextInt()-1;
                    scanner.nextLine();
                    System.out.println("Enter Task For Update:");
                    String updateTask = scanner.nextLine();
                    updateTask(updateIndex, updateTask);
                    break;

                case 6:
                    System.out.println("Existing...");
                    return;
                default:
                    System.out.println("Please enter valid input.");
                    break;
            }


        }
    }


}
