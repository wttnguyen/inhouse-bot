package main.commands;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import main.Bot;
import main.commands.impl.Choose;
import main.commands.impl.Flip;

public class CommandsManager
{

	private Map<String, Command> commands = new HashMap<>();
	
	public CommandsManager()
	{
		commands.put("flip", new Flip());
		commands.put("choose", new Choose());
	}
	
	public Map<String, Command> getCommands()
	{
		return Collections.unmodifiableMap(commands);
	}
	
}
