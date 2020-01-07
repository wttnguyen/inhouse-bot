package main.commands.impl;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import discord4j.core.event.domain.message.MessageCreateEvent;
import main.Bot;
import main.commands.Command;


public class Flip extends Command
{

	@Override
	public void execute(Bot bot, MessageCreateEvent event)
	{
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
	}

	@Override
	public String description()
	{
		return null;
	}

}
