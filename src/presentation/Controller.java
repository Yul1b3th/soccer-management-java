package presentation;

public class Controller {

    private final UserInterface ui = new UserInterface();
    private boolean running = true;

    public void run() {

        while (running) {

            ui.showMenu();
            int option = ui.askOption();

            handleOption(option);
        }
    }

    private void handleOption(int option) {

        switch (option) {

            case 1:
                ui.showMessage("Add Player selected");
                break;

            case 2:
                ui.showMessage("Show Players selected");
                break;

            case 3:
                ui.showMessage("Update Player selected");
                break;

            case 4:
                ui.showMessage("Delete Player selected");
                break;

            case 5:
                ui.showMessage("Add Team selected");
                break;

            case 6:
                ui.showMessage("Show Teams selected");
                break;

            case 7:
                ui.showMessage("Exit...");
                running = false;
                break;

            default:
                ui.showMessage("Invalid option");
        }
    }
}