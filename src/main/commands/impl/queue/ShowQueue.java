package main.commands.impl.queue;

import discord4j.core.event.domain.message.MessageCreateEvent;
import main.Bot;
import main.commands.Command;
import reactor.core.publisher.Mono;

public class ShowQueue extends Command
{

	@Override
	public Mono<Void> execute(Bot bot, MessageCreateEvent event)
	{
		return bot.getQueue().getQueueMessage(bot, event);
	}

	@Override
	public String description()
	{
		return null;
	}

}
