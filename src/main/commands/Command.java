package main.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;
import main.Bot;
import reactor.core.publisher.Mono;

public abstract class Command
{

	public abstract Mono<Void> execute(Bot bot, MessageCreateEvent event);

	public abstract String description();
	
}
