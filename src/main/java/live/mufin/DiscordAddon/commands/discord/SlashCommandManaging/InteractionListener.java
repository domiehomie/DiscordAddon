package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Interaction;

public interface InteractionListener {
    void onInteraction(Interaction interaction);

}