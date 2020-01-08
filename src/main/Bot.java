package main;

import java.util.Map;
import java.util.Random;

import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.message.MessageCreateEvent;
import main.commands.Command;
import main.commands.CommandsManager;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Bot
{

	private Random			random	= new Random();

	private DiscordClient	discord;

	private CommandsManager	manager	= new CommandsManager();

	private InhouseQueue	queue	= new InhouseQueue();

	public static void main(String[] args)
	{
		Bot bot = new Bot();
		bot.discord = new DiscordClientBuilder(args[0]).build();
		Map<String, Command> commands = bot.manager.getCommands();
		bot.discord.getEventDispatcher().on(MessageCreateEvent.class).flatMap(event ->
		{
			return Mono.justOrEmpty(event.getMessage().getContent())
					.flatMap(content -> Flux.fromIterable(commands.entrySet())
							.filter(entry -> content.startsWith('!' + entry.getKey()))
							.flatMap(entry -> entry.getValue().execute(bot, event)).next());
		}).subscribe();
		bot.discord.login().block();
	}

	public Random getRandom()
	{
		return random;
	}

	public InhouseQueue getQueue()
	{
		return queue;
	}

}
