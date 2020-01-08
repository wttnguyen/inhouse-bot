package main.commands.impl.queue;

import discord4j.core.event.domain.message.MessageCreateEvent;
import main.Bot;
import main.commands.Command;
import reactor.core.publisher.Mono;

public class StartQueue extends Command
{

	@Override
	public Mono<Void> execute(Bot bot, MessageCreateEvent event)
	{
		bot.getQueue().clear();
		
		String message = event.getMessage().getContent().get();
		bot.getQueue().setGamingTime(message.substring(message.indexOf(' ')));
		
		return event.getMessage().getChannel()
				.flatMap(channel -> channel.createMessage("Time for 10 mans! Join the lobby @here!")).then();
	}

	@Override
	public String description()
	{
		return null;
	}

}
