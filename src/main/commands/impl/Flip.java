package main.commands.impl;

import java.awt.Color;

import discord4j.core.event.domain.message.MessageCreateEvent;
import main.Bot;
import main.commands.Command;
import reactor.core.publisher.Mono;

public class Flip extends Command
{

	@Override
	public Mono<Void> execute(Bot bot, MessageCreateEvent event)
	{
		double num = bot.getRandom().nextDouble();
		return event.getMessage().getChannel().flatMap(channel -> channel.createEmbed(embed ->
		{
			if (num == 0.50)
			{
				embed.setImage("https://i.imgur.com/P3EbqRH.gif").setColor(Color.GREEN).setTitle("Sides");
			} else if (num < 0.50)
			{
				embed.setImage("https://cdn.discordapp.com/attachments/602376454491078659/659905323217322021/image0.jpg").setColor(Color.ORANGE).setTitle("Heads");
			} else
			{
				embed.setImage("https://cdn.discordapp.com/attachments/663534641164320801/663956797048225804/unknown.png").setColor(Color.BLUE).setTitle("Tails");
			}
		})).then();
	}

	@Override
	public String description()
	{
		return null;
	}

}
