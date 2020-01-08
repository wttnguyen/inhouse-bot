package main;

import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Member;
import reactor.core.publisher.Mono;

public class InhouseQueue
{

	private String			gamingTime;

	private Queue<Member>	queue		= new LinkedList<>();

	private int				position	= 1;

	public boolean contains(Member member)
	{
		return queue.contains(member);
	}

	public void offer(Member member)
	{
		queue.offer(member);
	}

	public Member next()
	{
		return queue.poll();
	}

	public void remove(Member member)
	{
		queue.remove(member);
	}

	public void clear()
	{
		queue.clear();
	}

	public Mono<Void> getQueueMessage(Bot bot, MessageCreateEvent event)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("**Gaming Time**: " + bot.getQueue().getGamingTime() + "\n\n");

		bot.getQueue().getMembers().forEachRemaining(m ->
		{
			builder.append("**#").append(position++).append("** : ").append(m.getNickname().orElse(m.getDisplayName()))
					.append('\n');
		});
		position = 1;
		return event.getMessage().getChannel().flatMap(channel -> channel
				.createEmbed(embed -> embed.setColor(Color.GREEN).setDescription(builder.toString())).then());
	}

	public Iterator<Member> getMembers()
	{
		return queue.iterator();
	}

	public void setGamingTime(String gamingTime)
	{
		this.gamingTime = gamingTime;
	}

	public String getGamingTime()
	{
		return gamingTime;
	}

}
