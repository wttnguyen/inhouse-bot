package main.commands.impl;

import discord4j.core.event.domain.message.MessageCreateEvent;
import main.Bot;
import main.commands.Command;
import reactor.core.publisher.Mono;

public class Choose extends Command
{

	@Override
	public Mono<Void> execute(Bot bot, MessageCreateEvent event)
	{
		String message = event.getMessage().getContent().get();
		String[] choices = message.split(",");
		return event.getMessage().getChannel()
				.flatMap(channel -> channel.createMessage(choices[bot.getRandom().nextInt(choices.length)].trim()))
				.then();
	}

	@Override
	public String description()
	{
		return null;
	}

}
