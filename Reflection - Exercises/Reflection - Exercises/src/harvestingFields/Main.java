package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {

	private static final Scanner scanner = new Scanner(System.in);
	private static String[] data = null;
	private static final Map<String, List<Field>> solidLandFields = new HashMap<>();

	public static void main(String[] args) {

		initializeEntries();
		getClassFields();

		executeCommand();
		while (!data[0].equals("HARVEST")){
			parseCommand(data[0]);
			executeCommand();
		}

	}

	private static void initializeEntries(){
		solidLandFields.put("private", new ArrayList<>());
		solidLandFields.put("protected", new ArrayList<>());
		solidLandFields.put("public", new ArrayList<>());
		solidLandFields.put("all", new ArrayList<>());
	}
	private static void getClassFields() {
		Arrays.stream(RichSoilLand.class.getDeclaredFields()).forEach(field -> {
			if (Modifier.isPrivate(field.getModifiers())){
				solidLandFields.get("private").add(field);
			}else if (Modifier.isProtected(field.getModifiers())){
				solidLandFields.get("protected").add(field);
			}else if (Modifier.isPublic(field.getModifiers())){
				solidLandFields.get("public").add(field);
			}
			solidLandFields.get("all").add(field);
		});
	}

	private static void parseCommand(String command) {
		solidLandFields.get(command).forEach(field -> System.out.printf("%s %s %s%n", command.equals("all") ? Modifier.toString(field.getModifiers()) : command, field.getType().getSimpleName(), field.getName()));
	}

	private static void executeCommand() {
		data = scanner.nextLine().split(" ");
	}


}
