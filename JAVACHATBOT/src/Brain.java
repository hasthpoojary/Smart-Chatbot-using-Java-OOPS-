import java.io.*;
import java.util.*;

public class Brain {

    private static final String FILE = "knowledge.txt";
    private HashMap<String, String> knowledge = new HashMap<>();

    public Brain() {
        loadFromFile();
    }

    public void learn(String topic, String info) {
        knowledge.put(topic.toLowerCase().trim(), info.trim());
        saveToFile();
    }

    public String recall(String topic) {
        String key = topic.toLowerCase().trim();


        if (knowledge.containsKey(key)) {
            return knowledge.get(key);
        }

        for (Map.Entry<String, String> entry : knowledge.entrySet()) {
            if (entry.getKey().contains(key) || key.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        return null; 
    }

    public void showAll() {
        if (knowledge.isEmpty()) {
            System.out.println("  I have not learned anything yet.");
            return;
        }
        System.out.println("\n  Everything I know:");
        System.out.println("  " + "-".repeat(35));
        int i = 1;
        for (Map.Entry<String, String> entry : knowledge.entrySet()) {
            System.out.println("  " + i + ". " + entry.getKey() + " -> " + entry.getValue());
            i++;
        }
        System.out.println("  " + "-".repeat(35));
    }

    public int count() {
        return knowledge.size();
    }

    private void saveToFile() {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(FILE))) {
            for (Map.Entry<String, String> e : knowledge.entrySet()) {
                w.write(e.getKey() + "==" + e.getValue());
                w.newLine();
            }
        } catch (IOException e) {
            System.out.println("  Could not save: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File f = new File(FILE);
        if (!f.exists()) return;
        try (BufferedReader r = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = r.readLine()) != null) {
                int sep = line.indexOf("==");
                if (sep > 0) {
                    knowledge.put(line.substring(0, sep), line.substring(sep + 2));
                }
            }
        } catch (IOException e) {
        }
    }
}
