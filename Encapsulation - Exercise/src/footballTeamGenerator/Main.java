package footballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static String[] input = null;
    private static Team temporaryTeam;
    private static final Map<String, Team> teams = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        readFromConsole(scanner);
        while (!input[0].equals("END")) {
            try {
                executeCommand();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
            readFromConsole(scanner);
        }
    }

    private static void executeCommand() {
        String command = input[0];
        String teamName = input[1];
        switch (command) {
            case "Team":
                createNewTeam(teamName);
                break;
            case "Add":
                addPlayerToExistingTeam(teamName);
                break;
            case "Remove":
                removePlayerFromExistingTeam(teamName);
                break;
            case "Rating":
                showTeamRating(teamName);
                break;
        }
    }

    private static void showTeamRating(String teamName) {
        if (!teams.containsKey(teamName)){
            throw new IllegalArgumentException(String.format(ExceptionMessages.TEAM_DOES_NOT_EXIST, teamName));
        }
        temporaryTeam = teams.get(teamName);
        System.out.println(teamName + " - " + Math.round(temporaryTeam.getRating()));
    }

    private static void removePlayerFromExistingTeam(String teamName) {
        if (!teams.containsKey(teamName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.TEAM_DOES_NOT_EXIST, teamName));
        }
        String playerName = input[2];
        temporaryTeam = teams.get(teamName);
        temporaryTeam.removePlayer(playerName);
    }

    private static void addPlayerToExistingTeam(String teamName) {
        if (!teams.containsKey(teamName)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.TEAM_DOES_NOT_EXIST, teamName));
        }
        temporaryTeam = teams.get(teamName);

        String playerName = input[2];
        int endurance = Integer.parseInt(input[3]);
        int sprint = Integer.parseInt(input[4]);
        int dribble = Integer.parseInt(input[5]);
        int passing = Integer.parseInt(input[6]);
        int shooting = Integer.parseInt(input[7]);

        Player newPlayer = new Player(playerName, endurance, sprint, dribble, passing, shooting);

        temporaryTeam.addPlayer(newPlayer);
    }

    private static void createNewTeam(String teamName) {
        teams.putIfAbsent(teamName, new Team(teamName));
    }

    private static void readFromConsole(Scanner scanner) {
        input = scanner.nextLine().split(";");
    }

}
