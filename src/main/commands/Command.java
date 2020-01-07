package main.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;
import main.Bot;

public abstract class Command
{

	public abstract void execute(Bot bot, MessageCreateEvent event);

	public abstract String description();
}
