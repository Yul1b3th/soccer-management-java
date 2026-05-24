package presentation;

import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n--- SOCCER MENU ---");
        System.out.println("1. Create Player");
        System.out.println("2. Show Players");
        System.out.println("3. Update Player");
        System.out.println("4. Delete Player");
        System.out.println("5. Create Team");
        System.out.println("6. Delete Team");
        System.out.println("7. Add Player to Team");
        System.out.println("8. Remove Player from Team");
        System.out.println("9. Show Team Players");
        System.out.println("10. Show Player Info");
        System.out.println("11. Show Summary");
        System.out.println("12. Simulate Match");
        System.out.println("13. Exit");
    }

    public int askOption() {
        System.out.print("Select option: ");
        return scanner.nextInt();
    }

    public String askString(String message) {
        System.out.print(message);
        return scanner.next();
    }

    public int askInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}