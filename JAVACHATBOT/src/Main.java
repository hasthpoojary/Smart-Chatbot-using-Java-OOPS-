import java.util.*;

public class Main {

    static Scanner sc   = new Scanner(System.in);
    static Brain   brain = new Brain();

    public static void main(String[] args) {
        showWelcome();
        mainMenu();
    }

  
    static void showWelcome() {
        System.out.println();
        System.out.println("  ================================");
        System.out.println("         SimpleBot - Java        ");
        System.out.println("  ================================");
        System.out.println("  A chatbot that learns from you!");
        System.out.println();

        if (brain.count() > 0) {
            System.out.println("  I already know " + brain.count() + " things from before.");
        }

        System.out.println();
    }

  
    static void mainMenu() {
        while (true) {
            System.out.println();
            System.out.println("  ---- MENU ----");
            System.out.println("  1. Teach me something");
            System.out.println("  2. Ask me a question");
            System.out.println("  3. Show all I know");
            System.out.println("  4. Exit");
            System.out.println("  --------------");
            System.out.print("  Choose (1/2/3/4): ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> learnMode();
                case "2" -> askMode();
                case "3" -> {
                    System.out.println();
                    brain.showAll();
                }
                case "4" -> {
                    System.out.println();
                    System.out.println("  Goodbye! I will remember everything.");
                    System.out.println();
                    System.exit(0);
                }
                default -> System.out.println("  Please enter 1, 2, 3 or 4.");
            }
        }
    }

    static void learnMode() {
        System.out.println();
        System.out.println("  == LEARN MODE ==");
        System.out.println("  Tell me anything! I will remember it.");
        System.out.println("  Type 'done' to go back to menu.");
        System.out.println();

        while (true) {
            System.out.print("  What's on your Mind Now!!!: ");
            String topic = sc.nextLine().trim();

            if (topic.equalsIgnoreCase("done")) {
                System.out.println("  Going back to menu...");
                return;
            }

            if (topic.isEmpty()) {
                System.out.println("  Topic cannot be empty. Try again.");
                continue;
            }

            System.out.print("  What about it? : ");
            String info = sc.nextLine().trim();

            if (info.isEmpty()) {
                System.out.println("  Info cannot be empty. Try again.");
                continue;
            }

            brain.learn(topic, info);
            System.out.println("  Got it! I learned: [" + topic + "] = " + info);
            System.out.println();
        }
    }

    static void askMode() {
        System.out.println();
        System.out.println("  == ASK MODE ==");
        System.out.println("  Ask me anything you have taught me.");
        System.out.println("  Type 'done' to go back to menu.");
        System.out.println();

        while (true) {
            System.out.print("  Your question: ");
            String question = sc.nextLine().trim();

            if (question.equalsIgnoreCase("done")) {
                System.out.println("  Going back to menu...");
                return;
            }

            if (question.isEmpty()) continue;

            String topic = question
                .toLowerCase()
                .replace("what is", "")
                .replace("what are", "")
                .replace("tell me about", "")
                .replace("who is", "")
                .replace("where is", "")
                .replace("what is my", "")
                .replace("my", "")
                .replace("?", "")
                .trim();

            String answer = brain.recall(topic);

            if (answer != null) {
                System.out.println("  Answer: " + answer);
            } else {
                System.out.println("  Sorry, I don't know about \"" + topic + "\" yet.");
                System.out.println("  Go to menu -> option 1 to teach me!");
            }

            System.out.println();
        }
    }
}
