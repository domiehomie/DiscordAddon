package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.InteractionCallbackType;

public class InteractionResponse {
    int type;

    InteractionApplicationCommandCallbackData data;

    public InteractionResponse(InteractionCallbackType type, InteractionApplicationCommandCallbackData data) {
        this.type = type.type;
        this.data = data;
    }
}
