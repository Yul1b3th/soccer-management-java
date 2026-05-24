package presentation;

import model.Player;
import model.Team;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Player> players = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();

    private int playerIdCounter = 1;
    private int teamIdCounter = 1;

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
                createPlayer();
                break;

            case 2:
                showPlayers();
                break;

            case 3:
                ui.showMessage("Update Player selected");
                break;

            case 4:
                ui.showMessage("Delete Player selected");
                break;

            case 5:
                createTeam();
                break;

            case 6:
                showTeams();
                break;

            case 7:
                ui.showMessage("Exit...");
                running = false;
                break;

            default:
                ui.showMessage("Invalid option");
        }
    }

    private void createPlayer() {

        String name = ui.askString("Player name: ");
        int number = ui.askInt("Player number: ");

        Player player = new Player(playerIdCounter++, name, number);
        players.add(player);

        ui.showMessage("Player created");
    }

    private void showPlayers() {

        if (players.isEmpty()) {
            ui.showMessage("No players");
            return;
        }

        for (Player p : players) {
            ui.showMessage(p.getId() + " - " + p.getName() + " (" + p.getNumber() + ")");
        }
    }

    private void createTeam() {

        String name = ui.askString("Team name: ");

        Team team = new Team(teamIdCounter++, name);
        teams.add(team);

        ui.showMessage("Team created");
    }

    private void showTeams() {

        if (teams.isEmpty()) {
            ui.showMessage("No teams");
            return;
        }

        for (Team t : teams) {

            ui.showMessage("Team: " + t.getName());

            for (Player p : t.getPlayers()) {
                ui.showMessage("  - " + p.getName());
            }
        }
    }

}