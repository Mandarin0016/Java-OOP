package militaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Private> PRIVATES = new ArrayList<>();
    private static final List<LieutenantGeneral> LIEUTENANTS = new ArrayList<>();
    private static final List<Engineer> ENGINEERS = new ArrayList<>();
    private static final List<Commando> COMMANDOS = new ArrayList<>();
    private static final List<Spy> SPIES = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static String[] data = null;

    public static void main(String[] args) throws Exception {
        executeCommand();
        while (!data[0].equals("End")) {
            createSubject();
            executeCommand();
        }
    }

    private static void createSubject() throws Exception {
        switch (data[0]) {
            case "Private":
                createPrivate();
                break;
            case "LieutenantGeneral":
                createLieutenantGeneral();
                break;
            case "Engineer":
                try {
                    createEngineer();
                } catch (Exception e) {
                    break;
                }
                break;
            case "Commando":
                createCommando();
                break;
            case "Spy":
                createSpy();
                break;
        }
    }

    private static void createSpy() {
        Spy spy = new SpyImpl(
                Integer.parseInt(data[1]),
                data[2],
                data[3],
                data[4]);
        System.out.println(spy);
        SPIES.add(spy);
    }

    private static void createCommando() throws Exception {
        Commando commando = new CommandoImpl(
                Integer.parseInt(data[1]),
                data[2],
                data[3],
                Double.parseDouble(data[4]), data[5]);
        for (int i = 6; i < data.length; i += 2) {
            String codeName = data[i];
            String state = data[i + 1];
            try {
                Mission mission = new MissionImpl(codeName, state);
                commando.addMission(mission);
            }catch (Exception ignored){
            }
        }
        System.out.println(commando);
        COMMANDOS.add(commando);
    }

    private static void createEngineer() throws Exception {
        Engineer engineer = new EngineerImpl(
                Integer.parseInt(data[1]),
                data[2],
                data[3],
                Double.parseDouble(data[4]), data[5]);
        for (int i = 6; i < data.length; i += 2) {
            String repairPart = data[i];
            int hoursTook = Integer.parseInt(data[i + 1]);
            Repair repair = new RepairImpl(repairPart, hoursTook);
            engineer.addRepair(repair);
        }
        System.out.println(engineer);
        ENGINEERS.add(engineer);
    }

    private static void createLieutenantGeneral() {
        LieutenantGeneral newLieutenantGeneral = new LieutenantGeneralImpl(
                Integer.parseInt(data[1]),
                data[2],
                data[3],
                Double.parseDouble(data[4]));
        for (int i = 5; i < data.length; i++) {
            int id = Integer.parseInt(data[i]);
            for (Private aPrivate : PRIVATES) {
                if (aPrivate.getId() == id) {
                    newLieutenantGeneral.addPrivate(aPrivate);
                    break;
                }
            }
        }
        System.out.println(newLieutenantGeneral);
        LIEUTENANTS.add(newLieutenantGeneral);
    }

    private static void createPrivate() {
        Private newPrivate = new PrivateImpl(
                Integer.parseInt(data[1]),
                data[2],
                data[3],
                Double.parseDouble(data[4]));
        System.out.println(newPrivate);
        PRIVATES.add(newPrivate);
    }

    private static void executeCommand() {
        data = scanner.nextLine().split(" ");
    }
}
