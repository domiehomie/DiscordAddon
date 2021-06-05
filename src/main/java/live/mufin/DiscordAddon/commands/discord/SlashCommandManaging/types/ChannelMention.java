package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

public class ChannelMention {
    String id;
    String guild_id;
    int type;
    String name;

    public String getId() {
        return id;
    }

    public String getGuild_id() {
        return guild_id;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ChannelMention{" + "id='" + id + '\'' + ", guild_id='" + guild_id + '\'' + ", type=" + type + ", name='"
                + name + '\'' + '}';
    }
}
