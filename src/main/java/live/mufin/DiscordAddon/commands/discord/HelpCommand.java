package live.mufin.DiscordAddon.commands.discord;

import java.util.ArrayList;
import java.util.List;

import live.mufin.DiscordAddon.Main;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.InteractionListener;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.InteractionCallbackType;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.SlashCommandHandler;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.SlashCommandHandler.ResponseCommand;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.SlashCommandHandler.ResponseOption;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.EmbedBuilder;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Interaction;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.InteractionApplicationCommandCallbackData;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.InteractionResponse;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds.Embed;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds.EmbedField;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds.EmbedFooter;

public class HelpCommand implements InteractionListener {

	@Override
	public void onInteraction(Interaction interaction) {
		if (!interaction.getData().getName().equals("help"))
			return;

		if (interaction.getData().getOptions() == null) {
			EmbedBuilder builder = new EmbedBuilder().setColor(0x0652DD).setTitle("DiscordAddon commands:")
					.setDescription("`Pro tip: you can do /help [command] to get more info!`")
					.setFooter(new EmbedFooter("mufin.live", null));
			List<EmbedField> fields = new ArrayList<EmbedField>();
			for (ResponseCommand cmd : SlashCommandHandler.getCommands(Main.botKey, Main.jda.getSelfUser().getId())) {
				EmbedField field = new EmbedField(cmd.getName(), cmd.getDescription(), false);
				fields.add(field);
			}

			EmbedField[] fieldsarr = fields.stream().toArray(EmbedField[]::new);
			builder.setFields(fieldsarr);

			interaction.send(new InteractionResponse(InteractionCallbackType.CHANNEL_MESSAGE_WITH_SOURCE,
					new InteractionApplicationCommandCallbackData(false, null, new Embed[] { builder.build() }, 64)),
					Main.botKey);
		} else {
			for (ResponseCommand cmd : SlashCommandHandler.getCommands(Main.botKey, Main.jda.getSelfUser().getId())) {
				if (cmd.getName().equals(interaction.getData().getOptions()[0].getValue())) {
					String usage = "/" + cmd.getName();
					String optionString = "";

					for (ResponseOption option : cmd.getOptions()) {
						if (option.isRequired())
							usage = usage + " <" + option.getName() + ">";
						else if (option.getType() == 0)
							usage = usage + " | " + option.getName();
						else
							usage = usage + " [" + option.getName() + "]";

						optionString = optionString + "`" + option.getName() + "`: " + option.getDescription() + "\n";
					}

					EmbedBuilder builder = new EmbedBuilder().setTitle(cmd.getName() + ":")
							.setFields(new EmbedField[] { new EmbedField("Description: ", cmd.getDescription(), false),
									new EmbedField("Usage:", "`" + usage + "`", false),
									new EmbedField("Options", optionString, false) })
							.setColor(0x5758BB).setFooter(new EmbedFooter("mufin.live", null));
					interaction.send(new InteractionResponse(InteractionCallbackType.CHANNEL_MESSAGE_WITH_SOURCE,
							new InteractionApplicationCommandCallbackData(false, null, new Embed[] { builder.build() },
									64)),
							Main.botKey);
				}
			}
		}
	}

}
