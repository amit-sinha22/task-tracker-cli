import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static final String FILE_NAME = "tasks.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static List<Task> loadTasks() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader(file));
            return gson.fromJson(reader, new TypeToken<List<Task>>() {
            }.getType());
        } catch (Exception e) {
            System.out.println("Error reading tasks.");
            return new ArrayList<>();
        }
    }

    public static void saveTasks(List<Task> tasks) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    public static void addTask(String description) {
        List<Task> tasks = loadTasks();
        int id = tasks.size() + 1;
        Task task = new Task(id, description);
        tasks.add(task);
        saveTasks(tasks);
        System.out.println("Task added: " + description + "(ID: " + id + ")");
    }

    public static void listTasks() {
        List<Task> tasks = loadTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
        } else {
            for (Task task : tasks) {
                System.out.println(task.id + ". [" + task.status + "] " + task.description);
            }
        }
    }
}
