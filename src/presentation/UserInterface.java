package presentation;

import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n--- SOCCER MENU ---");
        System.out.println("1. Add Player");
        System.out.println("2. Show Players");
        System.out.println("3. Update Player");
        System.out.println("4. Delete Player");
        System.out.println("5. Add Team");
        System.out.println("6. Show Teams");
        System.out.println("7. Exit");
    }

    public int askOption() {
        System.out.print("Select option: ");
        return scanner.nextInt();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}