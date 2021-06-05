package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds.Embed;

public class InteractionApplicationCommandCallbackData {
    boolean tts;
    String content;
    Embed[] embeds;
    int flags;

    public InteractionApplicationCommandCallbackData(boolean tts, String content, Embed[] embeds, int flags) {
        this.tts = tts;
        this.content = content;
        this.embeds = embeds;
        this.flags = flags;
    }
}
