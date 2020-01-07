package main.commands.impl;

import java.util.Random;

import discord4j.core.event.domain.message.MessageCreateEvent;
import main.Bot;
import main.commands.Command;


public class Flip extends Command
{

	@Override
	public void execute(Bot bot, MessageCreateEvent event)
	{
		// TODO Auto-generated method stub
		Random random = new Random();
		int num = random.nextInt(100);
		if (num == 0)
		{
			
		}
		else if (num % 2 == 1)
		{
			
		}
		else
		{
			
		}
	}

	@Override
	public String description()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
