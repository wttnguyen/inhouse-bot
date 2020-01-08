package main.commands;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import main.commands.impl.Choose;
import main.commands.impl.Flip;
import main.commands.impl.queue.Drop;
import main.commands.impl.queue.Join;
import main.commands.impl.queue.SetQueueTime;
import main.commands.impl.queue.StartQueue;

public class CommandsManager
{

	private Map<String, Command> commands = new HashMap<>();

	public CommandsManager()
	{
		commands.put("flip", new Flip());
		commands.put("choose", new Choose());

		Command join = new Join();
		commands.put("join", join);
		commands.put("add", join);

		Command drop = new Drop();
		commands.put("drop", drop);
		commands.put("leave", drop);
		commands.put("remove", drop);
		
		Command setQueueTime = new SetQueueTime();
		commands.put("queuetime", setQueueTime);
		commands.put("qtime", setQueueTime);
		commands.put("q", setQueueTime);
		
		commands.put("leggo", new StartQueue());
	}

	public Map<String, Command> getCommands()
	{
		return Collections.unmodifiableMap(commands);
	}

}
