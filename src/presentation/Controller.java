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

            case 1 -> createPlayer();
            case 2 -> showPlayers();
            case 3 -> updatePlayer();
            case 4 -> deletePlayer();

            case 5 -> createTeam();
            case 6 -> deleteTeam();

            case 7 -> addPlayerToTeam();
            case 8 -> removePlayerFromTeam();

            case 9 -> showTeamPlayers();
            case 10 -> showPlayerInfo();
            case 11 -> showSummary();
            case 12 -> simulateMatch();

            case 13 -> {
                ui.showMessage("Exit...");
                running = false;
            }

            default -> ui.showMessage("Invalid option");
        }
    }

    // =========================
    // PLAYERS
    // =========================

    private void createPlayer() {

        String name = ui.askString("Player name: ");
        int number = ui.askInt("Player number: ");

        players.add(new Player(playerIdCounter++, name, number));

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

    private void updatePlayer() {

        int id = ui.askInt("Player ID: ");

        Player player = findPlayer(id);

        if (player == null) {
            ui.showMessage("Player not found");
            return;
        }

        String newName = ui.askString("New name: ");
        int newNumber = ui.askInt("New number: ");

        players.remove(player);
        players.add(new Player(id, newName, newNumber));

        ui.showMessage("Player updated");
    }

    private void deletePlayer() {

        int id = ui.askInt("Player ID: ");

        players.removeIf(p -> p.getId() == id);

        ui.showMessage("Player deleted");
    }

    // =========================
    // TEAMS
    // =========================

    private void createTeam() {

        String name = ui.askString("Team name: ");

        teams.add(new Team(teamIdCounter++, name));

        ui.showMessage("Team created");
    }

    private void deleteTeam() {

        int id = ui.askInt("Team ID: ");

        teams.removeIf(t -> t.getId() == id);

        ui.showMessage("Team deleted");
    }

    // =========================
    // RELATION TEAM - PLAYER
    // =========================

    private void addPlayerToTeam() {

        int teamId = ui.askInt("Team ID: ");
        int playerId = ui.askInt("Player ID: ");

        Team team = findTeam(teamId);
        Player player = findPlayer(playerId);

        if (team != null && player != null) {
            team.addPlayer(player);
            ui.showMessage("Player added to team");
        } else {
            ui.showMessage("Team or Player not found");
        }
    }

    private void removePlayerFromTeam() {

        int teamId = ui.askInt("Team ID: ");
        int playerId = ui.askInt("Player ID: ");

        Team team = findTeam(teamId);

        if (team != null) {
            team.getPlayers().removeIf(p -> p.getId() == playerId);
            ui.showMessage("Player removed from team");
        }
    }

    private void showTeamPlayers() {

        int teamId = ui.askInt("Team ID: ");

        Team team = findTeam(teamId);

        if (team == null) {
            ui.showMessage("Team not found");
            return;
        }

        ui.showMessage("Team: " + team.getName());

        for (Player p : team.getPlayers()) {
            ui.showMessage("- " + p.getName());
        }
    }

    // =========================
    // INFO
    // =========================

    private void showPlayerInfo() {

        int id = ui.askInt("Player ID: ");

        Player p = findPlayer(id);

        if (p != null) {
            ui.showMessage(p.getId() + " - " + p.getName() + " #" + p.getNumber());
        }
    }

    private void showSummary() {

        for (Team t : teams) {

            System.out.print(t.getName() + ": ");

            for (Player p : t.getPlayers()) {
                System.out.print(p.getName() + " ");
            }

            System.out.println();
        }
    }

    private void simulateMatch() {

        int t1 = ui.askInt("Team 1 ID: ");
        int t2 = ui.askInt("Team 2 ID: ");

        Team team1 = findTeam(t1);
        Team team2 = findTeam(t2);

        if (team1 == null || team2 == null) {
            ui.showMessage("Team not found");
            return;
        }

        int s1 = (int)(Math.random() * 5);
        int s2 = (int)(Math.random() * 5);

        ui.showMessage(team1.getName() + " " + s1 + " - " + s2 + " " + team2.getName());
    }

    // =========================
    // FINDERS
    // =========================

    private Player findPlayer(int id) {
        return players.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private Team findTeam(int id) {
        return teams.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }
}