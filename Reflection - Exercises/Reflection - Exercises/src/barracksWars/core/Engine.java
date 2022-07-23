package barracksWars.core;

import barracksWars.core.commands.Command;
import barracksWars.core.commands.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;
	private static final String COMMANDS_PACKAGE_NAME =
			"barracksWars.core.commands.";

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		String commandNameParsed = Character.toUpperCase(commandName.toCharArray()[0]) + commandName.substring(1);
		Class<?> commandClass = Class.forName(COMMANDS_PACKAGE_NAME + commandNameParsed);
		Constructor<?> commandConstructor = commandClass.getDeclaredConstructor(String[].class);
		commandConstructor.setAccessible(true);
		Command command = (Command) commandConstructor.newInstance((Object) data);
		declareCommandFields(commandClass, command);
		return command.execute();
	}

	private void declareCommandFields(Class<?> commandClass, Command command) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		List<Field> commandClassInjectFields = Arrays.stream(commandClass.getDeclaredFields()).filter(field -> field.getAnnotations()[0] instanceof Inject).collect(Collectors.toList());
		for (Field commandClassInjectField : commandClassInjectFields) {
			commandClassInjectField.setAccessible(true);
			if (commandClassInjectField.getType().getSimpleName().equals("Repository")){
				commandClassInjectField.set(command, this.repository);
			} else if (commandClassInjectField.getType().getSimpleName().equals("UnitFactory")){
				commandClassInjectField.set(command, this.unitFactory);
			}
		}
	}

}
