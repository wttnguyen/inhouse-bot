package main.commands.impl;

<<<<<<< HEAD
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
=======
import java.awt.Color;
>>>>>>> 69720ed01ad936b20a06d307a396bf4fe9dc2335

import javax.imageio.ImageIO;

import discord4j.core.event.domain.message.MessageCreateEvent;
import main.Bot;
import main.commands.Command;
import reactor.core.publisher.Mono;

public class Flip extends Command
{

	@Override
	public Mono<Void> execute(Bot bot, MessageCreateEvent event)
	{
<<<<<<< HEAD
		Random random = new Random();
		int num = random.nextInt(100);
		Image choice;
		if (num == 0)
		{
			try
			{
				choice = ImageIO.read(new File("./assets/images/memes/sides.gif"));
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else if (num % 2 == 1)
		{
			try
			{
				choice = ImageIO.read(new File("./assets/images/memes/heads.jpg"));
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				choice = ImageIO.read(new File("./assets/images/memes/tails.png"));
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		event.getMessage().getChannel().flatMap(channel->channel.createEmbed(spec))
=======
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
>>>>>>> 69720ed01ad936b20a06d307a396bf4fe9dc2335
	}

	@Override
	public String description()
	{
		return null;
	}

}
