package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.EmbedBuilder;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds.Embed;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds.EmbedFooter;

public class ErrorEmbedBuilder extends EmbedBuilder {
    public Embed build(String error) {
        return this.setColor(0xFF0000).setTitle("Error: ").setDescription(error)
                .setFooter(new EmbedFooter("mufin.live", null)).build();
    }
}
