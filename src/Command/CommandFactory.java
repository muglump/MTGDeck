package Command;


	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	import java.util.Scanner;

public class CommandFactory {
		
		@SuppressWarnings("resource")
		public static Commands createCommand(String commandName) {
			if (("SEARCH").equals(commandName)) {
				return new CommandSearch();
			}
			
			if (("DISPLAY").equals(commandName)) {
				return new CommandDisplay();
			}
			
			
			return null;
		}


		public static boolean runCommand(String name, List<String> arguments) {
			Commands command = createCommand(name);
			
			if (command != null) {
				
				return true;
			}
			
			return false;
		}

	}

