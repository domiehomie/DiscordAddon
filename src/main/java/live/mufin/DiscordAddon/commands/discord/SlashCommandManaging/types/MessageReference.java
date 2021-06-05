package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

public class MessageReference {
    String message_id;
    String channel_id;
    String guild_id;
    boolean fail_if_not_exists;

    public String getMessage_id() {
        return message_id;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public String getGuild_id() {
        return guild_id;
    }

    public boolean isFail_if_not_exists() {
        return fail_if_not_exists;
    }

    @Override
    public String toString() {
        return "MessageReference{" + "message_id='" + message_id + '\'' + ", channel_id='" + channel_id + '\''
                + ", guild_id='" + guild_id + '\'' + ", fail_if_not_exists=" + fail_if_not_exists + '}';
    }
}
