package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.InteractionType;

public class MessageInteraction {
    String id;
    InteractionType type;
    String name;
    User user;

    public String getId() {
        return id;
    }

    public InteractionType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "MessageInteraction{" + "id='" + id + '\'' + ", type=" + type + ", name='" + name + '\'' + ", user="
                + user + '}';
    }
}
