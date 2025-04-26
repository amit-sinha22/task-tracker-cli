//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a command: add, list");
            return;
        }

        String command = args[0];

        switch (command) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Usage: add \"task description\"");
                } else {
                    TaskManager.addTask(args[1]);
                }
                break;
            case "list":
                TaskManager.listTasks();
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
        }
    }
