package main.commands.impl.queue;

import java.util.LinkedList;
import java.util.List;

import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Member;
import main.Bot;
import main.commands.Command;
import reactor.core.publisher.Mono;

public class Join extends Command
{

	@Override
	public Mono<Void> execute(Bot bot, MessageCreateEvent event)
	{
		List<Member> members = new LinkedList<>();
		if (event.getMessage().getUserMentions().hasElements().block())
		{
			event.getMessage().getUserMentions().buffer().blockFirst()
					.forEach(user -> members.add(user.asMember(event.getGuildId().get()).block()));
		} else
		{
			members.add(event.getMember().get());
		}
		members.forEach(member ->
		{
			if (!bot.getQueue().contains(member))
			{
				bot.getQueue().offer(member);

			}
		});
		return bot.getQueue().getQueueMessage(bot, event);
	}

	@Override
	public String description()
	{
		return null;
	}

}
